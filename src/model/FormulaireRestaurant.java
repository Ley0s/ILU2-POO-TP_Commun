package model;

public class FormulaireRestaurant extends Formulaire{
	int nb_personnes;
	int num_service;
	
	public FormulaireRestaurant(int jour, int mois, int nb_personnes, int num_service){
		super(new ReservationRestaurant(jour, mois, num_service, 0));
		this.nb_personnes = nb_personnes;
		this.num_service = num_service;
	}
	
	public int getNumService() {
		return num_service;
	}
	
	public int getNombrePersonnes() {
		return nb_personnes;
	}
}
