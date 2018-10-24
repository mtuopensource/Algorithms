def linear_search(array, key):
    for i in range (0, len(array)):
        if array[i] == key:
            return i
    return -1

if __name__ == "__main__":
    array = [4, 3, 2, 1, 5, 7, 4]
    print (linear_search(array, 4)) #exists
    print (linear_search(array, 9)) #does not exist in array
    print (linear_search(array, 5)) #also exists