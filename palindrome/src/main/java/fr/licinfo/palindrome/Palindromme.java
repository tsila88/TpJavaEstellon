package fr.licinfo.palindrome;

public class Palindromme {

	Palindromme() {

	}

	public boolean isPalindrommeString(String stringToTest) {
		if (stringToTest.length() == 0 || stringToTest.length() == 1) {
			return true;
		}

	

		if (stringToTest.charAt(0) == stringToTest.charAt(stringToTest.length() - 1)) {
			
			return isPalindrommeString(stringToTest.substring(1, stringToTest.length() - 1));
		}

		return false;
	}

	public boolean palindrommeInt(int intToTest) {
		return true;
	}
}