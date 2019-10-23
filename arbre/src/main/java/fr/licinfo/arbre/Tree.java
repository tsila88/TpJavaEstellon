package fr.licinfo.arbre;

import java.util.List;

public class Tree<T> {

	private T value;
	private Tree<T> filsG, filsD;

	Tree(Tree filsG, T value, Tree filsD) {

		this.filsG = filsG;
		this.filsD = filsD;
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Tree<T> getFilsG() {
		return filsG;
	}

	public void setFilsG(Tree<T> filsG) {
		this.filsG = filsG;
	}

	public Tree<T> getFilsD() {
		return filsD;
	}

	public void setFilsD(Tree<T> filsD) {
		this.filsD = filsD;
	}

	 Tree<T> composer(Tree g,T v,Tree d) {
		
		return new Tree(g,v,d);
	}
	
	
}
