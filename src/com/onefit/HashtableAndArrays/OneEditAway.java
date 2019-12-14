package com.onefit.HashtableAndArrays;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;


public class OneEditAway {

	public static void main(String[] args) {
		//WRONG implementation does not think about order of chars!!!!!! 
		assertFalse("pale and ple has one edit", IsOneEditAway("pale", "elp"));
		assertTrue("pale and ple has one edit", IsOneEditAway("pale", "ple"));
		assertTrue("pales and pale has one edit", IsOneEditAway("pales", "pale"));
		assertTrue("pale and bale has one edit", IsOneEditAway("pale", "bale"));
		assertFalse("pale and bake has one edit", IsOneEditAway("pale", "bake"));
		assertTrue("pale and pale has 0 edit", IsOneEditAway("pale", "pale"));
		assertTrue("empty and empty string has 0 edit", IsOneEditAway("", ""));
		assertTrue("space and spcae has 0 edit", IsOneEditAway(" ", " "));
		assertTrue("2spaces and spcae has 0 edit", IsOneEditAway("  ", " "));
		assertTrue("space and empty has 0 edit", IsOneEditAway(" ", ""));
		//assertThrows(IllegalArgumentException.class, () -> IsOneEditAway(null, null));
	}
	private static boolean IsOneEditAway(String first, String second) {
		if (first == null || second == null) {
			throw new IllegalArgumentException("Both string should be not null");
		}
		HashMap<Character, Integer> firstTable = GetHashmap(first);
		HashMap<Character, Integer> secondTable = GetHashmap(second);
		
		boolean oneEditIsDone = false;
		
		for (Map.Entry<Character, Integer> firstKeyValue : firstTable.entrySet()) {
			char c = firstKeyValue.getKey();
			int v = firstKeyValue.getValue();
			
			if (!secondTable.containsKey(c) || secondTable.get(c) != v) {
				if (!oneEditIsDone) {
					oneEditIsDone = true;	
					continue;
				}
				return false;
			}
		}
		return true;
	}
	
	private static HashMap<Character, Integer> GetHashmap(String string) {
		HashMap<Character, Integer> charsTable = new HashMap<>();
		
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			int number = 1;
			if (charsTable.containsKey(c)) {
				number = charsTable.get(c) + 1;
			}
			charsTable.put(c, number);
		}
		return charsTable;
	}

}
