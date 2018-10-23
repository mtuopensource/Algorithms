package club.mtuopensource.algorithms.sort;
import java.util.ArrayList;

/**
 * Sorts an array using QuickSort
 * @author Alec Rospierski
 * Last Modified: 3 - 1 - 18
 * @param <E> type of data to be sorted
 */
public class QuickSort<E extends Comparable<E>> implements ISort<E> {

	public void sort(ArrayList<E> array) {
		/* TCJ
		 * O(nlog(n))
		 * calls the quickSort method which has a worst case of O(nlog(n))
		 */
		quickSort(array, 0, array.size() - 1);
	}

	/**
	 * A recursive helper method for sort that uses the QuickSort algorithm
	 * @param array the array to be sorted
	 * @param l lowest index
	 * @param r highest index
	 */
	private void quickSort(ArrayList<E> array, int l, int r) {
		/* TCJ
		 * O(nlog(n))
		 * recursively calls quickSort log(n) times and calls partition with a worst case of O(n)
		 * therefore it has a worst case of O(nlog(n))
		 */
		if (l < r) {
			int p = partition(array, l, r);
			quickSort(array, l, p - 1);
			quickSort(array, p + 1, r);
		}
	}

	/**
	 * Partitions the data in an array
	 * @param array
	 * @param l the lowest index
	 * @param r the highest index
	 * @return the index for the partition
	 */
	private int partition(ArrayList<E> array, int l, int r) {
		/* TCJ
		 * O(n)
		 * has a for loop that can run n times
		 * therefore has a worst case of O(n)
		 */
		int i = l - 1;
		E x = array.get(r);

		for (int j = l; j < r; j++) {
			if (array.get(j).compareTo(x) <= 0) {
				E temp = array.get(j);
				array.set(j, array.get(i+1));
				array.set(i+1, temp);
				i++;
			}
		}
		E temp = array.get(r);
		array.set(r, array.get(i+1));
		array.set(i+1, temp);
		return i + 1;
	}
}
