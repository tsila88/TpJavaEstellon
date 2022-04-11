package codinGame;

/*
 * impl�mentation Java de l'Algo d'�ncodage d'un string suivant le nombre de caract�res.
 */

public class EncodingString {
	String encodeString(String stringToEncode) {

		String stringToReturn = "";

		char[] stringToChars = stringToEncode.toCharArray();
		Integer numberChar = 1;

		int next = 0;
		if (stringToEncode.length() == 1) {
			return "1" + stringToEncode;
		}

		for (int i = 0; i < stringToChars.length; i++) {

			next++;
			if (next >= stringToChars.length) {
				next = i;

				if (stringToChars[i] == stringToChars[i - 1]) {

					return stringToReturn += numberChar.toString() + stringToChars[i];
				} else {
					numberChar = 1;
					return stringToReturn += numberChar.toString() + stringToChars[i];
				}
			}
			if (stringToChars[i] == stringToChars[next]) {
				numberChar++;

			} else {

				stringToReturn += numberChar.toString() + stringToChars[i];
				numberChar = 1;
			}

		}

		return stringToReturn;

	}

}
