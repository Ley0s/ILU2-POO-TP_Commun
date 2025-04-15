package model;

public abstract class Reservation {
	//Attributs
	private int jour;
	private int mois;
	
	protected Reservation(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	public int getMois() {
		return mois;
	}
	
	public int getJour() {
		return jour;
	}
	
	public abstract String toString();
}
