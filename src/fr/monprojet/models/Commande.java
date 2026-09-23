package fr.monprojet.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Commande {
	
	private ArrayList<Menu> menus;

	public Commande() {
	    this.menus = new ArrayList<>();
	}
	
	public ArrayList<Menu> getMenus() {
		return menus;
	}

	public void setMenus(ArrayList<Menu> menus) {
		this.menus = menus;
	}
	
	/**
	 * Fonction qui ajoute un menu à la commande
	 * @param menu
	 */
	public void addToMenus(Menu menu) {
		this.menus.add(menu);
	}
	
	/**
	 * Fonction qui calcule le total de la commande
	 * @return
	 */
	public double getTotalCommande() {
		double total=0;
		for (Menu menu : this.getMenus()) {
			total += menu.getTotalMenu();
		}
		return total;		
	}

	
	/**
	 * Méthode qui va enregistrer dans un fichier la commande pour pouvoir les imprimer
	 * @param inFile : true si on veut éditer dans un fichier, false si on veut juste afficher à l'écran
	 */
	public void showCommande(boolean inFile) {
		String resume = "";
		
		ArrayList<Menu> menus = this.getMenus();
		
		for (int i = 0; i < menus.size(); i++) {
			resume += "***************Résumé du menu N°"+(i+1)+"***************\n";
			Menu menu = menus.get(i);
			if (menu.getEntree() != null)			resume += menu.getEntree().getLabel() + " - " + menu.getEntree().getPrice() + "€ \n";
			if (menu.getPlat() != null)				resume += menu.getPlat().getLabel() + " - " + menu.getPlat().getPrice() + "\n";
			if (menu.getAccompagnement() != null)	resume += menu.getAccompagnement().getLabel() + " - " + menu.getAccompagnement().getPrice() + "\n";
			if (menu.getBoisson() != null)			resume += menu.getBoisson().getLabel() + " - " + menu.getBoisson().getPrice() + "\n";
			if (menu.getDessert() != null)			resume += menu.getDessert().getLabel() + " - " + menu.getDessert().getPrice() + "\n";
			resume += "Total du menu : " + menu.getTotalMenu();
			resume += "\n\n";
		}
		
		resume += "Total de la commande : " + this.getTotalCommande();
		System.out.println(resume);
		
		//Si on a choisi de l'enregistrer aussi dans un fichier
		if (inFile) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("menu.txt"))) {
				bw.write(resume);
			    bw.newLine();
			    //bw.write("Deuxième ligne");

			} catch (IOException e) {
			    e.printStackTrace();
			}
			System.out.println("Le menu a bien été généré dans le fichier " + new File("menu.txt").getAbsolutePath());
		}			
	}
	
	
}
