def binary_search(arr, l, r, x):
	if l <= r:		# Base Case
		m = int((l+r)/2)

		# Check middle index
		if arr[m] == x:
			return m
		# Element  smaller than mid, must be in lower half
		elif arr[m] > x:
			return binary_search(arr, l, m-1, x)
		# Element greater than mid, must be in upper half
		else:
			return binary_search(arr, m+1, r, x)
	else:
		return -1
