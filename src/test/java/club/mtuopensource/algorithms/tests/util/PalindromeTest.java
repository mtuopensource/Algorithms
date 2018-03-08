package club.mtuopensource.algorithms.tests.util;

import static org.junit.Assert.*;

import org.junit.Test;

import club.mtuopensource.algorithms.util.Palindrome;

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
