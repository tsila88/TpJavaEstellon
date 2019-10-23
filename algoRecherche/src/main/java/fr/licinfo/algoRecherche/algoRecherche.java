package fr.licinfo.algoRecherche;

public class algoRecherche {

	public algoRecherche() {
		// TODO Auto-generated constructor stub
	}

	/*****
	 * Algo de recherche Minimum
	 * 
	 */
	public int valeurMinimale(int[] t) {
		int min = t[0];
		for (int i = 1; i < t.length; i++) {
			if (t[i] < min) {
				min = t[i];
			}
		}
		return min;
	}

	/***
	 * Algo avec test de présence
	 * 
	 */
	public boolean estPresent(int v, int[] t) {
		boolean trouve = false;
		int i = 0;
		while ((trouve == false) && (i < t.length)) {
			if (t[i] == v) {
				trouve = true;
			} else {
				i++;
			}
		}
		return trouve;
	}

	/***
	 * Algo sequentiel Ameliorer
	 * 
	 */
	/* Recherche sequentielle de la presence */
	/* d'un int dans un tableau de int trie */
	/* Version optimisee */
	/* v : Entier recherché */
	/* t : Tableau d'entiers de recherche */
	/* (trié par ordre croissant) */

	static boolean estPresent2(int v, int[] t) {
		int i = 0;
		while ((i != t.length) && (t[i] < v)) {
			i++;
		}
		return ((i < t.length) && (t[i] == v));
	}

	/****
	 * ALGORITHME DE RECHERHCE DICHOTOMIQUE
	 * 
	 * 
	 */
	public boolean estPresentDichotomique(int v, int[] t) {
		boolean run = true;
		boolean trouve = false;
		int indi = 0;
		int indf = t.length - 1;
		int indm;
		while (run == true) {
//		    if ( indf == indi ) {//tableau 1 valeurs
//		      if ( t[indi] == v ) {
//		        trouve = true; }
//		      run = false; }
//		      else {
//		      if ( indf == indi+1 ) {//Tableau 2 valeurs restants
//		        if ( ( t[indi] == v ) || ( t[indf] == v ) ) {
//		          trouve = true; }
//		        run = false; }
//		        else {
//		        indm = (indi+indf)/2;
//		        if ( t[indm] == v ) {
//		          run = false;
//		          trouve = true; }
//		          else {
//		          if ( v < t[indm] ) {
//		            indf = indm-1; }
//		            else {
//		            indi = indm+1; } } } } }
//		  return trouve ;

			if (indf == indi) {// tableau 1 valeurs
				if (t[indi] == v) {
					trouve = true;
				}
				run = false;
				return trouve;
			}
			if (indf == indi + 1) {// Tableau 2 valeurs restants
				if ((t[indi] == v) || (t[indf] == v)) {
					trouve = true;
				}
				run = false;
				return trouve;
			}
			// Division en 2 du tableau
			indm = (indi + indf) / 2;
			if (t[indm] == v) {
				run = false;
				trouve = true;
				return trouve;
			}

			if (v < t[indm]) {
				indf = indm - 1;
			} else {
				indi = indm + 1;
			}
			return trouve = false;

		}
		return false;
	}

	/**
	 * Affichage du valeur trouve
	 * 
	 */

	public void affichageDichotomie(int v, int[] tab) {

		boolean b = this.estPresentDichotomique(v, tab);
		if (b == true) {
			System.out.println("La valeur v=" + v + " est présent ");
		}
		if (b == false) {
			
			System.out.println("La valeur v: " + v + " n'est pas présent");
		}

	}
	
	
	public void verifeIncrementation() {
		
		int i = 0;
		System.out.println("La valeur de i = "+i++);
		
		
	}

}
