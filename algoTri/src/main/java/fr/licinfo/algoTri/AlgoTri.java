package fr.licinfo.algoTri;

import javax.swing.text.TabExpander;

public class AlgoTri {

	AlgoTri() {

	}

	// Afficher le tableau

	public void afficheTableau(int[] tab) {

		for (int i = 0; i < tab.length; i++) {

			System.out.println("Tab[" + i + "] = " + tab[i] + "");
		}
	}

	public void afficheListeTrie(int[] tab) {

		String listeTrie = "Liste trié = ";
		for (int i = 0; i < tab.length; i++) {

			listeTrie += tab[i] + ",";
		}
		System.out.println(listeTrie);
	}

	/**
	 * Algortithme de tri par insertion.
	 * 
	 * @param tabAtrier
	 */
	public void triInsertion(int[] tabAtrier) {

		int elementEnCours, j = 0;

		for (int i = 0; i < tabAtrier.length; i++) {

			elementEnCours = tabAtrier[i];
			j = i;

			while (j > 0 && tabAtrier[j - 1] > elementEnCours) {

				tabAtrier[j] = tabAtrier[j - 1];
				j--;
			}
			tabAtrier[j] = elementEnCours;
		}

		System.out.println("ALGORITHME DE TRI PAR INSERTION");
		afficheTableau(tabAtrier);
		afficheListeTrie(tabAtrier);

	}

	/**
	 * Algorithme de tri sélection
	 * 
	 * @param tabAtrier
	 * 
	 */
	public void triSelection(int[] tabAtrier) {

		int min, temp = 0;

		for (int i = 0; i < tabAtrier.length - 1; i++) {

			min = i;
			for (int j = i + 1; j < tabAtrier.length; j++) {
				if (tabAtrier[j] < tabAtrier[min]) {
					min = j;
				}
			}

			if (min != i) {
				temp = tabAtrier[min];
				tabAtrier[min] = tabAtrier[i];
				tabAtrier[i] = temp;
			}
		}
		System.out.println("ALGORITHME DE TRI PAR SELECTION");
		afficheTableau(tabAtrier);
		afficheListeTrie(tabAtrier);

	}

	/***
	 * Algo de TriBulle
	 * 
	 * @param tabAtrier
	 */
	public void triBulle(int[] tabAtrier) {

		boolean tab_trie = false;
		int tmp = 0, tailleTab = tabAtrier.length - 1;

		while (!tab_trie) {
			tab_trie = true;
			for (int i = 0; i < tailleTab; i++) {

				if (tabAtrier[i] > tabAtrier[i + 1]) {
					tmp = tabAtrier[i + 1];
					tabAtrier[i + 1] = tabAtrier[i];
					tabAtrier[i] = tmp;
					tab_trie = false;
				}
			}
			tailleTab--;
		}

		System.out.println("ALGORITHME DE TRI BULLE");
		afficheTableau(tabAtrier);
		afficheListeTrie(tabAtrier);

	}

	/***
	 * Algo de TriFusion
	 * 
	 * Par ordre croissant d'un tableau d'entiers des indices indi à indf compris
	 * 
	 * t: tableau d'int à trier par ordre croissant indi: indice initial des valeurs
	 * à trier indf: indice fianle des valeurs à trier
	 * 
	 * @param tabAtrier
	 */

	public void triFusion(int[] tab, int indi, int indf) {
		int nbVal = indf - indi + 1;

		if (nbVal > 1) {
			if (nbVal == 2) {
				if (tab[indi] > tab[indf]) {
					int temp = tab[indi];
					tab[indi] = tab[indf];
					tab[indf] = temp;
				}
			} else { // nbVal > 2, donc plusieurs élèments dans le tab
				int milieu = (indf + indi) / 2;
				triFusion(tab, indi, milieu);
				triFusion(tab, milieu + 1, indf);
				fusion(tab, indi, milieu - indi + 1, indf - milieu);
			}
		}
	}

	public void triFusion(int[] tabAtrier) {

		triFusion(tabAtrier, 0, tabAtrier.length - 1);
		System.out.println("ALGORITHME DE TRI FUSION");
		afficheTableau(tabAtrier);
		afficheListeTrie(tabAtrier);

	}

	/***
	 * Fusion: Action de fusion de 2 tableaux en un tableau trie par ordre croissant
	 * 2 tableau trié définis au sein d'un tableau d'entiers Le sous-tableau 1
	 * contient les t1 entiers situés à partir de l'indice i1 Le sous-tableau 2
	 * contient les t2 entiers situés à partir de l'indice i1+t1
	 * 
	 * t: le tableau d'entiers contenant les deux sous tableau indiceT1: indice dans
	 * t du premier entier du premier sous tableau tailleT1: La taille du premier
	 * sous tableau tailleT2: La taille du second sous tableau
	 * 
	 */

	static void fusion(int[] t, int i1, int t1, int t2) {
		int deb = i1;
		int i2 = i1 + t1;
		int l = t1 + t2;
		int l1 = i1 + t1;
		int l2 = l1 + t2;
		int[] tf = new int[l];
		for (int i = 0; i < l; i++) {
			if (i1 == l1) {
				tf[i] = t[i2];
				i2++;
			} else {
				if (i2 == l2) {
					tf[i] = t[i1];
					i1++;
				} else {
					if (t[i1] < t[i2]) {
						tf[i] = t[i1];
						i1++;
					} else {
						tf[i] = t[i2];
						i2++;
					}
				}
			}
		}
		for (int i = 0; i < l; i++) {
			t[deb + i] = tf[i];
		}
	}

	/****
	 * Algorithme TRI-RAPIDE
	 * 
	 * 
	 */

	/***
	 * Fonction de tri rapide par ordre croissant d'un tableau d'int des indices
	 * indi a indf compris Méthode de choix du pivot : Valeur située à l'indice
	 * moyen de indi et indf t : Le tableau d'int à trier par ordre croissant indi :
	 * L'indice initial des valeurs à trier indf : L'indice final des valeurs à
	 * trier
	 * 
	 * 
	 */
	public void triRapide(int[] t, int indi, int indf) {

		int nbVal = indf - indi + 1;
		if (nbVal > 1) {
			if (nbVal == 2) {
				if (t[indf] < t[indi]) {
					int aux = t[indi];
					t[indi] = t[indf];
					t[indf] = aux;
				}
			} else {
				int pivot = (indi + indf) >> 1;
				int iMedian = pivotage(t, indi, indf, pivot);
				triRapide(t, indi, iMedian - 1);
				triRapide(t, iMedian + 1, indf);
			}
		}
	}

	/* Fonction de reorganisation d'un tableau */
	/* d'entiers des indices indi a indf inclus */
	/* par replacage a gauche de toutes les valeurs */
	/* plus petites que t[pivot], a droite de toutes */
	/* les valeurs plus grandes que t[pivot] */
	/* et au centre de toutes les valeurs egales */
	/* a t[pivot] */
	/* Retourne l'indice de la valeur d'indice */
	/* maximum, apres replacage, de toutes */
	/* les valeurs egales a t[pivot] */

	static int pivotage(int[] t, int indi, int indf, int pivot) {
		int j = indi;
		int aux = t[pivot];
		t[pivot] = t[indf];
		t[indf] = aux;
		for (int i = indi; i < indf; i++) {
			if (t[i] <= t[indf]) {
				if (i != j) {
					aux = t[i];
					t[i] = t[j];
					t[j] = aux;
				}
				j++;
			}
		}
		if (indf != j) {
			aux = t[indf];
			t[indf] = t[j];
			t[j] = aux;
		}
		return j;
	}

	/* Fonction de tri rapide par ordre croissant */
	/* d'un tableau d'int */
	/* Pivot choisi : Valeur médiane du tableau */
	/* t : Le tableau d'int à trier */
	/* par ordre croissant */

	public void triRapide(int[] tabAtrier) {
		triRapide(tabAtrier, 0, tabAtrier.length - 1);
		System.out.println("ALGORITHME DE TRI FUSION");
		afficheTableau(tabAtrier);
		afficheListeTrie(tabAtrier);
	}
}
