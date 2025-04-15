package model;

public class CentraleReservation <E extends EntiteReservable<F>, F extends Formulaire> {

	private E[] entites;
	private int nb_entites = 0;
	
	public CentraleReservation(E[] entites) {
		this.entites = entites;
	}
	
	public int ajouterEntite(E entite) {
		entites[nb_entites] = entite;
		nb_entites++;
		entite.setIdentification(nb_entites);
		return entite.getIdentification();
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int[] entitesLibres = new int[nb_entites];
		for (int i=0; i<nb_entites; i++) {
			if (entites[i].compatible(formulaire)) {
				entitesLibres[i] = entites[i].getIdentification();
			}
			else {
				entitesLibres[i] = 0;
			}
		}
		return entitesLibres;
	}
	
	public Reservation reserver(int numeroEntite, F formulaire) {
		E entite = entites[numeroEntite];
		if (entite == null) {
			throw new IllegalArgumentException("aucune entite n a ce numero");
		}
		
		formulaire.setIdentificationEntite(numeroEntite);
		return entite.reserver(formulaire);
	}
}