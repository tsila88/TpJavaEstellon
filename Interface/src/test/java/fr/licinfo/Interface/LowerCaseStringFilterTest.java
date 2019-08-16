package fr.licinfo.Interface;

import static org.junit.Assert.*;

import org.junit.Test;

public class LowerCaseStringFilterTest {

	@Test
	public void test() {
		LowerCaseStringFilter lowerCaseStringFilter = new  LowerCaseStringFilter();
		
		assertEquals(lowerCaseStringFilter.filter("AzErTyIo"), "azertyio");
	}

}
