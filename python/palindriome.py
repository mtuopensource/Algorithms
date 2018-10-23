def reverse(s):
	return s[::-1]

def isPalindrome(s):
	r = reverse(s) 	#call reverse function

	#check if r and s are equal
	if (s == r):
		return True
	return False


if __name__ == "__main__":
	s = "kayak"
	r = "Not a palindrome"
	print(isPalindrome(s))
	print(isPalindrome(r))