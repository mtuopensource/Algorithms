import unittest
from utilities import is_palindrome

class TestSearches(unittest.TestCase):
    def test_palindrome(self):
        self.assertTrue(is_palindrome('kayak'))
        self.assertFalse(is_palindrome('not a palindrome'))

if __name__ == "__main__":
    unittest.main()
