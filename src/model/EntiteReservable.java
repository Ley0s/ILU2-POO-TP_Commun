package model;

public abstract class EntiteReservable <F extends Formulaire> {
	protected CalendrierAnnuel calendrier = new CalendrierAnnuel();
	protected int identification;

	public void setIdentification(int identification) {
		this.identification = identification;
	}
	
	public int getIdentification() {
		return identification;
	}
	
	public boolean estLibre(F formulaire) {
		return calendrier.estLibre(formulaire.getJour(), formulaire.getMois());
	}
	
	public abstract boolean compatible(F formulaire);
	
	public abstract Reservation reserver(F formulaire);
}