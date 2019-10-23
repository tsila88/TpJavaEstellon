package fr.licinfo.arbre;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;

public class Arbre {
	int contenu;
	Arbre filsG, filsD;

	Arbre(Arbre g, int c, Arbre d) {
		filsG = g;
		contenu = c;
		filsD = d;
	}

	Arbre(int c) {
		this.contenu = c;
	}

	static Arbre composer(Arbre g, int c, Arbre d) {
		return new Arbre(g, c, d);
	}

	static int cle(Arbre a) {
		return a.contenu;
	}

	static Arbre filsGauche(Arbre a) {
		return a.filsG;
	}

	static Arbre filsDroit(Arbre a) {
		return a.filsD;
	}

	/**
	 * Taille d'un arbre
	 * 
	 * @param a
	 * @return
	 */
	static int taille(Arbre a) {
		if (a == null)
			return 0;
		return 1 + taille(a.filsG) + taille(a.filsD);
	}

	/**
	 * @param a un arbre
	 * @return la hauteur de l'arbre a
	 */
	public static int hauteur(Arbre a) {
		if (a == null)
			return 0;
		else
			return (1 + Math.max(hauteur(a.filsG), hauteur(a.filsD)));
	}

	static void parcoursPréfixe(Arbre a) {
		if (a == null)
			return;
		System.out.print(a.contenu + " ");
		parcoursPréfixe(a.filsG);
		parcoursPréfixe(a.filsD);
	}

	
	static void parcoursInfixe(Arbre a) {
		if (a == null)
			return;
		parcoursInfixe(a.filsG);
		System.out.print(a.contenu + " ");
		parcoursInfixe(a.filsD);
	}

	static void parcoursSuffixe(Arbre a) {
		if (a == null)
			return;
		parcoursSuffixe(a.filsG);
		parcoursSuffixe(a.filsD);
		System.out.print(a.contenu + " ");
	}

	static void parcoursPréfixeI(Arbre a) {
		if (a == null)
			return;
		Stack<Arbre> p = new Stack<Arbre>();
		p.add(a);
		while (!p.empty()) {
			a = (Arbre) p.peek();
			p.pop();
			System.out.print(a.contenu + " ");
			if (a.filsD != null)
				p.add(a.filsD);
			if (a.filsG != null)
				p.add(a.filsG);
		}
	}

	static void parcoursLargeurI(Arbre a) {
		if (a == null)
			return;
		LinkedList<Arbre> f = new LinkedList<Arbre>();
		f.add(a);
		while (!f.isEmpty()) {
			a = (Arbre) f.peek();
			f.pop();
			System.out.print(a.contenu + " ");
			if (a.filsG != null)
				f.add(a.filsG);
			if (a.filsD != null)
				f.add(a.filsD);
			
		}
	}

	static Optional<Arbre> chercher(int x, Arbre a) {
		if (a == null || x == a.contenu)
			return Optional.ofNullable(a);
		if (x < a.contenu)
			return chercher(x, a.filsG);
		return chercher(x, a.filsD);
	}

	static Optional<Arbre> chercherI(int x, Arbre a) {
		while (a != null && x != a.contenu)
			if (x < a.contenu)
				a = a.filsG;
			else
				a = a.filsD;
		return Optional.ofNullable(a);
	}

	static boolean chercherBol(int x, Arbre a) {
		if (x == a.contenu)
			return true;
		if (x < a.contenu && a.filsG != null) {
			return chercherBol(x, a.filsG);
		}
		if (x > a.contenu && a.filsD != null) {
			return chercherBol(x, a.filsD);
		}
		return false;
	}

	/***
	 * Inserer x dans l'arbre
	 * 
	 * @param x
	 */
	public void insertion(int x) {
		if (x == this.contenu)
			return;

		if (x < this.contenu) {
			if (this.filsG != null)
				this.filsG.insertion(x);
			else
				this.filsG = new Arbre(x);
		}
		if (x > this.contenu) {
			if (this.filsD != null)
				this.filsD.insertion(x);
			else
				this.filsD = new Arbre(x);

		}
	}

	

}
