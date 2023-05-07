from pandas import Series

from clean.clean import clean_data
from data.getData import pull_data
from featurize.featurize import featurize_data, reduce_features
from lsh.lsh import create_lsh_model, find_corpus_neighbors


def calculate_distance(row: Series, neighbor: Series):
    pass


def orchestrate_plagiarism_checker(folder_name: str) -> None:
    data = pull_data(folder_name)
    data = clean_data(data)
    data = featurize_data(data)
    data = reduce_features(data)
    model = create_lsh_model(data)
    neighbors = find_corpus_neighbors(model)
    neighbors_with_distances = dict()
    for index, row in data.iterrows():
        row_neighbors = neighbors.loc[index]
        neighbors_with_distances[index] = dict()
        for neighbor_index in row_neighbors:
            neighbor = data.loc[neighbor_index]
            neighbors_with_distances[index][neighbor_index] = calculate_distance(row, neighbor)


    ## plot
    ## find neighbors and distances
    ## evaluate neighbors and distances


if __name__ == "__main__":
    orchestrate_plagiarism_checker('A1')
