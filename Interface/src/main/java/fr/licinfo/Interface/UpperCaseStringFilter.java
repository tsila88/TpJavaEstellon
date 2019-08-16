package fr.licinfo.Interface;

public class UpperCaseStringFilter implements StringFilter {

	public String filter(String string) {
		// TODO Auto-generated method stub
		return string.toUpperCase();
	}

	public String[] filter(String[] strings, StringFilter filter) {

		String[] stringList = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {

			stringList[i] = this.filter(strings[i]);
		}
		return stringList;

	}

}
