package fr.licinfo.Interface;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class UpperCaseStringFilterTest {

	@Test
	public void test() {
		UpperCaseStringFilter upperCaseStringFilter = new  UpperCaseStringFilter();
		
		assertEquals(upperCaseStringFilter.filter("AzErTyIo"), "AZERTYIO");
		
		String[] stringList = {"AzErTyIo","qsfd","wxcv"};
		String[] stringResult = {"AZERTYIO","QSFD","WXCV"};
		UpperCaseStringFilter upperCaseStringFilter1 = new  UpperCaseStringFilter();
		
		
		assertTrue(Arrays.deepEquals(stringResult, upperCaseStringFilter1.filter(stringList, upperCaseStringFilter1)));
	}

}
