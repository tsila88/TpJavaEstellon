package fr.licinfo.formula;

public class Product implements Formula {

	private Formula[] arrayOfformula;
	
	Product(Formula[] arrayOfformula){
		this.arrayOfformula = arrayOfformula;
		
	}


	public  String asString() {
		// TODO Auto-generated method stub
		String formula1ToReturn ="";

		for (int i = 0; i < arrayOfformula.length -1; i++) {

			formula1ToReturn += "(" + arrayOfformula[i].asString() + "*" + arrayOfformula[i + 1].asString() + ")";
		}

		return formula1ToReturn.toString();
	}


	public double asValue() {
		// TODO Auto-generated method stub
		double doubleToreturn = 1;
		for (int i = 0; i < arrayOfformula.length; i++) {

			doubleToreturn = doubleToreturn * arrayOfformula[i].asValue();
		}

		return doubleToreturn;
	}

}
