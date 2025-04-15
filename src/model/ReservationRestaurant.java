package model;

public class ReservationRestaurant extends Reservation{
	//Attributs
	private int jour;
	private int mois;
	private int num_service;
	private int num_table;

	//Constructeur
	public ReservationRestaurant(int jour, int mois, int num_service, int num_table) {
		super(jour, mois);
		this.num_service = num_service;
		this.num_table = num_table;
	}
	
	public String toString() {
		String service;
		if (num_service == 1) {
			service = "premier";
		} else {
			service = "deuxième";
		}
		return "Le " + getJour() + "/" + getMois() + "\nTable "
				+ num_table + " pour le " + service + " service.";
	}
}