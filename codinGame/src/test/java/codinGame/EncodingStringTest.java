package codinGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class EncodingStringTest {

	@Test
	void test() {
		EncodingString encodingString = new EncodingString();
		
		Assert.assertEquals("3a2b1c3d", encodingString.encodeString("aaabbcddd"));
		Assert.assertEquals("15z", encodingString.encodeString("zzzzzzzzzzzzzzz"));
		Assert.assertEquals("1a", encodingString.encodeString("a"));
		Assert.assertEquals("1a1b1c1d1e1f1g1h", encodingString.encodeString("abcdefgh"));
		Assert.assertEquals("2z2b", encodingString.encodeString("zzbb"));
		Assert.assertEquals("1q3a", encodingString.encodeString("qaaa"));
		Assert.assertEquals("1b", encodingString.encodeString("b"));
		Assert.assertEquals("2e3g", encodingString.encodeString("eeggg"));
	}

}
