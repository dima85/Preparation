package com.onefit.HashtableAndArrays;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class PalindromPermutations {

	public static void main(String[] args) {
		assertTrue("Tact Coa is polindrom",IsPermutationOfPalindrom("Tact aoC"));
		assertTrue("Tact Coa is polindrom",IsPermutationOfPalindrom("Tact Coa"));
		assertTrue("mmdaa is polindrom", IsPermutationOfPalindrom("mmdaa"));
		assertFalse("bcaa is not polindrom", IsPermutationOfPalindrom("bcaa"));
		assertTrue("a is polindrom", IsPermutationOfPalindrom("a"));
		assertTrue("aa is polindrom", IsPermutationOfPalindrom("aa"));
		assertTrue("aaa is polindrom", IsPermutationOfPalindrom("aaa"));
		assertFalse("ba is not polindrom", IsPermutationOfPalindrom("ba"));
		assertFalse("empty string is not polindrom", IsPermutationOfPalindrom(""));
		assertFalse("null string is not polindrom", IsPermutationOfPalindrom(null));
		assertFalse("space is not polindrom", IsPermutationOfPalindrom(" "));
		assertTrue("space around polinrom is polindrom", IsPermutationOfPalindrom(" b "));
		assertTrue("space before polinrom is polindrom", IsPermutationOfPalindrom(" b"));
		assertTrue("space after polinrom is polindrom", IsPermutationOfPalindrom("b"));
		assertTrue("space in the middle of polinrom is polindrom", IsPermutationOfPalindrom("bb aa"));
		assertTrue("multiple spaces in the middle polindrom is polindrom", IsPermutationOfPalindrom("ab       ab"));
		assertFalse("space in the middle of not polindrom is not polindrom", IsPermutationOfPalindrom("ab       ac"));
	}

	private static boolean IsPermutationOfPalindrom(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		
		HashMap<Character, Integer> table = new HashMap<>();
		for (char c : string.toCharArray()) {
			char lowerChar = Character.toLowerCase(c);
			int number = 1;
			if (lowerChar == ' ') {
				continue;
			}
			if (table.containsKey(lowerChar)) {
				number = table.get(lowerChar) + 1;
			}
			table.put(lowerChar, number);
		}
		
		if (table.size() == 0) {
			return false;
		}
		
		boolean notEvenCharNumberLimitUsed = false;
		for (Map.Entry<Character, Integer> record : table.entrySet()) {
			int numberOfChars = record.getValue();
			
			if (numberOfChars % 2 != 0) {
				if (notEvenCharNumberLimitUsed) {
					return false;
				}
				else {
					notEvenCharNumberLimitUsed = true;
					continue;
				}				
			}
		}
		
		return true;
	}

	
}
