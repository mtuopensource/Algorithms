# Python implementation for Insertion Sort
def insertion_sort(arr):
	for i in range(1, len(arr)):
		key = arr[i]
		j = i-1
		while j >= 0 and arr[j] > key:
			arr[j+1] = arr[j]
			j -= 1
		arr[j+1] = key

if __name__ == "__main__":
	arr1 = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
	arr2 = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
	insertion_sort(arr1)
	insertion_sort(arr2)
	print(arr1)
	print(arr2)