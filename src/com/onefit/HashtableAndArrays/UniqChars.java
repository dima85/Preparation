package com.onefit.HashtableAndArrays;
import java.util.Arrays;
import java.util.HashMap;

public class UniqChars {

	public static boolean AreAllCharsUnique(String inputString) {
		HashMap<Character, Integer> allCharacters = new HashMap<Character, Integer>();
		
		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);
			int num = 1;
			if (allCharacters.containsKey(c)) {
				num = allCharacters.get(c) + 1;
				return false;
			}
			allCharacters.put(c, num);			
		}		
		return true;
	}
	
	public static boolean AreAllCharsUniqueNoDataStruct(String inputString) {
		char[] arr = inputString.toCharArray();
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length - 1; i++) {
			char c1 = arr[i];
			char c2 = arr[i + 1];
			if (c1 == c2) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		String example1 = "abcdef1";
		
		System.out.println(AreAllCharsUniqueNoDataStruct(example1));
	}

}
