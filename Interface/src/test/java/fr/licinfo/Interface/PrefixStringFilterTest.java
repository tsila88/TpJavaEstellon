package fr.licinfo.Interface;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrefixStringFilterTest {

	@Test
	public void test() {
		
		PrefixStringFilter prefixStringFilter = new PrefixStringFilter(2);
		assertEquals(prefixStringFilter.filter("azertyuiop"), "az");
		
		PrefixStringFilter prefixStringFilter1 = new PrefixStringFilter(3);
		assertEquals(prefixStringFilter1.filter("azertyuiop"), "aze");
		
		PrefixStringFilter prefixStringFilter2 = new PrefixStringFilter(4);
		assertEquals(prefixStringFilter2.filter("azertyuiop"), "azer");
		
		PrefixStringFilter prefixStringFilter3 = new PrefixStringFilter(5);
		assertEquals(prefixStringFilter3.filter("azertyuiop"), "azert");
		
	}

}
