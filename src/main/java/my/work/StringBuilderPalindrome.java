package my.work;

import org.apache.commons.lang3.StringUtils;

public class StringBuilderPalindrome implements Palindrome {

	public boolean isPalindrome(String str, boolean ignoreCase) {
		return (!StringUtils.isEmpty(str) && isReversed(str, ignoreCase));
	}

	private static boolean isReversed(String str, boolean ignoreCase) {
		var localStr = ignoreCase ? str.toLowerCase() : str;
		return new StringBuilder(localStr).reverse().toString().equals(localStr);
	}
}
