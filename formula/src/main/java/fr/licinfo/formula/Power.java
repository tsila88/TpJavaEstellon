package fr.licinfo.formula;

public class Power implements Formula {

	private String namevalue1;
	private String namavalue2;
	private Double value;
	private Double power;

	public String asString() {
		// TODO Auto-generated method stub
		return "(pow(" + this.namevalue1 + "," + this.namavalue2 + ")";
	}

	public double asValue() {
		// TODO Auto-generated method stub
		return Math.pow(value, power);
	}

}