def binary_search(arr, l, r, x):
	if l <= r:		# Base Case
		m = (l+r)/2

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

if __name__ == "__main__":
	arr = [1, 4, 6, 7, 8, 9, 15, 17, 54, 55]
	print(binary_search(arr, 0, len(arr) - 1, 6))	#Should be 2
	print(binary_search(arr, 0, len(arr) - 1, 10))	#Should be -1
	print(binary_search(arr, 0, len(arr) - 1, 54))  #Should be 8