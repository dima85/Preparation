package com.onefit.HashtableAndArrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompressString {

	public static void main(String[] args) {
		assert CompressString("aabcccccaaa").equalsIgnoreCase("a2b1c5a3");
		assert CompressString("abc").equalsIgnoreCase("abc");
		assert CompressString("aa").equalsIgnoreCase("aa");
		assert CompressString("a").equalsIgnoreCase("a");
		assert CompressString("").equalsIgnoreCase("");
		assert CompressString(null) == null;
	}
	
//	
//	
//	
//	private static String CompressString(String string) {
//		LinkedHashMap<Character, Integer> charsTable = new LinkedHashMap<Character, Integer>();
//		
//		for (int i = 0; i < string.length(); i++ ) {
//			char c = string.charAt(i);
//			int number = 1;
//			if (charsTable.containsKey(c)) {
//				number = charsTable.get(c) + 1;
//			}
//			charsTable.put(c, number);
//		}
//		
//		if (charsTable.size() * 2 >= string.length()) {
//			return string;
//		}
//		
//		for (Map.Entry<Character, Integer> entry: charsTable.entrySet()) {
//			
//		}
//	}

	private static String CompressString(String string) {
		if (string == null || string.isEmpty()) {
			return string;
		}
		char[] chars = string.toCharArray();
		int currentNumberOfChars = 1;
		char previousChar = chars[0];
		
		StringBuilder compressed = new StringBuilder();
		
		for (int i = 1; i < chars.length; i++) {
			char c = chars[i];
			if (previousChar == c) {
				currentNumberOfChars++;
				if (i < chars.length - 1) {
					continue;
				}				
			}
			compressed.append(String.format("%s%d", previousChar, currentNumberOfChars));
			currentNumberOfChars = 1;
			previousChar = c;
						
		}
		int compressedLength = compressed.length();
		return compressedLength > 0 && compressedLength < string.length()  ? compressed.toString() : string;
	}

}
