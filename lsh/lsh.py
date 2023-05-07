from copy import copy
from itertools import combinations

import numpy as np
from pandas import DataFrame, Series

NEIGHBOR_DISTANCE = 3
NUM_OF_BITS = 16
POWERS_OF_TWO = (1 << np.arange(NUM_OF_BITS - 1, -1, -1))
np.random.seed(0)


def create_lsh_model(data: DataFrame) -> dict:
    vectors = np.random.randn(len(data.columns), NUM_OF_BITS)
    # Calculate a 16 bit boolean array for each record
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
    neighbors = set()
    index = row['rowIndex']
    record_boolean_bits = model['data_bit_booleans'].loc[index]
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
