#include <stdio.h>

void bubbleSort(int *array, int length);

void printArray(int *array, int length) {
	int i;
	for (i = 0; i < length; i++) {
		printf("%d ", array[i]);
	}
}

int main(void) {
	int arrayOne[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	int arrayOneLength = 10;

	printf("---Array Test One---\n");
	printf("Unsorted: \n");
	printArray(arrayOne, arrayOneLength);	
	printf("\nSorted: \n");
	bubbleSort(arrayOne, arrayOneLength);
	printArray(arrayOne, arrayOneLength);

	printf("\n");
	return 0;
}
