package fr.licinfo.formula;

public class Square implements Formula {

	private String name;
	private Double value;
    
	public String asString() {
	// TODO Auto-generated method stub
	return "("+this.name+"^2)";
	}

	public double asValue() {
	// TODO Auto-generated method stub
	return java.lang.Math.pow(this.value,2);
	
	}

}
