package fr.licinfo.formula;

public class Product  extends VariadicOperator {

	private Formula[] arrayOfformula1;
	private Formula[] arrayOfformula2;

	Product(Formula[] arrayOfformula1, Formula[] arrayOfformula2) {
		this.arrayOfformula1 = arrayOfformula1;
		this.arrayOfformula2 = arrayOfformula2;

	}

	public String asString() {
		// TODO Auto-generated method stub
		String formula1ToReturn = "";
		String formula2ToReturn = "";
		String formulaToReturn = "";

		for (int i = 0; i < arrayOfformula1.length - 1; i++) {

			formula1ToReturn += "(" + arrayOfformula1[i].asString() + this.symbol() + arrayOfformula1[i + 1].asString()
					+ ")";
		}

		for (int i = 0; i < arrayOfformula1.length - 1; i++) {

			formula2ToReturn += "(" + arrayOfformula2[i].asString() + this.symbol() + arrayOfformula2[i + 1].asString()
					+ ")";
		}

		formulaToReturn = formula1ToReturn + this.symbol() + formula2ToReturn;

		return formulaToReturn.toString();
	}

	public double asValue() {
		// TODO Auto-generated method stub
		double cumulate = this.initialValue();
		

		for (int i = 0; i < arrayOfformula1.length; i++) {

			cumulate = this.cumulativeValue(cumulate, arrayOfformula1[i].asValue());
		}

		for (int i = 0; i < arrayOfformula2.length; i++) {

			cumulate = this.cumulativeValue(cumulate, arrayOfformula2[i].asValue());
		}

		return cumulate;
	}

	/***
	 * 
	 * Method to return the sign " *" of the operation for product
	 * 
	 * @return the symbol *
	 */
	public String symbol() {
		return "*";

	}

	public double initialValue() {
		return 1;

	}

	public double cumulativeValue(double accumulator, double value) {

		return accumulator * value;
	}
}
