package fr.licinfo.formula;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FormulaTest {

	@Test
	public void testVariable() {

		Variable var1 = new Variable("var1", 2);
		Variable var2 = new Variable("var2", 25.78);
		Variable var3 = new Variable("var3", 21.3);

		assertThat(var1.asString(), hasToString("var1"));
		assertThat(var2.asString(), hasToString("var2"));
		assertThat(var3.asString(), hasToString("var3"));
		assertThat(var1.asValue(), equalTo(2.00));
		assertThat(var2.asValue(), equalTo(25.78));
		assertThat(var3.asValue(), equalTo(21.3));

	}

	@Test
	public void testProduct() {

		Variable var1 = new Variable("var1", 2.00);
		Variable var2 = new Variable("var2", 25.00);
		Variable var3 = new Variable("var3", 3.00);
		Variable var4 = new Variable("var4", 52.00);
		// Variable var3 = new Variable("var3",21.3);
		Formula[] f = {var1,var2};
		Formula[] f1 = {var3,var4};
		Formula formula1 = new Product(f,f1);
		assertThat(formula1.asString(), hasToString("(var1*var2)*(var3*var4)"));
		assertThat(formula1.asValue(), equalTo(2*25.00*3*52.00));

	}

	@Test
	public void testSum() {

		Variable var1 = new Variable("var1", 2.00);
		Variable var2 = new Variable("var2", 25.78);
		Variable var3 = new Variable("var3", 3.00);
		Variable var4 = new Variable("var4", 52.78);
		// Variable var3 = new Variable("var3",21.3);
		Formula[] f = {var1,var2};
		Formula[] f1 = {var3,var4};
		Formula formula1 = new Sum(f,f1);
		assertThat(formula1.asString(), hasToString("(var1+var2)+(var3+var4)"));
		assertThat(formula1.asValue(), equalTo(2 + 25.78+3+52.78));

		//Formula formula1 = new Sum(v);
		

	}

	@Test
	public void testComplexFormula() {

//		Variable var1 = new Variable("var1", 2.00);
//		Variable var2 = new Variable("var2", 25.78);
//		Variable var3 = new Variable("var3", 81.45);
//		Variable[] v1 = {var1,var2,var3};
//		Formula formula1 = new Sum(v1);
//		Formula formula2 = new Product(v1);
//		Formula formula3 = new Sum(formula2);
//		Formula formula4 = new Sum(v1);
//		assertThat(formula1.asValue(), equalTo(2 + 25.78 + 81.45));
//		
		
////		Formula formula3 = new Sum(new Product(var1, var3), new Sum(var2, var3));
//		assertThat(formula1.asString(), hasToString("(var1+(var2+var3))"));
//		assertThat(formula1.asValue(), equalTo(2 + 25.78 + 81.45));
//		assertThat(formula2.asString(), hasToString("(var1*(var2+var3))"));
//		assertThat(formula2.asValue(), equalTo(2.00 * (25.78 + 81.45)));
//		assertThat(formula3.asString(), hasToString("((var1*var3)+(var2+var3))"));
//		assertThat(formula3.asValue(), equalTo(2 * 81.45 + 25.78 + 81.45));

	}

}
