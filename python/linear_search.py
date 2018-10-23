def linear_search(array, key):
    for i in range 0,len(array):
        if array[i] == key:
            return i
    return -1