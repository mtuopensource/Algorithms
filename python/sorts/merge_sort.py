# Python implementation for Merge Sort  
def merge(arr, l, m, r): 
	len1 = m - l + 1
	len2 = r- m 

	# temp arrays 
	left = [0] * (len1) 
	right = [0] * (len2) 

	# Copy data to temp arrays
	for i in range(0 , len1): 
		left[i] = arr[l + i] 

	for j in range(0 , len2): 
		right[j] = arr[m + 1 + j] 

	# Merge the temp arrays back to arr
	i = 0	 	# Index of left
	j = 0	 	# Index of right
	k = l 		# Index of arr

	while i < len1 and j < len2: 
		if left[i] <= right[j]: 
			arr[k] = left[i] 
			i += 1
		else: 
			arr[k] = right[j] 
			j += 1
		k += 1

	# Copy the remainder of left to arr
	while i < len1: 
		arr[k] = left[i] 
		i += 1
		k += 1

	# Copy the remainder of right to arr
	while j < len2: 
		arr[k] = right[j] 
		j += 1
		k += 1

def merge_sort(arr,l,r): 
	if l < r: 

		m = (l+(r-1))/2

		# Sort first and second halves 
		merge_sort(arr, l, m) 
		merge_sort(arr, m+1, r) 
		merge(arr, l, m, r) 

if __name__ == "__main__":
	arr1 = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
	arr2 = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
	merge_sort(arr1, 0, len(arr1) - 1)
	merge_sort(arr2, 0, len(arr2) - 1)
	print(arr1)
	print(arr2)