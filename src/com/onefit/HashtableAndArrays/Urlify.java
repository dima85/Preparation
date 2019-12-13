package com.onefit.HashtableAndArrays;
import static org.junit.Assert.assertEquals;

public class Urlify {

	
	public static void main(String[] args) {

		assertEquals(UrlifyText("Mr John Smith    ", 13), "Mr%20John%20Smith");
		assertEquals(UrlifyText("Mr. John Smith    ", 14), "Mr.%20John%20Smith");
		assertEquals(UrlifyText("Mr John Smith       ", 14), "Mr%20John%20Smith%20");
		assertEquals(UrlifyText(" Mr John Smith      ", 14), "%20Mr%20John%20Smith");
		assertEquals(UrlifyText(" Mr John Smith         ", 15), "%20Mr%20John%20Smith%20");
		assertEquals(UrlifyText("", 0), "");
		assertEquals(UrlifyText("   ", 1), "%20");
		assertEquals(UrlifyText("      ", 2), "%20%20");
	}

	private static String UrlifyText(String text, int realLength) {
		if (text == null || text.isEmpty()) {
			return "";
		}
		
		char[] string = text.toCharArray();
		int realEndIndex = realLength - 1;
		for (int i = string.length - 1; i > 0; i--) {			
			if (string[realEndIndex] == ' ' ) {
				string[i--] = '0';
				string[i--] = '2';
				string[i] = '%';
			} else {
				string[i] = string[realEndIndex];
			}
			
			realEndIndex--;
		}
		return new String(string);
	}
	
}
