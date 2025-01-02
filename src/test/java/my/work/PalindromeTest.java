package my.work;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PalindromeTest {

	@ParameterizedTest
	@MethodSource("nullOrEmptyStringProvider")
	void givenNullOrEmptyString_whenCompareCaseSensitive_thenReturnsFalse(Palindrome palindrome, String str) {
		assertFalse(palindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@MethodSource("nullOrEmptyStringProvider")
	void givenNullOrEmptyString_whenCompareCaseInsensitive_thenReturnsFalse(Palindrome palindrome, String str) {
		assertFalse(palindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@MethodSource("notPalindromeLowerCaseStringProvider")
	void givenNotPalindromeLowerCaseString_whenCompareCaseSensitive_thenReturnsFalse(Palindrome palindrome,
			String str) {
		assertFalse(palindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@MethodSource("notPalindromeLowerCaseStringProvider")
	void givenNotPalindromeLowerCaseString_whenCompareCaseInsensitive_thenReturnsFalse(Palindrome palindrome,
			String str) {
		assertFalse(palindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@MethodSource("notPalindromeMixedCaseStringProvider")
	void givenNotPalindromeMixedCaseString_whenCompareCaseSensitive_thenReturnsFalse(Palindrome palindrome,
			String str) {
		assertFalse(palindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@MethodSource("notPalindromeMixedCaseStringProvider")
	void givenNotPalindromeMixedCaseString_whenCompareCaseInsensitive_thenReturnsFalse(Palindrome palindrome,
			String str) {
		assertFalse(palindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@MethodSource("palindromeLowerCaseStringProvider")
	void givenPalindromeLowerCaseString_whenCompareCaseSensitive_thenReturnsTrue(Palindrome palindrome, String str) {
		assertTrue(palindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@MethodSource("palindromeLowerCaseStringProvider")
	void givenPalindromeLowerCaseString_whenCompareCaseInsensitive_thenReturnsTrue(Palindrome palindrome, String str) {
		assertTrue(palindrome.isPalindrome(str, true));
	}

	@ParameterizedTest
	@MethodSource("palindromeMixedCaseStringProvider")
	void givenPalindromeMixedCaseString_whenCompareCaseSensitive_thenReturnsFalse(Palindrome palindrome, String str) {
		assertFalse(palindrome.isPalindrome(str, false));
	}

	@ParameterizedTest
	@MethodSource("palindromeMixedCaseStringProvider")
	void givenPalindromeMixedCaseString_whenCompareCaseInsensitive_thenReturnsTrue(Palindrome palindrome, String str) {
		assertTrue(palindrome.isPalindrome(str, true));
	}

	private static Stream<Arguments> nullOrEmptyStringProvider() {
		return Stream.of(
				Arguments.of(new StringBuilderPalindrome(), null), 
				Arguments.of(new StringBuilderPalindrome(), ""), 
				Arguments.of(new CharComparingPalindrome(), null),
				Arguments.of(new CharComparingPalindrome(), ""));
	}
	
	private static Stream<Arguments> notPalindromeLowerCaseStringProvider() {
		return Stream.of(
				Arguments.of(new StringBuilderPalindrome(), "ab"), 
				Arguments.of(new StringBuilderPalindrome(), "abc"),
				Arguments.of(new StringBuilderPalindrome(), "abbc"), 
				Arguments.of(new CharComparingPalindrome(), "ab"),
				Arguments.of(new CharComparingPalindrome(), "abc"),
				Arguments.of(new CharComparingPalindrome(), "abbc"));
	}
	
	private static Stream<Arguments> notPalindromeMixedCaseStringProvider() {
		return Stream.of(
				Arguments.of(new StringBuilderPalindrome(), "Ab"), 
				Arguments.of(new StringBuilderPalindrome(), "aBc"),
				Arguments.of(new StringBuilderPalindrome(), "abBC"), 
				Arguments.of(new CharComparingPalindrome(), "Ab"),
				Arguments.of(new CharComparingPalindrome(), "aBc"),
				Arguments.of(new CharComparingPalindrome(), "abBC"));
	}
	
	private static Stream<Arguments> palindromeLowerCaseStringProvider() {
		return Stream.of(
				Arguments.of(new StringBuilderPalindrome(), "a"), 
				Arguments.of(new StringBuilderPalindrome(), "aba"),
				Arguments.of(new StringBuilderPalindrome(), "abba"), 
				Arguments.of(new StringBuilderPalindrome(), "abcba"), 
				Arguments.of(new CharComparingPalindrome(), "a"),
				Arguments.of(new CharComparingPalindrome(), "aba"),
				Arguments.of(new CharComparingPalindrome(), "abba"),
				Arguments.of(new CharComparingPalindrome(), "abcba"));
	}	
	
	private static Stream<Arguments> palindromeMixedCaseStringProvider() {
		return Stream.of(
				Arguments.of(new StringBuilderPalindrome(), "abA"),
				Arguments.of(new StringBuilderPalindrome(), "AbBa"), 
				Arguments.of(new StringBuilderPalindrome(), "aBcbA"), 
				Arguments.of(new CharComparingPalindrome(), "abA"),
				Arguments.of(new CharComparingPalindrome(), "AbBa"),
				Arguments.of(new CharComparingPalindrome(), "aBcbA"));
	}		
}
