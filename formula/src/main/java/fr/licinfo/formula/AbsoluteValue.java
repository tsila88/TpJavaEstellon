package fr.licinfo.formula;

public class AbsoluteValue implements Formula {

	private String name;
	private Double value;

	public String asString() {
		// TODO Auto-generated method stub
		return "(Abs(" + this.name + "))";
	}

	public double asValue() {
		// TODO Auto-generated method stub
		return java.lang.Math.abs(this.value);
	}

}