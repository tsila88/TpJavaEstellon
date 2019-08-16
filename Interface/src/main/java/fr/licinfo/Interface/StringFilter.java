package fr.licinfo.Interface;

public interface StringFilter {

	String filter(String string);

	String[] filter(String[] strings, StringFilter filter);
}
