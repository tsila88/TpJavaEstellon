package fr.licinfo.Interface;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixStringFilterTest {

	@Test
	public void test() {
		PostfixStringFilter postfixStringFilter = new  PostfixStringFilter(2);
		assertEquals(postfixStringFilter.filter("azertyuiop"), "op");
		
		PostfixStringFilter postfixStringFilter1 = new  PostfixStringFilter(3);
		assertEquals(postfixStringFilter1.filter("azertyuiop"), "iop");
		
		PostfixStringFilter postfixStringFilter2 = new  PostfixStringFilter(4);
		assertEquals(postfixStringFilter2.filter("azertyuiop"), "uiop");
		
		PostfixStringFilter postfixStringFilter3 = new  PostfixStringFilter(5);
		assertEquals(postfixStringFilter3.filter("azertyuiop"), "yuiop");
	}

}
