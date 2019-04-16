package com.common.util;

import java.util.regex.Pattern;

public class NumberUtil {
	/*判断是否数字*/
	public  static boolean isDouble(String str) {
		if (null == str || "".equals(str) || str.trim().contains(" ") || str.endsWith(".") || str.startsWith(".")) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}
}
