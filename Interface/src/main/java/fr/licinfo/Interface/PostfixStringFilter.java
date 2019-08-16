package fr.licinfo.Interface;

/**
 * Conserve les n derniers caractères de string
 * 
 * @author Tsila
 *
 */
public class PostfixStringFilter implements StringFilter {

	private int position;
	
	public PostfixStringFilter(int position) {
		this.position = position;

	}

	public String filter(String string) {
		// TODO Auto-generated method stub
		return string.substring(string.length() - (position));
	}

	public String[] filter(String[] strings, StringFilter filter) {
		
		String[] stringList = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {

			stringList[i] = this.filter(strings[i]);
		}
		return stringList;
	}
}
