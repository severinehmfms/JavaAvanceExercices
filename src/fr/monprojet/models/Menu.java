package fr.monprojet.models;

public class Menu {
	private Aliment entree;
    private Aliment plat;
    private Aliment accompagnement;
    private Aliment boisson;
    private Aliment dessert;
    
    public Menu() {
    }
    
	public Menu(Aliment entree, Aliment plat, Aliment accompagnement, Aliment boisson, Aliment dessert) {
		this.entree = entree;
		this.plat = plat;
		this.accompagnement = accompagnement;
		this.boisson = boisson;
		this.dessert = dessert;
	}

	public Aliment getEntree() {
		return entree;
	}

	public void setEntree(Aliment entree) {
		this.entree = entree;
	}

	public Aliment getPlat() {
		return plat;
	}

	public void setPlat(Aliment plat) {
		this.plat = plat;
	}

	public Aliment getAccompagnement() {
		return accompagnement;
	}

	public void setAccompagnement(Aliment accompagnement) {
		this.accompagnement = accompagnement;
	}

	public Aliment getBoisson() {
		return boisson;
	}

	public void setBoisson(Aliment boisson) {
		this.boisson = boisson;
	}

	public Aliment getDessert() {
		return dessert;
	}

	public void setDessert(Aliment dessert) {
		this.dessert = dessert;
	}
	
	/**
	 * Fonction qui calcule le montant total de ce menu
	 * @return
	 */
	public double getTotalMenu() {
		double total = 0;
		if (this.entree != null){
			total += this.entree.getPrice();
		}
		if (this.plat != null){
			total += this.plat.getPrice();
		}
		if (this.accompagnement != null){
			total += this.accompagnement.getPrice();
		}
		if (this.boisson != null){
			total += this.boisson.getPrice();
		}
		if (this.dessert != null){
			total += this.dessert.getPrice();
		}
		return total;
	}
    	
	/**
	 * Méthode qui va afficher le résumé de la commande pour un menu de l'utilisateur
	 * @param commande
	 */
	public void showResumeMenu() { 
		System.out.println("Résumé du menu choisi : ");
		String resume = "[";
		
		//Pour chaque type d'aliment on récupère le choix qui a été fait
		if (this.getEntree() != null)			resume += " - " + this.getEntree().getLabel() + " ";
		if (this.getPlat() != null)				resume += " - " + this.getPlat().getLabel() + " ";
		if (this.getAccompagnement() != null)	resume += " - " + this.getAccompagnement().getLabel() + " ";
		if (this.getBoisson() != null)			resume += " - " + this.getBoisson().getLabel() + " ";
		if (this.getDessert() != null)			resume += " - " + this.getDessert().getLabel() + " ";		
		//Et pour finir on rajoute le crochet fermé pour un joli affichage
		resume += "]";
		System.out.println(resume);
	}
    
}
