package my.work;

import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

public class CharComparingPalindrome implements Palindrome {

	public boolean isPalindrome(String str, boolean ignoreCase) {
		return (!StringUtils.isEmpty(str) && isReversed(str, ignoreCase));
	}

	private static boolean isReversed(String str, boolean ignoreCase) {
		var localStr = ignoreCase ? str.toLowerCase() : str;
		return hasSameChars(localStr, (localStr.length() / 2));
	}

	private static boolean hasSameChars(String str, int lastIndex) {
		return IntStream
				.range(0, lastIndex)
				.noneMatch(index -> isDifferentChar(index, str));
	}

	private static boolean isDifferentChar(int index, String str) {
		return (str.charAt(index) != str.charAt(str.length() - 1 - index));
	}
}
