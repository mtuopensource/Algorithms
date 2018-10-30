import unittest
from sorts import heap_sort, insertion_sort, merge_sort, quick_sort, selection_sort, bubble_sort

class TestSorts(unittest.TestCase):
    def test_heap_sort(self):
        a = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
        b = a.copy()
        b.sort()
        heap_sort(a)
        self.assertEqual(a, b)
        c = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
        d = c.copy()
        d.sort()
        heap_sort(c)
        self.assertEqual(c, d)

    def test_insertion_sort(self):
        a = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
        b = a.copy()
        b.sort()
        insertion_sort(a)
        self.assertEqual(a, b)
        c = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
        d = c.copy()
        d.sort()
        insertion_sort(c)
        self.assertEqual(c, d)

    def test_merge_sort(self):
        a = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
        b = a.copy()
        b.sort()
        merge_sort(a, 0, len(a) - 1)
        self.assertEqual(a, b)
        c = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
        d = c.copy()
        d.sort()
        merge_sort(c, 0, len(c) - 1)
        self.assertEqual(c, d)

    def test_quick_sort(self):
        a = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
        b = a.copy()
        b.sort()
        quick_sort(a, 0, len(a) - 1)
        self.assertEqual(a, b)
        c = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
        d = c.copy()
        d.sort()
        quick_sort(c, 0, len(c) - 1)
        self.assertEqual(c, d)

    def test_selection_sort(self):
        a = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
        b = a.copy()
        b.sort()
        selection_sort(a)
        self.assertEqual(a, b)
        c = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
        d = c.copy()
        d.sort()
        selection_sort(c)
        self.assertEqual(c, d)

    def test_bubble_sort(self):
        a = [5, 8, 1, 9, 6, 3, 10, 7, 2, 4]
        b = a.copy()
        b.sort()
        bubble_sort(a)
        self.assertEqual(a, b)
        c = [10, 9, 8, 7, 6 ,5, 4, 3, 2, 1]
        d = c.copy()
        d.sort()
        bubble_sort(c)
        self.assertEqual(c, d)

if __name__ == "__main__":
    unittest.main()
