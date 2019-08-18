package fr.licinfo.formula;

/**
 * Interface Formula may a be
 * Sum, Product, or Variable 
 * @author tsila
 *
 */
public interface Formula {
	
	String asString();
	double asValue();
	

}
