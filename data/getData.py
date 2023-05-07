from os import listdir
from pandas import DataFrame


def pull_data(folder_name) -> DataFrame:
    data = dict()
    for subfolder_name in listdir(f'./data/{folder_name}'):
        lines = list()
        for file_name in listdir(f'./data/{folder_name}/{subfolder_name}'):
            with open(f'./data/{folder_name}/{subfolder_name}/{file_name}', 'r') as file:
                for line in file:
                    lines.append(line)
        entry = "".join(lines)
        data[subfolder_name] = entry
    df = DataFrame.from_dict(data=data, orient='index', columns=["text"])
    return df
