package club.mtuopensource.algorithms.sort;

/**
 * Sorts an array using the MergeSort algorithm
 * @author Isaac Smith
 * Last Modified: 10 - 23 - 18
 * @param <E> type of data to be sorted
 */
public class MergeSort<E extends Comparable<E>> implements ISort<E> {

	/**
	 * Implementied sort() method from package
	 */
	public void sort(E[] array) {
		//TODO:Add call to mergesort
	}

	/**
	 *	Merges 2 sorted halves into a sorted array
	 * 	@param array - array being sorted
	 *	@param left - left index of array
	 *	@param mid - middle index of array
	 *	@param right - right index of array
	 */
	private void merge(E[] array, int left, int mid, int right) {
		int len1 = mid - left + 1;	//length of left half
		int len2 = right - mid;		//length of right half
		E arr1[] = new E[len1];		//left half
		E arr2[] = new E[len2];		//right half
		int i, j, k;	//index variables

		// Copy data into temp arrays
		for (i = 0; i < len1; i++){
			arr1[i] = array[left+i];
		}
		for (j = 0; j < len1; j++){
			arr2[j] = array[mid+1 + j];
		}

		i = 0;
		j = 0;
		k = l;
		// Merge arrays into single array
		while (i < len1 && j < len2) {
			if (arr1[i].compareTo(arr2[j]) <= 0) {
				array[k++] = arr1[i++];
			} else {
				array[k++] = arr2[j++];
			}
		}
		// Copy the rest of arr1 if arr2 is empty
		while (i < len1) {
			array[k++] = arr1[i++];
		}
		// Copy the rest of arr2 if arr1 is empty
		while (j < len2) {
			array[k++] = arr2[j++];
		}
	}

	/**
	 *	Sorts an array using the mergesort algorithm
	 * 	@param array - array to be sorted
	 *	@param left - left index of array
	 *	@param right - right index of array
	 */
	private void mergeSort(E[] array, int left, int right) {
		if (left < r) {
			int midm = (left + right)/2;

			//Split into halves and sort, then merge sorted halves
			mergeSort(array, left, mid);
			mergesort(array, mid+1, right);
			merge(array, left, mid, right);
		}
	}

}
