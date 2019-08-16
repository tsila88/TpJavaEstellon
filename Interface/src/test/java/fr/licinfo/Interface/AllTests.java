package fr.licinfo.Interface;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AsciiStringFilterTest.class, LowerCaseStringFilterTest.class, PostfixStringFilterTest.class,
		PrefixStringFilterTest.class, UpperCaseStringFilterTest.class })
public class AllTests {
	
}
