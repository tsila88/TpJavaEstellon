package fr.licinfo.formula;

public class Square implements Formula {

	private Variable var;

	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	public Square(Variable var) {
		this.var = var;
	}

	public String asString() {
		// TODO Auto-generated method stub
		return "(" + this.var.name + "^2)";
	}

	public double asValue() {
		// TODO Auto-generated method stub
		return java.lang.Math.pow(this.var.asValue(), 2);

	}

}
