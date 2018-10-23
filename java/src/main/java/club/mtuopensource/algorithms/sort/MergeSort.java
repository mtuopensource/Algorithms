package club.mtuopensource.algorithms.sort;
import java.util.ArrayList;

/**
 * Sorts an array using the MergeSort algorithm
 * @author Isaac Smith
 * Last Modified: 10 - 23 - 18
 */
public class MergeSort<E extends Comparable<E>> implements ISort<E> {

	/**
	 * Implementied sort() method from package
	 */
	public void sort(ArrayList<E> array) {
		mergeSort(array, 0, array.size()-1);
	}

	/**
	 *	Merges 2 sorted halves into a sorted array
	 * 	@param array - array being sorted
	 *	@param left - left index of array
	 *	@param mid - middle index of array
	 *	@param right - right index of array
	 */
	private void merge(ArrayList<E> array, int left, int mid, int right) {
		int len1 = mid - left + 1;	//length of left half
		int len2 = right - mid;		//length of right half
		ArrayList<E> arr1 = new ArrayList<E>();			//left half
		ArrayList<E> arr2 = new ArrayList<E>();		//right half
		int i, j, k;	//index variables

		// Copy data into temp arrays
		for (i = 0; i < len1; i++){
			arr1.add(array.get(left+i));
		}

		for (j = 0; j < len2; j++){
			arr2.add(array.get(mid+1+ j));
		}

		i = 0;
		j = 0;
		k = left;
		// Merge arrays into single array
		while (i < len1 && j < len2) {
			if (arr1.get(i).compareTo(arr2.get(j)) <= 0) {
				array.set(k++, arr1.get(i++));
			} else {
				array.set(k++, arr2.get(j++));
			}
		}

		// Copy the rest of arr1 if arr2 is empty
		while (i < len1) {
			array.set(k++, arr1.get(i++));
		}

		// Copy the rest of arr2 if arr1 is empty
		while (j < len2) {
			array.set(k++, arr2.get(j++));
		}
	}

	/**
	 *	Sorts an array using the mergesort algorithm
	 * 	@param array - array to be sorted
	 *	@param left - left index of array
	 *	@param right - right index of array
	 */
	private void mergeSort(ArrayList<E> array, int left, int right) {
		if (left < right) {
			int mid = (left + right)/2;

			//Split into halves and sort, then merge sorted halves
			mergeSort(array, left, mid);
			mergeSort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}

}
