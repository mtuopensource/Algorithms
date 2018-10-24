package club.mtuopensource.algorithms.test.util;

import club.mtuopensource.algorithms.util.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
	
	@Test
	public void testPalindromes() {
		assertTrue(Palindrome.isPalindrome("a"));
		assertTrue(Palindrome.isPalindrome("abba"));
		assertTrue(Palindrome.isPalindrome("radar"));
		assertTrue(Palindrome.isPalindrome("kayak"));
	}
	
	@Test
	public void testNonPalindromes() {
		assertFalse(Palindrome.isPalindrome("at"));
		assertFalse(Palindrome.isPalindrome("cat"));
		assertFalse(Palindrome.isPalindrome("dog"));
	}
}
