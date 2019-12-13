package com.onefit.HashtableAndArrays;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assert IsStringRotation("waterbottle", "erbottlewat");
		assert IsStringRotation("hello world", " worldhello");
	}
	
	private static boolean IsStringRotation(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		String s2s2 = string2 + string2;
		boolean result = s2s2.contains(string1);
		return result;
	}

	private static boolean IsStringRotation_my(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char secondStringStartChar = string2.charAt(0);
		int substringStartIndex = 0;
		for (int firstIndex = 0; firstIndex < string1.length(); firstIndex ++) {
			char currentChar1 = string1.charAt(firstIndex);
			if (secondStringStartChar == currentChar1) {
				if (substringStartIndex >= string1.length() - 1) {
					break;
				}
				substringStartIndex ++;				
				secondStringStartChar = string2.charAt(substringStartIndex);
				if (firstIndex == string1.length() - 1 && secondStringStartChar == string1.charAt(0)) {
					firstIndex = -1;
				}
			}
			else {
				secondStringStartChar = string2.charAt(0);
				substringStartIndex = 0;
			}
		}
		if (substringStartIndex == string1.length() - 1) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
