package club.mtuopensource.algorithms.sort;
import java.util.ArrayList;

/**
 * Sorts an array using the Selection Sort algorithm
 * @author Isaac Smith
 * Last Modified: 10 - 02 - 19
 */
public class SelectionSort<E extends Comparable<E>> implements ISort<E> {

	/**
	 * Implemented sort() method from package
	 */
	public void sort(ArrayList<E> array) {
		for (int i = 0; i < array.size() - 1; i++) {
			// Find min of initial unsorted array
			int minIndex = i;
			for (int j = i + 1; j < array.size(); j++) {
				if (array.get(j).compareTo(array.get(minIndex)) < 0)
					minIndex = j;
			}
			E temp = array.get(minIndex);
			array.set(minIndex, array.get(i));
			array.set(i, temp);
		}
	}
}
