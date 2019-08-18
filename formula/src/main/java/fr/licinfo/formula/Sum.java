package fr.licinfo.formula;

public class Sum implements Formula {

	private Formula[] arrayOfformula;

	Sum(Formula[] arrayOfformula) {

		this.arrayOfformula = arrayOfformula;

	}

	public String asString() {
		// TODO Auto-generated method stub
		//String[] formula1ToReturn = new String[formula.length];
		String formula1ToReturn ="";
		
		for (int i = 0; i < arrayOfformula.length-1; i++) {
			formula1ToReturn += "(" + arrayOfformula[i].asString() + "+" + arrayOfformula[i + 1].asString() + ")";
		}

		return formula1ToReturn.toString();
	}

	public double asValue() {
		// TODO Auto-generated method stub
		double doubleToreturn = 0;
		for (int i = 0; i < arrayOfformula.length; i++) {

			doubleToreturn = doubleToreturn + arrayOfformula[i].asValue();
		}

		return doubleToreturn;
	}

}
