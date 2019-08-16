package fr.licinfo.Interface;

public class AsciiStringFilter implements StringFilter {

	//private String stringToSave = "";
	
	//private AsciiStringFilter asciiStringFilter = new AsciiStringFilter();

	public AsciiStringFilter() {

	}

	public String filter(String string) {
		// TODO Auto-generated method stub
		String stringToSave = "";
		for (int i = 0; i < string.length(); i++) {

			int ascii = string.charAt(i);
			if (ascii < 128) {
				stringToSave += string.charAt(i);
			}
		}
		return stringToSave.toString();
	}

	public String[] filter(String[] strings, StringFilter filter) {
		//filter = this.filter(string);
		String[] stringList = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {

			stringList[i] = this.filter(strings[i]);
		}
		return stringList;

	}

}
