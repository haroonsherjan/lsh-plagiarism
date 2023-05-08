import math

import pandas as pd
from pandas import DataFrame, Series


NGRAM_SIZE = 5
NGRAMS = dict()


def remove_empty_columns(column: Series) -> Series:
    column = column[column != 0]
    if column.size > 0:
        return column


def reduce_features(data: DataFrame) -> DataFrame:
    data = data.loc[:, (data != 0).any(axis=0)]
    return data


def multiply_by_idf(column: Series) -> Series:
    num_of_records_with_value = len(column.loc[lambda x: x > 0])
    return column.apply(lambda x: x * math.log((column.size / num_of_records_with_value)))


def calculate_tf(row: Series) -> Series:
    if type(row['ngrams']) is not dict:
        pass
    total = row['ngrams']['total']
    # delete total entry to prevent confusion
    del row['ngrams']['total']
    for key, val in row['ngrams'].items():
        row[key] = val / total
    return row


def calculate_tf_idf_of_ngrams(data: DataFrame) -> DataFrame:
    data = data.apply(calculate_tf, axis=1)
    # clean unnecessary columns
    data.index = data['rowIndex']
    data = data.drop(columns=['text', 'ngrams', 'rowIndex'], axis=0)
    data = data.apply(multiply_by_idf, axis=0)
    return data


def break_into_ngram(row: Series, size: int) -> dict:
    result = dict()
    result['total'] = 0
    words = row['text'].split(' ')
    for i in range(len(words)-NGRAM_SIZE):
        entry = words[i:i+NGRAM_SIZE]
        entry.sort()
        entry = ' '.join(entry)
        if entry not in result:
            result[entry] = 0
        result[entry] += 1
        result['total'] += 1
        # Prepare empty columns for later feature concat
        if entry not in NGRAMS:
            NGRAMS[entry] = [0]
    return result


def add_ngram_features(data: DataFrame) -> DataFrame:
    data['ngrams'] = data.apply(lambda x: break_into_ngram(x, len(data)), axis=1)
    data = pd.merge(left=data, right=pd.DataFrame(NGRAMS), how='cross')
    return data


def featurize_into_ngrams(data: DataFrame) -> DataFrame:
    data = add_ngram_features(data)
    data = calculate_tf_idf_of_ngrams(data)
    return data


def featurize_data(data: DataFrame) -> DataFrame:
    data = featurize_into_ngrams(data)
    return data
