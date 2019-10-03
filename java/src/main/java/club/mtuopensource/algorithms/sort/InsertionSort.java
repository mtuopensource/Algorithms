package club.mtuopensource.algorithms.sort;
import java.util.ArrayList;

/**
 * Sorts an array using the Insertion Sort algorithm
 * @author Isaac Smith
 * Last Modified: 10 - 02 - 19
 */
public class InsertionSort<E extends Comparable<E>> implements ISort<E> {

	/**
	 * Implemented sort() method from package
	 */
	public void sort(ArrayList<E> array) {
		for (int i = 1; i < array.size(); i++) {
			E key = array.get(i);
			int j = i-1;
			// Move elements that are greater than key to right by one
			while( j >= 0 && array.get(j).compareTo(key) > 0) {
				array.set(j+1, array.get(j--));
			}
			array.set(j+1, key);
		}
	}


}
