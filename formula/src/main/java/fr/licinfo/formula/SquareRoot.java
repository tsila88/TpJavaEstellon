package fr.licinfo.formula;

public class SquareRoot implements Formula{
	
	private String name;
	private Double value;

	public String asString() {
		// TODO Auto-generated method stub
		return "√"+this.name;
	}

	public double asValue() {
		// TODO Auto-generated method stub
		return Math.sqrt(value) ;
	}

}
