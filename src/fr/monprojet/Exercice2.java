package fr.monprojet;

import java.util.Date;
import java.util.Scanner;

import fr.monprojet.utils.Functions;

public class Exercice2 {
	
	//On initialise le scanner
	private static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) throws Exception {
		
		//Exercice 2.1
		Date date = null;
		Date today = new Date();
		System.out.println(today);
		try{			
			if (date != null) {
				System.out.println(date.getClass().getName());
			}
			if (today != null) {
				System.out.println(today.getClass().getName());
			}
		}catch(NullPointerException e) {
			System.out.println("La date ne peut pas être nulle");
			e.printStackTrace();
			//System.out.println(e);
		}
		
		//Exercice 2.2 (voir dans Functions : input_date_fr_exceptions)
		Date saisie = Functions.input_date_fr_exceptions(scanner, "Entrez une date");
		System.out.println("Vous avez saisi : " + saisie);
		
		
		
		
		//On referme le scanner
		scanner.close();
	}
}
