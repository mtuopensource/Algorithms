CFLAGS = -pedantic -Wall -Wextra -O1 
OBJECT = BubbleSort.o Test.c

all: test
test: BubbleSort.o
	gcc $(CFLAGS) -o test $(OBJECT)

BubbleSort.o: BubbleSort.c
	gcc -c $(CFLAGS) BubbleSort.c

.PHONY: clean
clean:
	rm *.o test
