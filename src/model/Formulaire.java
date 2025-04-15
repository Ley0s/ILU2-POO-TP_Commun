package model;

public abstract class Formulaire <T extends Reservation> {
	protected T reservation;
	private int indentification;
	
	protected Formulaire(T Reservation) {
		this.reservation = reservation;
	}

	public int getJour() {
		return reservation.getJour();
	}
	
	public int getMois() {
		return reservation.getMois();
	}
	
	public void setIdentificationEntite(int identification) {
		this.indentification = identification;
	}
	
	public int getIdentificationEntite() {
		return indentification;
	}
}
