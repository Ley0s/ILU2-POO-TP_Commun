package model;

public class CentraleReservation <E extends EntiteReservable<F>, F extends Formulaire> {

	private E[] entites;
	private int nbEntites = 0;
	
	public CentraleReservation(E[] entites) {
		this.entites = entites;
	}
	
	public int ajouterEntite(E entite) {
		entites[nbEntites] = entite;
		nbEntites++;
		entite.setIdentification(nbEntites);
		return entite.getIdentification();
	}
	
	public int[] donnerPossibilites(F formulaire) {
		int[] entitesLibres = new int[nbEntites];
		for (int i=0; i<nbEntites; i++) {
			if (entites[i].compatible(formulaire)) {
				System.out.println(i);
				System.out.println(entites[i].getIdentification());
				entitesLibres[i] = entites[i].getIdentification();
				System.out.println(entitesLibres[i]);
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