package club.mtuopensource.algorithms.sort;

/**
 * Sorts an array using QuickSort
 * @author Alec Rospierski
 * Last Modified: 3 - 1 - 18
 * @param <E> type of data to be sorted
 */
public class QuickSort<E extends Comparable<E>> implements ISort<E> {

	public void sort(E[] array) {
		/* TCJ
		 * O(nlog(n))
		 * calls the quickSort method which has a worst case of O(nlog(n))
		 */
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * A recursive helper method for sort that uses the QuickSort algorithm
	 * @param array the array to be sorted
	 * @param l lowest index
	 * @param r highest index
	 */
	private void quickSort(E[] array, int l, int r) {
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
	private int partition(E[] array, int l, int r) {
		/* TCJ
		 * O(n)
		 * has a for loop that can run n times
		 * therefore has a worst case of O(n)
		 */
		int i = l - 1;
		E x = array[r];

		for (int j = l; j < r; j++) {
			if (array[j].compareTo(x) <= 0) {
				E temp = array[j];
				array[j] = array[i + 1];
				array[i + 1] = temp;
				i++;
			}
		}
		E temp = array[r];
		array[r] = array[i + 1];
		array[i + 1] = temp;
		return i + 1;
	}
}
