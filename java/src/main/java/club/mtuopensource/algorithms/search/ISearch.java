package club.mtuopensource.algorithms.search;

import java.util.List;

public interface ISearch<T extends Comparable<T>> {

    /**
     * Search
     * @param List<T> list to be searched.
     * @param T   key being searched for.
     * @return the index of the key, if it exists within the list. Otherwise, -1.
     */
    int search(List<T> array, T key);
}
