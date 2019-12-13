package com.onefit.HashtableAndArrays;
import java.util.HashMap;
import java.util.Map;

public class TwoStringPermutations {

	public static boolean AreStringsPermutationOfEachOther(String first, String second) {
		
		if (first.length() != second.length()) {
			return false;
		}
		
		HashMap<Character, Integer> table1 = new HashMap<>();		
		for (int i = 0; i < first.length(); i++) {
			int num = 1;
			char c = first.charAt(i);
			if (table1.containsKey(c)) {
				num = table1.get(c) + 1;
			}
			table1.put(c, num);
		}
		
		HashMap<Character, Integer> table2 = new HashMap<>();
		for (int i = 0; i < second.length(); i++) {
			int num = 1;
			char c = second.charAt(i);
			if (table2.containsKey(c)) {
				num = table2.get(c) + 1;
			}
			table2.put(c, num);
		}
		if (table1.keySet().size() != table2.keySet().size()) {
			return false;
		}
		for (Map.Entry<Character, Integer> firstEntry: table1.entrySet()) {
			char key = firstEntry.getKey();
			int value = firstEntry.getValue();
			if (!table2.containsKey(key) || table2.get(key) != value) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		String s1 = "aabbcc";
		String s2 = "cbacba";
		System.out.println(AreStringsPermutationOfEachOther(s1, s2));
	}

}
