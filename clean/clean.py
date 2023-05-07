from pandas import DataFrame


def clean_data(data: DataFrame) -> DataFrame:
    data['rowIndex'] = data.index
    data['text'].replace('(\\n|_|\\t|\.|\,|/|{|}|\\(|\\)|\\*|;)', ' ', regex=True, inplace=True)
    data['text'].replace('[ ][ ][ ]*', ' ', regex=True, inplace=True)
    data['text'] = data['text'].str.lower()
    return data
