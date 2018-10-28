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
