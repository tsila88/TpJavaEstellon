package fr.licinfo.formula;

public class Sum extends VariadicOperator {

	private Formula[] arrayOfformula1,arrayOfformula2 ;

	Sum(Formula[] arrayOfformula1,Formula[] arrayOfformula2) {

		this.arrayOfformula1 = arrayOfformula1;
		this.arrayOfformula2 = arrayOfformula2;

	}

	public String asString() {
		// TODO Auto-generated method stub

		String formulaToReturn = "";
		String formulaToReturn1 = "";
		String formulaToReturn2 = "";

		for (int i = 0; i < arrayOfformula1.length - 1; i++) {
			formulaToReturn1 += "(" + arrayOfformula1[i].asString() +this.symbol()+ arrayOfformula1[i + 1].asString() + ")";
		}
		
		for (int i = 0; i < arrayOfformula1.length - 1; i++) {
			formulaToReturn2 += "(" + arrayOfformula2[i].asString() +this.symbol()+ arrayOfformula2[i + 1].asString() + ")";
		}
		formulaToReturn= formulaToReturn1+this.symbol()+formulaToReturn2;
		
		return formulaToReturn.toString();
	}

	public double asValue() {
		// TODO Auto-generated method stub
		double cumulate = this.initialValue();
		
		for (int i = 0; i < arrayOfformula1.length; i++) {

			cumulate =  this.cumulativeValue(cumulate,arrayOfformula1[i].asValue());
		}
		
		for (int i = 0; i < arrayOfformula2.length; i++) {

			cumulate =  this.cumulativeValue(cumulate,arrayOfformula2[i].asValue());
		}

		return cumulate ;
	}

	/***
	 * 
	 * Method to return the sign " *" of the operation for product
	 * 
	 * @return the symbol *
	 */
	public String symbol() {
		return "+";

	}
	
	
	public double initialValue() {
		return 0;
		
	}
	
	public double cumulativeValue(double accumulator, double value) {
		
		return accumulator + value;
	}
}
