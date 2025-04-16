package model;

public class ReservationRestaurant extends Reservation{
	//Attributes
	private int num_service;
	private int num_table;

	//Constructor
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