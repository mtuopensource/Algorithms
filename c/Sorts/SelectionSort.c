void selectionSort(int *array, int length) {
    int i;
    int j;

    for (i = 0; i < length; i++) {
        int minimum = i;
        for (j = i + 1; j < length; j++) {
            if (array[j] < array[minimum]) {
                minimum = j;
            } 
        }
        int temp = array[i];
        array[i] = array[minimum];
        array[minimum] = temp;
    }
}
