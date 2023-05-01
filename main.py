import os

from pandas import DataFrame

from clean.clean import clean_data
from featurize.featurize import featurize_data, reduce_features


def pull_data(folder_name) -> DataFrame:
    data = dict()
    for subfolder_name in os.listdir(f'./data/{folder_name}'):
        lines = list()
        for file_name in os.listdir(f'./data/{folder_name}/{subfolder_name}'):
            with open(f'./data/{folder_name}/{subfolder_name}/{file_name}', 'r') as file:
                for line in file:
                    lines.append(line)
        entry = "".join(lines)
        data[subfolder_name] = entry
    df = DataFrame.from_dict(data=data, orient='index', columns=["text"])
    return df


def orchestrate_plagiarism_checker(folder_name: str) -> None:
    data = pull_data(folder_name)
    data = clean_data(data)
    data = featurize_data(data)
    data = reduce_features(data)
    data
    ## plot
    ## find neighbors and distances
    ## evaluate neighbors and distances


if __name__ == "__main__":
    orchestrate_plagiarism_checker('A1')
