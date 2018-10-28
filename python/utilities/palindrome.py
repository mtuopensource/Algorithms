def reverse(s):
	return s[::-1]

def is_palindrome(s):
	r = reverse(s) 	#call reverse function

	#check if r and s are equal
	return s == r


if __name__ == "__main__":
	s = "kayak"
	r = "Not a palindrome"
	print(is_palindrome(s))
	print(is_palindrome(r))