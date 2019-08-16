package fr.licinfo.Interface;

/**
 * Conserve les n premiers caractères de string. La valeur de n est forunie lors
 * de la construction d'une instance de la classe.
 * 
 * @author Tsila
 *
 */
public class PrefixStringFilter implements StringFilter {

	private int position;

	public PrefixStringFilter(int n) {

		// stringToSave = string.substring(0, n + 1);
		this.position = n;
	}

	public String filter(String string) {
		// TODO Auto-generated method stub
		return string.substring(0, position);
	}

	public String[] filter(String[] strings, StringFilter filter) {

		String[] stringList = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {
			stringList[i] = this.filter(strings[i]);
		}
		return stringList;
	}

}
