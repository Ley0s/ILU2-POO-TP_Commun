package model;

public class Restaurant implements IEtablissement<FormulaireRestaurant>{
	private CentraleReservation<EntiteReservable<FormulaireRestaurant>, FormulaireRestaurant> centrale
		= new CentraleReservation<>(new Table[20]); 
	
	public void ajouterTable(int nbChaises) {
		centrale.ajouterEntite(new Table(nbChaises));
	}
	
	@Override
	public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
		return centrale.donnerPossibilites(formulaire);
	}

	@Override
	public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
		return centrale.reserver(numEntite, formulaire);
	}
	
	private static class Table extends EntiteReservable<FormulaireRestaurant> {
		private CalendrierAnnuel calendrierDeuxiemeService;
		private int nbChaises;
			
		public Table(int nbChaises) {
			this.nbChaises = nbChaises;
			this.calendrierDeuxiemeService = new CalendrierAnnuel();
		}
		
		@Override
		public boolean compatible(FormulaireRestaurant formulaire) {
			if(formulaire.getNumService() == 1) {
				return (formulaire.getNombrePersonnes() <= nbChaises
						&& formulaire.getNombrePersonnes()+1 >= nbChaises
						&& calendrier.estLibre(formulaire.getJour(), formulaire.getMois()));
			} else {
				return (formulaire.getNombrePersonnes() >= nbChaises
						&& formulaire.getNombrePersonnes() <= nbChaises+1
						&& calendrierDeuxiemeService.estLibre(formulaire.getJour(), formulaire.getMois()));
			}
		}

		@Override
		public Reservation reserver(FormulaireRestaurant formulaire) {
			CalendrierAnnuel calendrierReserver;
			if(formulaire.getNumService() == 1)
				calendrierReserver = calendrier;
			else
				calendrierReserver = calendrierDeuxiemeService;
			if (calendrierReserver.reserver(formulaire.getJour(), formulaire.getMois())) {
				return new ReservationRestaurant(formulaire.getJour(), formulaire.getMois(), 
						formulaire.getNumService(), formulaire.getIdentificationEntite());
			}
			return null;
		}
	}
}
