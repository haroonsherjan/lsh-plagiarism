from pandas import DataFrame, Series

NGRAM_SIZE = 3


def break_into_ngram(row: Series) -> list:
    result = list()
    words = row['text'].split(' ')
    for i in range(len(words)-NGRAM_SIZE):
        entry = words[i:i+NGRAM_SIZE]
        entry.sort()
        entry = ' '.join(entry)
        result.append(entry)
    return result


def find_ngrams(data: DataFrame) -> DataFrame:
    data['ngrams'] = data.apply(break_into_ngram, axis=1)
    return data


def featurize_data(data: DataFrame) -> DataFrame:
    data = find_ngrams(data)
    return data
