package fr.licinfo.structure;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * La classe <code>Vector</code> implémente un tableau d'entiers de taille
 * dynamique. Les éléments du vecteur sont stockés dans un tableau. La taille de
 * ce tableau est au minimum doublée à chaque fois qu'il est nécessaire de le
 * faire grossir.
 */
public class Vector {

	/**
	 * Tableau permettant de stocker les éléments du vecteur. Seuls les
	 * <code>size</code> premiers éléments font partie du vecteur. La taille de ce
	 * tableau est égale à la capacité du vecteur, c'est-à-dire, au nombre
	 * d'éléments maximum que le vecteur peut contenir sans avoir besoin d'allouer
	 * un nouveau tableau.
	 */
	private Integer[] elements;

	/**
	 * Nombre d'éléments présents dans le vecteur.
	 */
	private int size;

	/**
	 * Construit un vecteur de capacité initiale <code>initialCapacity</code>.
	 * 
	 * @param initialCapacity Capacité initiale du vecteur
	 */
	public Vector(int initialCapacity) {
		elements = new Integer[initialCapacity];
		size = 0;
	}

	public Vector() {
		this(10);
	}

	/**
	 * Augmente la capacité du vecteur si nécessaire de façon à permettre le
	 * stockage d'au moins <code>minCapacity</code> éléments. S'il est nécessaire
	 * d'augmenter la capacité du vecteur, elle est au minimum doublée.
	 * 
	 * @param minCapacity Capacité minimale à assurer
	 */
	public void ensureCapacity(int minCapacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= minCapacity)
			return;
		int newCapacity = Math.max(oldCapacity * 2, minCapacity);
		elements = Arrays.copyOf(elements, newCapacity);
	}

	public void resize(int newSize) {
		ensureCapacity(newSize);
		this.size = newSize;
	}

	/**
	 * Retourne la capacité du vecteur.
	 * 
	 * @return Capacité du vecteur.
	 */
	public int capacity() {
		return elements.length;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		for (int i = 0; i < this.capacity(); i++) {
			if (elements[i] instanceof Integer) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Rajout l'element <code>element</code> à la fin du vecteur.
	 * 
	 * @param element
	 */
	public void add(int element) {
		
		this.size ++;
		for (int i = 0; i < this.capacity(); i++) {
			if (elements[i] instanceof Integer) {
				// Ne rien faire
			} else {
				elements[i] = element;
				return;
			}
		}

	}

	public void set(int index, int element) {
		elements[index] = element;
	}

	public int get(int index) {
		return elements[index];
	}

	/**
	 * Dépile l'entier en haut de la pile et le retourne.
	 * 
	 */
	public int pop() {

		for (int i = this.capacity()-1; i >= 0; i--) {
			if (elements[i] instanceof Integer) {
				Integer summit = elements[i];
				elements = Arrays.copyOf(elements, i);
				return summit;
			}
		}
		
		return size;
		
//		size--;
//		return elements[size];

	}

	/**
	 * Retourne l'élément en haut de pile, ne dépile pas le vecteur.
	 * 
	 * @return
	 */
	public int peek() {

		for (int i = this.capacity()-1; i >= 0; i--) {
			if (elements[i] instanceof Integer) {
				return elements[i];
			}
		}
		return this.size;
		
	}
}