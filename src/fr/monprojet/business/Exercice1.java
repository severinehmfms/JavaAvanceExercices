package fr.monprojet.business;


import java.util.ArrayList;
import java.util.Scanner;

import fr.monprojet.daos.ArticleDao;
import fr.monprojet.models.Article;
import fr.monprojet.utils.Functions;

/**
 * Classe qui représente l'exercice 1
 */

public class Exercice1 {
	
	//On initialise le scanner
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){		
		String[] menu = {
				"Lister les articles",
				"Voir un article",
			    "Créer un article",
			    "Modifier un article",
			    "Supprimer un article",
			};
		
		int choice_user = -1;
		while (choice_user != 0) {
			//On demande à l'utilisateur son choix par rapport au menu proposé
			choice_user = Functions.ask_user_choice(scanner, menu);
			switch(choice_user) {
				case 1:				
					//Lister les articles (ok)
					listArticles();
					break;
				case 2:				
					//Voir un article
					showArticle();
					break;				
				case 3:				
					//Ajout d'un article (ok)
					addArticle();
					break;
				case 4:
					//Modification d'un article
					updateArticle();
					break;
				case 5:	
					//Suppression d'un article
					deleteArticle();
					break;	
				case 0:
					System.out.println("Au-revoir et à bientôt !");
					break;
			}
		}
		
		//On referme le scanner
		scanner.close();
	}
	
	/**
	 * Méthode qui va afficher tous les articles
	 */
	public static void listArticles() {
		ArticleDao ad = new ArticleDao();
		ArrayList<Article> articles = (ArrayList<Article>) ad.readAll();
		for (Article article : articles) {
			System.out.println(article); 
		}
	}
	
	/**
	 * Méthode qui va afficher un article par son id
	 */
	public static void showArticle() {
		ArticleDao ad = new ArticleDao();
		int idArticle = Functions.input_int(scanner, "Entrez le numéro de l'article à afficher");
		Article article = ad.readById(idArticle);	
		System.out.println(article);
	}	
	
	/**
	 * Méthode pour créer un article
	 */
	public static void addArticle() {
		System.out.println("Création d'un article");
		
		String description = Functions.input_string(scanner, "Entrez la description de l'article");
		String brand = Functions.input_string(scanner, "Entrez la marque de l'article");
		double price = Functions.input_double(scanner, "Entrez le prix de l'article");
		
		Article article = new Article(description,brand,price);		
		ArticleDao ad = new ArticleDao();
		article = ad.create(article);
		if (article == null) {
			System.out.println("ERREUR lors de la création de l'article");
		}else {
			System.out.println("Création de cet article bien effectuée : ");
			System.out.println(article);
		}		
	}
	
	/**
	 * Méthode pour modifier un article
	 */
	public static void updateArticle() {
		System.out.println("Modification d'un article");
		ArticleDao ad = new ArticleDao();
		int idArticle = Functions.input_int(scanner, "Entrez le numéro de l'article à modifier");
		Article article = ad.readById(idArticle);	
		System.out.println(article);
		
		String description = Functions.input_string(scanner, "Entrez la nouvelle description de l'article");
		String brand = Functions.input_string(scanner, "Entrez la nouvelle marque de l'article");
		double price = Functions.input_double(scanner, "Entrez le nouveau prix de l'article");
		article.setDescription(description);
		article.setBrand(brand);
		article.setPrice(price);
		if (ad.update(article)) {
			System.out.println("Modification bien effectuée");
		}else {
			System.out.println("ERREUR lors de la modification de cet article");
		}		
	}
	
	/**
	 * Méthode pour supprimer un article
	 */
	public static void deleteArticle() {
		System.out.println("Suppression d'un article");
		
		ArticleDao ad = new ArticleDao();
		int idArticle = Functions.input_int(scanner, "Entrez le numéro de l'article à modifier");
		Article article = ad.readById(idArticle);	
		System.out.println(article);
		
		if (Functions.input_yes_no(scanner, "Etes vous sur de vouloir supprimer cet article ?")) {
			if (ad.delete(idArticle)) {
				System.out.println("Suppression bien effectuée");
			}else {
				System.out.println("ERREUR lors de la suppression de cet article");
			}
		}else {
			System.out.println("Annulation de la suppression");
		}
	}
		
}
