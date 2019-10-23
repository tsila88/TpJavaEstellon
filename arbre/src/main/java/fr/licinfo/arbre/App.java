package fr.licinfo.arbre;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//    	Tree _6  = new Tree(null,6,null);
//    	Tree _13  = new Tree(null,13,null);
//    	Tree _21  = new Tree(null,21,null);
//    	Tree _28  = new Tree(null,28,null);
//    	Tree _3  = new Tree(null,3,null);
//    	
//    	Tree _8  = new Tree(_6,8,null);
//    	Tree _12  = new Tree(_6,12,_13);
//    	Tree _5  = new Tree(_3,5,_12);
//    	Tree _25  = new Tree(_21,25,_28);
//    	
//    	//Racine
//    	Tree _20 = new Tree(_5,20,_25);

		Arbre A = new Arbre(new Arbre(new Arbre(null, 3, null), 5, new Arbre(new Arbre(new Arbre(null, 6, null), 8, null)

				, 12, new Arbre(null, 13, null))), 20,
				new Arbre(new Arbre(null, 21, null), 25, new Arbre(null, 28, null)));
		
		System.out.println("Contenu de A = "+A.contenu);
		
		System.out.println("Fils gauche de A +"+A.filsG.contenu );
		
		System.out.println("Taille de A = "+A.taille(A));
		
		System.out.println("Hauteur de A = "+A.hauteur(A));
		
		System.out.println("Recherche  dans  A = "+A.chercher(12, A));
		
		System.out.println("Recherche  dans  A = "+A.chercherBol(14, A));
		A.insertion(15);
		A.insertion(30);
		System.out.println("Taille de A = "+A.taille(A));
		A.parcoursInfixe(A);
		System.out.println("");
		A.parcoursLargeurI(A);
		
		System.out.println("");
		A.parcoursLargeurI(A);
	}
}
