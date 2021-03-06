#include <stdio.h>

void bubbleSort(int *array, int length);
void selectionSort(int *array, int length);
void insertionSort(int *array, int length);
void mergeSort(int *array, int left, int right);

void printArray(int *array, int length) {
	int i;
	for (i = 0; i < length; i++) {
		printf("%d ", array[i]);
	}
}

int main(void) {
	int arrayOne[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	int arrayOneLength = 10;
    int arrayTwo[] = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
    int arrayTwoLength = 10;
	int arrayThree[] = {23, 45, 12, 0, 1, 99, 88, 77, 44, 100};
	int arrayThreeLength = 10;
	int arrayFour[] = {23, 45, 12, 0, 1, 99, 88, 77, 44, 100};
	int arrayFourLength = 10;

	printf("---Bubble Sort Array Test One---\n");
	printf("Unsorted: \n");
	printArray(arrayOne, arrayOneLength);	
	printf("\nSorted: \n");
	bubbleSort(arrayOne, arrayOneLength);
	printArray(arrayOne, arrayOneLength);

    printf("\n\n\n");

    printf("---Selection Sort Array Test One---\n");
    printf("Unsorted: \n");
	printArray(arrayTwo, arrayTwoLength);	
	printf("\nSorted: \n");
	selectionSort(arrayTwo, arrayTwoLength);
	printArray(arrayTwo, arrayTwoLength);	
    
	printf("\n\n\n");

	printf("---Insertion Sort Array Test One---\n");
	printf("Unsorted: \n");
	printArray(arrayThree, arrayThreeLength);	
	printf("\nSorted: \n");
	insertionSort(arrayThree, arrayThreeLength);
	printArray(arrayThree, arrayThreeLength);

	printf("\n\n\n");
	
	printf("---Merge Sort Array Test One---\n");
	printf("Unsorted: \n");
	printArray(arrayFour, arrayFourLength);	
	printf("\nSorted: \n");
	mergeSort(arrayFour, 0, arrayFourLength - 1);
	printArray(arrayFour, arrayFourLength);


	printf("\n");
	return 0;
}
