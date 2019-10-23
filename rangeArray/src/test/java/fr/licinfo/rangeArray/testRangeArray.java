package fr.licinfo.rangeArray;

//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.greaterThanOrEqualTo;
//import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class testRangeArray {

	@Test
	public void test() {

		int indexMin = -3;
		int indexMax = 1;

		RangeArray squares = new RangeArray(indexMin, indexMax);

		for (int index = squares.getIndexMin(); index <= squares.getIndexMax(); index++) {
			squares.set(index, index * index);
		}
		for (int index = squares.getIndexMin(); index <= squares.getIndexMax(); index++) {

		}

		// assertThat(squares.get(-3),equalTo(9));
		assertEquals(squares.get(-3), (9));
		assertEquals(squares.get(-2), (4));
		assertEquals(squares.get(-1), (1));
		assertEquals(squares.get(0), (0));
		assertEquals(squares.get(1), (1));

		assertEquals(squares.rangeSize(), (5));

	}

	@Test
	public void testT() {

		RangeArray<String> habitations = new RangeArray<String>(3, 5);
		habitations.set(3, "Maison");
		habitations.set(4, "Immeuble");
		habitations.set(5, "Hutte");
		for (int index = habitations.getIndexMin(); index <= habitations.getIndexMax(); index++) {

		}
		assertEquals(habitations.get(3).length(), (6));
		assertEquals(habitations.get(4).length(), (8));
		assertEquals(habitations.get(5).length(), (5));
	}
}