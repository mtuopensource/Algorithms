# Python implementation for Selection Sort
def selection_sort(arr):
	for i in range(len(arr)):
		# Find min in unsorted remainder of array
		min = i
		for j in range(i+1, len(arr)):
			if arr[min] > arr[j]:
				min = j
				
		# Swap the min with first element
		arr[i], arr[min] = arr[min], arr[i]

if __name__ == "__main__":
	arr1 = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
	arr2 = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
	selection_sort(arr1)
	selection_sort(arr2)
	print(arr1)
	print(arr2)