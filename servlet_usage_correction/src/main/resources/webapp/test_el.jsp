<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Test des expressions EL</title>
</head>
<body>
	<p>
		<!-- Logiques sur des bool�ens -->
		${ true && true } <br />
		<!-- Affiche true -->
		${ true && false } <br />
		<!-- Affiche false -->
		${ !true || false } <br />
		<!-- Affiche false -->

		<!-- Calculs arithm�tiques -->
		${ 10 / 4 } <br />
		<!-- Affiche 2.5 -->
		${ 10 mod 4 } <br />
		<!-- Affiche le reste de la division enti�re, soit 2 -->
		${ 10 % 4 } <br />
		<!-- Affiche le reste de la division enti�re, soit 2 -->
		${ 6 * 7 } <br />
		<!-- Affiche 42 -->
		${ 63 - 8 } <br />
		<!-- Affiche 55 -->
		${ 12 / -8 } <br />
		<!-- Affiche -1.5 -->
		${ 7 / 0 } <br />
		<!-- Affiche Infinity -->

		<!-- Compare les caract�res 'a' et 'b'. Le caract�re 'a' �tant bien situ� avant le caract�re 'b' dans l'alphabet ASCII, cette EL affiche true. -->
		${ 'a' < 'b' } <br />

		<!-- Compare les cha�nes 'hip' et 'hit'. Puisque 'p' < 't', cette EL affiche false. -->
		${ 'hip' gt 'hit' } <br />

		<!-- Compare les caract�res 'a' et 'b', puis les cha�nes 'hip' et 'hit'. Puisque le premier test renvoie true et le second false, le r�sultat est false. -->
		${ 'a' < 'b' && 'hip' gt 'hit' } <br />

		<!-- Compare le r�sultat d'un calcul � une valeur fixe. Ici, 6 x 7 vaut 42 et non pas 48, le r�sultat est false. -->
		${ 6 * 7 == 48 } <br />

		<!-- V�rifications si vide ou null -->
		${ empty 'test' } <br />
		<!-- La cha�ne test�e n'est pas vide, le r�sultat est false -->
		${ empty '' } <br />
		<!-- La cha�ne test�e est vide, le r�sultat est true -->
		${ !empty '' } <br />
		<!-- La cha�ne test�e est vide, le r�sultat est false -->

		<!-- Conditions ternaires -->
		${ true ? 'vrai' : 'faux' } <br />
		<!-- Le bool�en test� vaut true, vrai est affich� -->
		${ 'a' > 'b' ? 'oui'  : 'non' } <br />
		<!-- Le r�sultat de la comparaison vaut false, non est affich� -->
		${ empty 'test' ? 'vide' : 'non  vide'  } <br />
		<!-- La cha�ne test�e n'est pas vide, non vide est affich� -->
	</p>

	<!-- La ligne suivante : -->
	<p>12 est inf�rieur � 8 : ${ 12 lt 8 }.</p>

	<!-- Sera rendue ainsi apr�s interpr�tation de l'expression, 12 n'�tant pas inf�rieur � 8 : -->
	<p>12 est inf�rieur � 8 : false.</p>


</body>
</html>