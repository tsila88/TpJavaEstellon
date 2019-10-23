package fr.licinfo.palindrome;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalimdrome {

	@Test
	public void test() {
		String pal1 = "hannah";
		String pal2  =  "maram";
	 	String pal3 = "ellemelle";
		String pal4 = "senones";
		String pal5 = "laval";
		String pal6 = "qaanaaq";
		String pal7 = "ABBA";
		String pal8 = "nozon";
		
		String notPal = "zoprle";
		String notePal2 = "ZARTE";
		String notePal3 = "Paspalindrome";
		String notePal3String = notePal3.substring(0,7);
		
		Palindromme palindromTesteur = new Palindromme() ; 
		
		assertEquals(palindromTesteur.isPalindrommeString(pal1), true);
		assertEquals(palindromTesteur.isPalindrommeString(notPal), false);
		assertEquals(palindromTesteur.isPalindrommeString(pal1), true);
		assertEquals(notePal3String, "Paspali");
	}

}
