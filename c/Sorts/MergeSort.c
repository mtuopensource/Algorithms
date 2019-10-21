void merge(int *array, int left, int middle, int right) {
	int i, j, k;

	int n1 = middle - left + 1;
	int n2 = right - middle;

	int lArray[n1], rArray[n2];

	for (i = 0; i < n1; i++) 
		lArray[i] = array[left + i];
	for (j = 0; j < n2; j++)
		rArray[j] = array[middle + 1 + j];

	i = 0;
	j = 0;
	k = left;

	while (i < n1 && j < n2) {
		if (lArray[i] <= rArray[j]) {
			array[k] = lArray[i];
			i++;
		} else {
			array[k] = rArray[j];
			j++;
		}
		k++;
	}

	while (i < n1) {
		array[k] = lArray[i];
		i++;
		k++;
	}
	while (j < n2) {
		array[k] = rArray[j];
		j++;
		k++;
	}
}

void mergeSort(int *array, int left, int right) {
	if (left < right) {
		int middle = left + (right - left) / 2;
		mergeSort(array, left, middle);
		mergeSort(array, middle + 1, right);

		merge(array, left, middle, right);
	}
}
