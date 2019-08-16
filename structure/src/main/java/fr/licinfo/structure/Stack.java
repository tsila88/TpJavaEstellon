package fr.licinfo.structure;

public class Stack {

	private Vector vector;

	public Stack() {
		this.vector = new Vector();
	}

	public Stack(Vector vector) {
		super();
		this.vector = vector;
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	/**
	 * Empile l'entier value
	 * 
	 * @param value
	 */
	public void push(int value) {
		this.vector.add(value);
	}

	/**
	 * Retourne l'entier en haut de la pile
	 * 
	 */
	public int peek() {
		return vector.peek();
	}

	/**
	 * Dépile l'entier en haut de la pile et le retourne
	 * 
	 */
	public int pop() {
		return vector.pop();
	}

	public int size() {
		return this.vector.capacity();
	}

	public boolean isEmpty() {

		return this.vector.isEmpty();
	}

}
