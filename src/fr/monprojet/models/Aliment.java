package fr.monprojet.models;

import java.util.ArrayList;
import java.util.List;

public class Aliment {
	private int numChoice;
	private TypeAliment type;
	private String label;
	private double price;
	
	public static enum TypeAliment {
		ENTREE, PLAT, ACCOMPAGNEMENT, BOISSON, DESSERT
	}
	
	public String toString() {
		return this.numChoice + " - " + this.label + " - " + this.price;
	}

	public Aliment(TypeAliment type, int numChoice, String label, double price) {
		this.type = type;
		this.numChoice = numChoice;
		this.label = label;
		this.price = price;
	}

	public int getNumChoice() {
		return numChoice;
	}

	public void setNumChoice(int numChoice) {
		this.numChoice = numChoice;
	}

	public TypeAliment getType() {
		return type;
	}

	public void setType(TypeAliment type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Méthode qui initialise les aliments disponibles , et leur type (en dur)
	 */
	public static List<Aliment> initAliments() {
		
		List<Aliment> aliments = new ArrayList();
		//Entrées SALADE, SOUPE, QUICHE
        aliments.add(new Aliment(Aliment.TypeAliment.ENTREE, 1, "Salade", 5.50));
        aliments.add(new Aliment(Aliment.TypeAliment.ENTREE, 2, "Soupe", 4.50));
        aliments.add(new Aliment(Aliment.TypeAliment.ENTREE, 3, "Quiche", 6.50));
        
        //Plats 
        //POULET, BOEUF, POISSON, VEGETARIEN, VEGAN
        aliments.add(new Aliment(Aliment.TypeAliment.PLAT, 1, "Poulet", 5));
        aliments.add(new Aliment(Aliment.TypeAliment.PLAT, 2, "Boeuf", 6.50));
        aliments.add(new Aliment(Aliment.TypeAliment.PLAT, 3, "Poisson", 6.50));
        aliments.add(new Aliment(Aliment.TypeAliment.PLAT, 4, "Végétarien", 5.50));
        aliments.add(new Aliment(Aliment.TypeAliment.PLAT, 5, "Vegan", 6));
        
        //Accompagnements
        //RIZ, PATES, FRITES, LEGUMES
        aliments.add(new Aliment(Aliment.TypeAliment.ACCOMPAGNEMENT, 1, "Riz", 2.50));
        aliments.add(new Aliment(Aliment.TypeAliment.ACCOMPAGNEMENT, 2, "Pâtes", 2.50));
        aliments.add(new Aliment(Aliment.TypeAliment.ACCOMPAGNEMENT, 3, "Frites", 2));
        aliments.add(new Aliment(Aliment.TypeAliment.ACCOMPAGNEMENT, 4, "Légumes", 3.50));
                
        //Boissons
        //EAU_PLATE, EAU_GAZEUSE, SODA, VIN
        aliments.add(new Aliment(Aliment.TypeAliment.BOISSON, 1, "Eau plate", 2.50));
        aliments.add(new Aliment(Aliment.TypeAliment.BOISSON, 2, "Eau gazeuse", 2.50));
        aliments.add(new Aliment(Aliment.TypeAliment.BOISSON, 3, "Soda", 2));
        aliments.add(new Aliment(Aliment.TypeAliment.BOISSON, 4, "Vin", 3.50));
        
        //Desserts
        //TARTE_MAISON, MOUSSE_AU_CHOCOLAT, TIRAMISU
        aliments.add(new Aliment(Aliment.TypeAliment.DESSERT, 1, "Tarte maison", 3.50));
        aliments.add(new Aliment(Aliment.TypeAliment.DESSERT, 2, "Mousse au chocolat", 3.50));
        aliments.add(new Aliment(Aliment.TypeAliment.DESSERT, 3, "Tiramisu", 4));
        
        return aliments;
	}
	
}
