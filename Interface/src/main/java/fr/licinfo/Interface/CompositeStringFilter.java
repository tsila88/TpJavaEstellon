package fr.licinfo.Interface;

public class CompositeStringFilter implements StringFilter {

	private StringFilter[] arrayFilter;
	private int position;
	private String string;

	public CompositeStringFilter(StringFilter filters[], int position) {

		this.arrayFilter = filters;
		this.position = position;
		PostfixStringFilter postfixStringFilter = new PostfixStringFilter(position);
		PrefixStringFilter prefixStringFilter = new PrefixStringFilter(position);

	}

	public String filter(String string) {
		// TODO Auto-generated method stub
		
		for (StringFilter filter : arrayFilter) {
			filter.filter(string);
		}
		return string;
	}

	public String[] filter(String[] strings, StringFilter filters) {

		String[] stringList = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {

			for (StringFilter filter : arrayFilter) {
				filter.filter(strings[i]);
			}
			stringList[i] = this.filter(strings[i]);
		}
		return stringList;
	}

}
