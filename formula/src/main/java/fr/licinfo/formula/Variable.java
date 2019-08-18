package fr.licinfo.formula;

public class Variable implements Formula {
	
	public String name;
	public Double value;
	

	public Variable(String name, double value) {
		this.name=name;
		this.value=value;
	}

	public String asString() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public double asValue() {
		// TODO Auto-generated method stub
		return value;
	}
}