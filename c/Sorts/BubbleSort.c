/**
 * BubbleSort
 * Sorts an array of integers
 * array: the array of integers to be sorted
 * length: the length of the array
 */ 
void bubbleSort(int *array, int length) {
	int i;
	int j;
	for (i = 0; i < length; i++) {
		for (j = 0; j < length; j++) {
			if (array[j] > array[j + 1]) {
				int temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
	}
}
