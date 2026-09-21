package fr.monprojet.models;
/**
 * Classe Article
 */

public class Article {
	
	private int identifiant;
	private String description;
	private String brand;
	private double price;
	
	
	/**
	 * Méthode toString de base
	 */
	public String toString() {
		return this.identifiant + " - " + this.description + " - " + this.brand + " - " + this.price;
	}

	/**
	 * Constructeur complet pour quand l'identifiant est connu
	 * @param identifiant
	 * @param description
	 * @param brand
	 * @param price
	 */
	public Article(int identifiant, String description, String brand, double price) {
		this.identifiant = identifiant;
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
	
	/**
	 * Constructeur incomplet quand l'identifiant n'est pas connu
	 * @param description
	 * @param brand
	 * @param price
	 */
	public Article(String description, String brand, double price) {
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.identifiant = 0;
	}


	public int getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
