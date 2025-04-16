package frontiere;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.ControlCreerClient;
import control.ControlReserverTable;
import model.CarnetClientele;

public class BoundaryReserverTable {
	private Scanner scan = new Scanner(System.in);
	private ControlReserverTable controlReserverTable;
	
	public BoundaryReserverTable(ControlReserverTable controlReserverTable) {
		this.controlReserverTable = controlReserverTable;
	}

	public int entrerEntier(String question) {
		boolean entreeCorrecte = false;
		int chiffre = 0;
		do {
			System.out.println(question);
			try {
				chiffre = scan.nextInt();
				entreeCorrecte = true;
			} catch (InputMismatchException e) {
				System.out.println("Vous devez entrer un chiffre positif !");
				scan.next();
				entreeCorrecte = false;
			}
		} while (!(entreeCorrecte && chiffre > 0));
		return chiffre;
	}
	
	public String trouverPossibilite(int jour, int mois, int nombrePersonnes, int numService) {
		int[] possibilites = controlReserverTable.trouverPossibilite(jour,mois,nombrePersonnes,numService);
		for (int i = 0; i < possibilites.length; i++) {
			if(possibilites[i] != 0) {
				return ("Numéro de table : " + Integer.toString(possibilites[i]));
			}
		}
		
	}
	
	public void reserverTable(int numClient) {
		System.out.println("Quand souhaitez vous reserver ?");
		int mois = entrerEntier("Pour quel mois ?");
		int jour = entrerEntier("Pour quel jour ?");
		int nbPersonnes = entrerEntier("Pour combien de personnes ?");
		int numService = entrerEntier("Pour quel service ?");
		
		System.out.println("Choisissez votre table ?");
		String numTable = scan.next();
		int intNumTable = Integer.parseInt(numTable);
		controlReserverTable.reserver(numClient,intNumTable,trouverPossibilite[0]);
	}
	
	public void main(String[] args) {
		System.out.println("Quand souhaitez vous reserver ?");
		int mois = entrerEntier("Pour quel mois ?");
		int jour = entrerEntier("Pour quel jour ?");
		int nbPersonnes = entrerEntier("Pour combien de personnes ?");
		int numService = entrerEntier("Pour quel service ?");
	}
}
