# Python implementation for Heap Sort
def heapify(arr, l, i): 
    max = i # Initialize max as root 
    left = (2*i) + 1     # left = 2*i + 1 
    right = (2*i) + 2     # right = 2*i + 2 
  
	# Check if left child is greater than self
    if left < l and arr[i] < arr[left]: 
        max = left 
  
	# Check if right child is greater than self 
    if right < l and arr[max] < arr[right]: 
        max = right 
  
 	# Change root if max is different
    if max != i: 
		#swap values
        arr[i], arr[max] = arr[max], arr[i]
        # Re-Heapify the root. 
        heapify(arr, l, max) 
  
# The main function to sort an array of given size 
def heap_sort(arr): 
    l = len(arr) 
  
    # Build Max-Heao 
    for i in range(l, -1, -1): 
        heapify(arr, l, i) 
  
    # Remove-max and re-heapify 
    for i in range(l-1, 0, -1): 
		# swap elements
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0) 
