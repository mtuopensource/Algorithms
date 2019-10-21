/**
 * Insertion Sort
 * sorts an array of length integers
 * array: the array to be sorted
 * length: the length of the array
 */ 
void insertionSort(int *array, int length) {
	int key;
	for (int i = 1; i < length; i++) {
		key = array[i];
		int j = i - 1;

		while (j >= 0 && array[j] > key) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = key;
	}
}
