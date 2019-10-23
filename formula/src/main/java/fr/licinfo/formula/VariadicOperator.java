package fr.licinfo.formula;

public abstract class VariadicOperator implements Formula {
	
	protected abstract double initialValue();
	protected abstract double cumulativeValue(double accumulator, double value);
	protected abstract String symbol();

}
