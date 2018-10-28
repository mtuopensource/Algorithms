import unittest
from searches import linear_search, binary_search

class TestSearches(unittest.TestCase):
    def test_linear_search(self):
        arr = [4, 3, 2, 1, 5, 7, 4]
        self.assertEqual(linear_search(arr, 4), 0)
        self.assertEqual(linear_search(arr, 9), -1)
        self.assertEqual(linear_search(arr, 5), 4)

    def test_binary_search(self):
        arr = [1, 4, 6, 7, 8, 9, 15, 17, 54, 55]
        self.assertEqual(2, binary_search(arr, 0, len(arr) - 1, 6))
        self.assertEqual(-1, binary_search(arr, 0, len(arr) - 1, 10))
        self.assertEqual(8, binary_search(arr, 0, len(arr) - 1, 54))

if __name__ == "__main__":
    unittest.main()
