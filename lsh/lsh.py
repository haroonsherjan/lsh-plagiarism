from copy import copy
from itertools import combinations

import numpy as np
from pandas import DataFrame, Series
from sklearn.metrics import pairwise_distances
from featurize.featurize import reduce_features

NEIGHBOR_DISTANCE = 1
NUM_OF_BITS = 8
POWERS_OF_TWO = (1 << np.arange(NUM_OF_BITS - 1, -1, -1))
np.random.seed(0)


def create_lsh_model(data: DataFrame) -> dict:
    # Create random hyperplanes
    vectors = np.random.randn(len(data.columns), NUM_OF_BITS)
    # Find dot product of records and convert to booleans
    data_bit_booleans = data.dot(vectors) >= 0
    # Identify the decimal value of the 16 bit boolean array
    data_bits = data_bit_booleans.dot(POWERS_OF_TWO)
    # Bucket the docs into their hashed value
    bit_buckets = {}
    for index, row in data.iterrows():
        doc_bit = data_bits[index]
        if doc_bit not in bit_buckets:
            bit_buckets[doc_bit] = list()
        bit_buckets[doc_bit].append(index)
    lsh_model = {
        'vectors': vectors,
        'data': data,
        'data_bits': data_bits,
        'data_bit_booleans': data_bit_booleans,
        'bit_buckets': bit_buckets,
    }
    return lsh_model


def find_doc_neighbors(row: Series, model: dict):
    index = row['rowIndex']
    record_boolean_bits = model['data_bit_booleans'].loc[index]
    record_bits = model['data_bits'].loc[index]
    neighbors = {x for x in model['bit_buckets'][record_bits]}
    neighbors.remove(index)
    # Manipulate different combinations of the bits to look through neighbors
    for shuffled_bits in combinations(range(NUM_OF_BITS), NEIGHBOR_DISTANCE):
        opposite_bits = copy(record_boolean_bits)
        for i in shuffled_bits:
            opposite_bits[i] = not opposite_bits[i]
        neighbor_bin = opposite_bits.dot(POWERS_OF_TWO)
        if neighbor_bin in model['bit_buckets']:
            neighbors = neighbors.union({x for x in model['bit_buckets'][neighbor_bin]})
    return neighbors


def find_corpus_neighbors(model: dict) -> Series:
    data = copy(model['data'])
    data['rowIndex'] = data.index
    neighbors = data.apply(lambda row: find_doc_neighbors(row, model), axis=1)
    return neighbors


def calculate_distance(data: DataFrame, neighbors: Series):
    neighbors_with_distances = dict()
    for index, row in data.iterrows():
        row_neighbor_indices = neighbors.loc[index]
        row_columns = row[row != 0].index.values.tolist()
        if len(row_neighbor_indices) > 0:
            row_neighbors = data.loc[np.array(list(row_neighbor_indices))]
            row_neighbors_columns = reduce_features(row_neighbors).columns.values.tolist()
            comparison_columns = row_columns + row_neighbors_columns
            row = row.loc[comparison_columns]
            row_neighbors = row_neighbors[comparison_columns]
            row_neighbors['distances'] = pairwise_distances(np.reshape(row_neighbors, newshape=(len(row_neighbor_indices), -1)), np.reshape(row, newshape=(1, -1)), metric='cosine').flatten()
            neighbors_with_distances[index] = row_neighbors['distances'].to_dict()
    return neighbors_with_distances
