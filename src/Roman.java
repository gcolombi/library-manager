import java.util.Arrays;

public class Roman extends Livre {

	// Creation de l'enum de prix litteraire

	enum Prixlitt {
		Goncourt, Renaudot, Femina, Senghor, Nebula, Booker, Medicis, Costa
	}

	// Creation des variables

	private Prixlitt[] liste;
	private String descriptif = "<< Ce document est de type Roman, un roman est une oeuvre d'imagination constituee par un recit. >>";

	// Creation du constructeur d'un roman

	public Roman(String id, String titre, int nbreExemplaire, String auteur, int nbrePages, Prixlitt[] liste) {
		super(id, titre, nbreExemplaire, auteur, nbrePages);

		this.liste = liste;
	}

	// Creation getter/setter

	public Prixlitt[] getListe() {
		return liste;
	}

	public void setListe(Prixlitt[] liste) {
		this.liste = liste;
	}

	// Methode polymorphe

	@Override
	public String description() {

		return descriptif;
	}

	// Creation de la methode toString

	@Override
	public String toString() {
		return super.toString() + "\nPrix litteraire(s): " + Arrays.toString(liste)
				+ "\n______________________________________________________________________";

	}

}
