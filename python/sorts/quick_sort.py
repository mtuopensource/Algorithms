# Python implementation for Quick Sort
def quick_sort(arr, l, r):
	# Select a partition and divide based on value
	# Then, recursively do the same until sorted
	if l < r:
		p = partition(arr, l, r)
		quick_sort(arr, l, p-1)
		quick_sort(arr, p+1, r)

def partition(arr, l, r):
	i = l - 1		
	p = arr[r]		#pivot
	for j in range(l, r):
		if arr[j] < p:
			i = i+1 
			arr[i], arr[j] = arr[j], arr[i] 

	arr[r], arr[i+1] = arr[i+1], arr[r]
	return i+1
