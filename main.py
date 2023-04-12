import os

from pandas import DataFrame

from clean.main import clean_data
from featurize.main import featurize_data


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
        # for testing simplicity
        break
    return DataFrame.from_dict(data=data, orient='index', columns=["text"])


def orchestrate_plagiarism_checker(folder_name: str) -> None:
    data = pull_data(folder_name)
    data = clean_data(data)
    data = featurize_data(data)
    ## plot
    ## find neighbors and distances
    ## evaluate neighbors and distances


if __name__ == "__main__":
    orchestrate_plagiarism_checker('A1')
