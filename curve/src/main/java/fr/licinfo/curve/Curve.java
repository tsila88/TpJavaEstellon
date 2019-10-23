package fr.licinfo.curve;

import java.io.Writer;

public class Curve {

	private int a,b;
	private double d;
	private Fonction fonction;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}


	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public void setC(double d) {
		this.d = d;
	}
	
	public Curve(Fonction fonction,int a, int b, double d) {
		this.fonction = fonction;
		this.a = a;
		this.b = b;
		this.d = d;
		
	}

	public void writePoints(Writer writer) {
		// TODO Auto-generated method stub

	}

}
