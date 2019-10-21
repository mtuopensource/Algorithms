CFLAGS = -std=c99 -pedantic -Wall -Wextra -O1 
OBJECT = BubbleSort.o SelectionSort.o Test.c

all: test
test: BubbleSort SelectionSort
	gcc $(CFLAGS) -o test $(OBJECT)

BubbleSort: BubbleSort.c
	gcc -c $(CFLAGS) BubbleSort.c
SelectionSort: SelectionSort.c
	gcc -c $(CFLAGS) SelectionSort.c

.PHONY: clean
clean:
	rm *.o test
