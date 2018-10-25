package club.mtuopensource.algorithms.search;

import java.util.List;

public class LinearSearch<T extends Comparable<T>> implements ISearch<T> {

    /**
     * LinearSearch
     * Sequentially compares each element of the array with the key. Continues
     * until a match is found, or all elements have been searched.
     */
    @Override
    public int search(List<T> array, T key) {
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) != null && array.get(i).equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
