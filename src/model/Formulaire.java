package model;

public abstract class Formulaire {
	private int jour;
	private int mois;
	private int indentification;
	
	protected Formulaire(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}

	public int getJour() {
		return jour;
	}
	
	public int getMois() {
		return mois;
	}
	
	public void setIdentificationEntite(int identification) {
		this.indentification = identification;
	}
	
	public int getIdentificationEntite() {
		return indentification;
	}
}
