package fr.monprojet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant au TP2 - DEV Java - Puis reprise pour l'exercice 4 Java Avancé
 */

public class BaseTP2Resto{
	private static Scanner scanner = new Scanner(System.in);	
	private static int nb_choix = 5;
	
	private static enum Entree {
		SALADE, SOUPE, QUICHE, AUCUNE
	}
	private static enum Plat {
		POULET, BOEUF, POISSON, VEGETARIEN, VEGAN, AUCUN
		}
	private static enum Accompagnement {
		RIZ, PATES, FRITES, LEGUMES, AUCUN
		}
	private static enum Boisson {
		EAU_PLATE, EAU_GAZEUSE, SODA, VIN, AUCUNE
		}
	private static enum Dessert {
		TARTE_MAISON, MOUSSE_AU_CHOCOLAT, TIRAMISU, AUCUN
		}
	
	//Création d'un enum TypeRepas qui contient les types d'aliments pour faciliter la factorisation du code
	private static enum TypeRepas {
	    ENTREE("Entrée", Entree.values()),
	    PLAT("Plat", Plat.values()),
	    ACCOMPAGNEMENT("Accompagnement", Accompagnement.values()),
	    BOISSON("Boisson", Boisson.values()),
	    DESSERT("Dessert", Dessert.values());

	    private final String libelle;
	    private final Enum<?>[] choix;

	    TypeRepas(String libelle, Enum<?>[] choix) {
	        this.libelle = libelle;
	        this.choix = choix;
	    }

	    public String getLibelle() {
	        return libelle;
	    }

	    public Enum<?>[] getChoix() {
	        return choix;
	    }
	}
	
	public static void main(String[] args){
		
		//TODO Penser à décommenter pour que le programme fonctionne complétement		
		int[][] commandes = userCommand();
		
		//Pour test : 
		/*int[][] commandes = new int[][] {
		    {0, 1, 2, 2, 3},
		    {2, 0, 1, 0, 2},
		    {1, 4, 1, 4, 1}
		};*/
		save_menu_file(commandes);
		
		//On referme le scanner
		scanner.close();
	}
	
	public static int[][] userCommand(){
		//On demande à l'utilisateur combien de menus il veut commander
		int nb_menus = input_int("Bonjour, combien de menus souhaitez vous ?", 1, 10);
		int [][] commandes = new int [nb_menus][nb_choix];
		
		//Pour chaque commande que souhaite faire l'utilisateur
		for (int i = 0; i < nb_menus; i++) {
			System.out.println("Commande numéro " + (i+1) + " : ");
			int [] commande = new int [TypeRepas.values().length];
			
			//Pour chaque type d'aliment, on demande à l'utilisateur ce qu'il veut commander
			int cptcommande = 0;
			for (TypeRepas type : TypeRepas.values()) {
				int choice_typemeal = input_choice_item("Que souhaitez vous comme "+type.getLibelle()+" ? [Saisir le chiffre correspondant] ", type);
				commande[cptcommande] = choice_typemeal;
				cptcommande ++ ;
			}
			
			//On rajoute la commande dans le tableaux des commandes
			commandes[i] = commande;
			
			//On affiche le résumé de la commande (i+1)
			print_resume_commande(commandes[i],i+1);
		}
		return commandes;
	}
	
	/**
	 * Méthode qui permet de proposer les items d'un enum (exemple proposer les entrées possibles pour une entrée), et de scanner le résultat de l'utilisateur 
	 * @param prompt
	 * @param choix
	 * @return
	 */
	public static int input_choice_item(String prompt, TypeRepas type_meal) {
		int item_chosen;
		String item_str = "";
		//On récupère la liste des choix possibles pour le type d'aliment choisi (exemple pour les entrées, il y aura salade, soupe, quiche...)
		Enum<?>[] choix = type_meal.getChoix();
		
		System.out.print("Choix "+type_meal.getLibelle()+" : ");
		
		for (int i = 0; i < choix.length; i++) {
			//On remplace les _ par des espaces pour l'affichage
			item_str = choix[i].name().replace('_', ' ');
	        System.out.print("[" + (i + 1) + " - " + item_str  + "] ");  
	    }
		System.out.println();
		item_chosen = input_int(prompt, 1, choix.length);
		//On enlève 1 car les enums commencent à zéro pour stocker le bon indice
		item_chosen --;
	    return item_chosen;
	}
	
	/**
	 * Fonction générique pour faire saisir à l'utilisateur un int entre min_val et max_val
	 * @param prompt
	 * @param min_val
	 * @param max_val
	 * @return
	 */
	public static int input_int(String prompt, int min_val, int max_val) {
		int input_int_user = 0;
		boolean is_valid_input = false;
	    while (!is_valid_input) {
	    	System.out.println(prompt);
	    	String input_user = scanner.nextLine();

	        if (input_user.matches("\\d+")) {
	        	input_int_user = Integer.parseInt(input_user);

	            if (input_int_user >= min_val && input_int_user <= max_val) {
	            	is_valid_input = true;
	            } else {
	            	System.out.println("Le nombre doit être compris entre " + min_val + " et " + max_val);
	            }
	        } else {
	            System.out.println("Vous devez saisir un entier.");
	        }
	    }
		return input_int_user;
	}
	
	
	/**
	 * Méthode qui va afficher le résumé de la commande pour un menu de l'utilisateur
	 * @param commande
	 */
	public static void print_resume_commande(int[] commande, int num_commande) { 
		System.out.println("Résumé de la commande " + num_commande + " : ");
		String resume = "[";
				
		//Pour chaque type d'aliment on récupère le choix qui a été fait
		int cptcommande = 0;
		for (TypeRepas type : TypeRepas.values()) {
			//Si le choix est aucun ou aucune on ne l'ajoute pas au résumé
			if (!type.getChoix()[commande[cptcommande]].name().startsWith("AUCUN")){
				resume += type.getChoix()[commande[cptcommande]] + " ";
			}
			cptcommande++;
		}
		
		//On remplace si plusieurs espaces par un seul espace (en cas de beaucoup de AUCUN/AUCUNE choisis)
		resume = resume.replaceAll("\\s+", " ");
		//On remplace les espaces par des virgules
		resume = resume.replace(" ", ",");
		//Si le résumé se termine par une virgule on supprime la virgule finale
		if (resume.endsWith(",")) {
			resume = resume.substring(0, resume.length() - 1);
		}
		//On remplace l'underscore (utilisé dans les enum) par un espace pour un affichage plus propre
		resume = resume.replace('_', ' ');
		//Et pour finir on rajoute le crochet fermé pour un joli affichage
		resume += "]";
		System.out.println(resume);
	}
	
	/**
	 * Méthode qui va enregistrer dans un fichier la liste des commandes pour pouvoir les imprimer
	 * @param commandes
	 */
	public static void save_menu_file(int[][] commandes) {
		String resume = "";
		
		for (int i = 0; i < commandes.length; i++) {
			resume += "***************Résumé de la commande N°"+(i+1)+"***************\n";
		    
			int[] commande = commandes[i];
			//Pour chaque type d'aliment on récupère le choix qui a été fait
			int cptcommande = 0;
			for (TypeRepas type : TypeRepas.values()) {
				//Si le choix est aucun ou aucune on ne l'ajoute pas au résumé
				if (!type.getChoix()[commande[cptcommande]].name().startsWith("AUCUN")){
					resume += type.getChoix()[commande[cptcommande]] + "\n";
				}
				cptcommande++;
			}
		}
		System.out.println(resume);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("menu.txt"))) {
			System.out.println(new File("menu.txt").getAbsolutePath());

		    bw.write(resume);
		    bw.newLine();
		    //bw.write("Deuxième ligne");

		} catch (IOException e) {
		    e.printStackTrace();
		}
		System.out.println("Le menu a bien été généré");
			
	}
	
}