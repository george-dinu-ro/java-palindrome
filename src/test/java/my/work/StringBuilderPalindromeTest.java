package my.work;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringBuilderPalindromeTest {

	@ParameterizedTest
	@NullAndEmptySource
	void givenNullOrEmptyString_whenCompareCaseSensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void givenNullOrEmptyString_whenCompareCaseInsensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@ValueSource(strings = { "ab", "abc", "abbc" })
	void givenNotPalindromeLowerCaseString_whenCompareCaseSensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@ValueSource(strings = { "ab", "abc", "abbc" })
	void givenNotPalindromeLowerCaseString_whenCompareCaseInsensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Ab", "aBc", "abBC" })
	void givenNotPalindromeMixedCaseString_whenCompareCaseSensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@ValueSource(strings = { "Ab", "aBc", "abBC" })
	void givenNotPalindromeMixedCaseString_whenCompareCaseInsensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@ValueSource(strings = { "a", "aba", "abba", "abcba" })
	void givenPalindromeLowerCaseString_whenCompareCaseSensitive_thenReturnsTrue(String str) {
		assertTrue(StringBuilderPalindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@ValueSource(strings = { "a", "aba", "abba", "abcba" })
	void givenPalindromeLowerCaseString_whenCompareCaseInsensitive_thenReturnsTrue(String str) {
		assertTrue(StringBuilderPalindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abA", "AbBa", "aBcbA" })
	void givenPalindromeMixedCaseString_whenCompareCaseSensitive_thenReturnsFalse(String str) {
		assertFalse(StringBuilderPalindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@ValueSource(strings = { "A", "abA", "AbBa", "aBcbA" })
	void givenPalindromeMixedCaseString_whenCompareCaseInsensitive_thenReturnsTrue(String str) {
		assertTrue(StringBuilderPalindrome.isPalindrome(str, true));
	}
}
