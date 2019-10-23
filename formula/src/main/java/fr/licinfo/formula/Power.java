package fr.licinfo.formula;

public class Power implements Formula {

	private Variable value;
	private int power;

	public String asString() {
		// TODO Auto-generated method stub
		return "(pow(" + this.value.asString() + "," + this.power + ") = +" +this.asValue()+ ")";
	}

	public double asValue() {
		// TODO Auto-generated method stub
		return Math.pow(value.asValue(), power);
	}

}