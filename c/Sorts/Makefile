CFLAGS = -std=c99 -pedantic -Wall -Wextra -O1 
OBJECT = BubbleSort.o SelectionSort.o InsertionSort.o MergeSort.o Test.c

all: test
test: BubbleSort SelectionSort InsertionSort MergeSort
	gcc $(CFLAGS) -o test $(OBJECT)

BubbleSort: BubbleSort.c
	gcc -c $(CFLAGS) BubbleSort.c
SelectionSort: SelectionSort.c
	gcc -c $(CFLAGS) SelectionSort.c
InsertionSort: InsertionSort.c
	gcc -c $(CFLAGS) InsertionSort.c
MergeSort: MergeSort.c
	gcc -c $(CFLAGS) MergeSort.c

.PHONY: clean
clean:
	rm *.o test
