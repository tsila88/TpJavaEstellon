package fr.licinfo.Interface;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;



public class AsciiStringFilterTest {

	@Test
	public void test() {
		
		AsciiStringFilter asciiFilter = new AsciiStringFilter();
		
		
		assertThat(asciiFilter.filter("aèl£efaçbarea"),equalToIgnoringCase ("Alefabarea"));
		
	}

}
