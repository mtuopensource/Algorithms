package club.mtuopensource.algorithms.util;

/**
 * Palindrome.java
 * Date Last Modified: March 7, 2018
 * @author Austin Walhof
 */
public class Palindrome {

	/**
	 * IsPalindrome
	 * @return true if the input string is a palindrome, false otherwise.
	 */
	public static boolean isPalindrome(String input) {
		if (input.length() < 2) {
			return true; // A single character is a palindrome.
		}
		char a = input.charAt(0);
		char b = input.charAt(input.length() - 1);
		if (a == b) {
			return isPalindrome(input.substring(1, input.length() - 1)); // Continue checking
		} else {
			return false; // Characters did not match, so it cannot be a palindrome.
		}
	}
}
