# Python implementation for Bubble Sort
def bubble_sort(arr):
	#Traverse array
	for i in range(len(arr)):
		#Last i elems already in place
		for j in range(0, len(arr)-i-1):
            # Swap if the element > nextElement
			if arr[j] > arr[j+1]:
				arr[j], arr[j+1] = arr[j+1], arr[j]
