package club.mtuopensource.algorithms.search;

public interface ISearch<T extends Comparable<T>> {

    /**
     * Search
     * @param T[] array to be searched.
     * @param T   key being searched for.
     * @return the index of the key, if it exists within the array. Otherwise, -1.
     */
    int search(T[] array, T key);
}
