from clean.clean import clean_data
from data.getData import pull_data
from featurize.featurize import featurize_data, reduce_features
from lsh.lsh import create_lsh_model, find_corpus_neighbors, calculate_distance


def orchestrate_plagiarism_checker(folder_name: str) -> None:
    data = pull_data(folder_name)
    data = clean_data(data)
    data = featurize_data(data)
    data = reduce_features(data)
    model = create_lsh_model(data)
    neighbors = find_corpus_neighbors(model)
    neighbors_with_distance = calculate_distance(data, neighbors)
    print(neighbors_with_distance)
    print(len(neighbors_with_distance.keys()))


    ## plot
    ## find neighbors and distances
    ## evaluate neighbors and distances


if __name__ == "__main__":
    orchestrate_plagiarism_checker('A1')
