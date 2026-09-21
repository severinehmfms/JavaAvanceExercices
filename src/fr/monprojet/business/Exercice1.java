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
	
	public static void listArticles() {
		ArticleDao ad = new ArticleDao();
		ArrayList<Article> articles = (ArrayList<Article>) ad.readAll();
		for (Article article : articles) {
			System.out.println(article); 
		}
	}
	
	public static void showArticle() {
		ArticleDao ad = new ArticleDao();
		int idArticle = Functions.input_int(scanner, "Entrez le numéro de l'article à afficher");
		Article article = ad.readById(idArticle);	
		System.out.println(article);
	}	
	
	public static void addArticle() {
		System.out.println("Ajout d'un article");
		Article article = new Article("Lunettes de soleil","Surfrider",20);
		ArticleDao ad = new ArticleDao();
		ad.create(article);
		
	}
	
	public static void updateArticle() {
		System.out.println("Modification d'un article");
		
	}
	
	public static void deleteArticle() {
		System.out.println("Suppression d'un article");
		
	}
		
}
