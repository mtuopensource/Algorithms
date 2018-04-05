package club.mtuopensource.algorithms.search;

/**
 * BinarySearch.java
 * Date Last Modified: April 5th, 2018
 * MTU Open Source Club
 * @author Javen Zamojcin
 */
public class BinarySearch<E extends Comparable<E>> implements ISearch<E> {

	public int search(E[] array, E key) {
		
		if ( array.length == 0 ) return -1;
		
		return binarySearch(array, 0, array.length - 1, key);
	}
	
	/**
	 * Performs a binary search and returns index of key
	 * Cost: O(log n)
	 * @param array: an array of comparable objects
	 * @param key: a comparable key
	 * @return index at which key is located
	 * @return -1 if array is empty or key is not found
	 */
	private int binarySearch(E[] array, int low, int high, E key) {
		
		if ( low <= high ) {
			
			int mid = (low + high) / 2;
			
			if (array[mid].compareTo(key) == 0 ) {
				
				return mid;
				
			} else if ( key.compareTo(array[mid]) < 0 ) {
				
				return binarySearch(array, low, mid - 1, key);
				
			} else {
				
				return binarySearch(array, mid + 1, high, key);
				
			}
			
		} else {
			
			return -1;
			
		}
	}
}
