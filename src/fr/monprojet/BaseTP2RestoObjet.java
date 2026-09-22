package fr.monprojet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.monprojet.utils.Functions;
import fr.monprojet.models.Aliment;
import fr.monprojet.models.Commande;
import fr.monprojet.models.Menu;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant à l'Exercice 4 Java Avancé
 */

public class BaseTP2RestoObjet{
	private static Scanner scanner = new Scanner(System.in);	
	
	private static List<Aliment> aliments;
	
	public static void main(String[] args){		
		//On initialise la liste des aliments
		aliments = Aliment.initAliments();
		
		//On demande sa commande à l'utilisateur
		Commande commande = askUserCommande();		
		
		//On affiche le résumé de la commande, et on l'enregistre aussi dans un fichier texte
		commande.showCommande(true);
		
		//On referme le scanner
		scanner.close();
	}
	
	
	/**
	 * Méthode qui demande à l'utilisateur de faire son choix pour un type d'aliments donné
	 * @param type
	 * @param message
	 * @return
	 */
	public static Aliment choiceByTypeAliment(Scanner scanner, Aliment.TypeAliment type,String message) {

	    for (Aliment aliment : aliments) {
	        if (aliment.getType() == type) {
	            System.out.println(aliment);
	        }
	    }

	    int maxChoice = 0;

	    for (Aliment aliment : aliments) {
	        if (aliment.getType() == type && aliment.getNumChoice() > maxChoice) {
	            maxChoice = aliment.getNumChoice();
	        }
	    }

	    int choix = Functions.input_int(scanner, message, 0, maxChoice);
	    
	    //Si choix = 0 ça veut dire qu'on a pas choisi d'aliments pour ce type (exemple : pas de dessert)
	    if (choix != 0) {
		    for (Aliment aliment : aliments) {
		        if (aliment.getType() == type && aliment.getNumChoice() == choix) {
		            return aliment;
		        }
		    }
	    }

	    return null;
	}
	
	/**
	 * Méthode qui demande à l'utilisateur les informations sur sa commande
	 * @return
	 */
	public static Commande askUserCommande(){
		//On demande à l'utilisateur combien de menus il veut commander
		int nbMenus = Functions.input_int(scanner, "Bonjour, combien de menus souhaitez vous ?", 1, 10);
		
		Commande commande = new Commande();
		
		//Pour chaque commande que souhaite faire l'utilisateur
		for (int i = 0; i < nbMenus; i++) {
			Menu menu = new Menu();
			System.out.println("Menu numéro " + (i+1) + " : ");
			
			Aliment entree = choiceByTypeAliment(
					scanner,
				    Aliment.TypeAliment.ENTREE,
				    "Choisissez le numéro de l'entrée souhaitée ou 0 si vous n'en souhaitez pas"
				);
		
			Aliment plat = choiceByTypeAliment(
					scanner,
				    Aliment.TypeAliment.PLAT,
				    "Choisissez le numéro du plat souhaité ou 0 si vous n'en souhaitez pas"
				);
			
			Aliment accompagnement = choiceByTypeAliment(
					scanner,
				    Aliment.TypeAliment.ACCOMPAGNEMENT,
				    "Choisissez le numéro de l'accompagnement souhaité ou 0 si vous n'en souhaitez pas"
				);
			
			Aliment boisson = choiceByTypeAliment(
					scanner,
				    Aliment.TypeAliment.BOISSON,
				    "Choisissez le numéro de la boisson souhaitée ou 0 si vous n'en souhaitez pas"
				);
			
			Aliment dessert = choiceByTypeAliment(
					scanner,
				    Aliment.TypeAliment.DESSERT,
				    "Choisissez le numéro du dessert souhaité ou 0 si vous n'en souhaitez pas"
				);
			
			if (entree != null) 		menu.setEntree(entree);
			if (plat != null) 			menu.setPlat(plat);
			if (accompagnement != null) menu.setAccompagnement(accompagnement);
			if (boisson != null) 		menu.setBoisson(boisson);
			if (dessert != null) 		menu.setDessert(dessert);
			
			menu.showResumeMenu();
			
			commande.addToMenus(menu);
		}
		
		return commande;
	}
	
}