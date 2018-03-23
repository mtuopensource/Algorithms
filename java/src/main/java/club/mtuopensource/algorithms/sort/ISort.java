package club.mtuopensource.algorithms.sort;

public interface ISort<T extends Comparable<T>> {

    /**
     * Sort
     * Sorts the given array in increasing order.
     * @param T[] array to be sorted.
     */
    void sort(T[] array);
}
