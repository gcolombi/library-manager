public class Revue extends Document {

	// Creation des variables d'une Revue

	private String mois;
	private int annee;
	private String descriptif = "<< Ce document est de type revue, une revue est une publication periodique, couvrant un sujet particulier ou une zone d'interet. >>";

	// Creation du constructeur

	public Revue(String id, String titre, int nbreExemplaire, String mois, int annee) {
		super(id, titre, nbreExemplaire);
		this.mois = mois;
		this.annee = annee;
	}

	// Creation getter / setter

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	// Methode polymorphe

	@Override
	public String description() {
		return descriptif;
	}

	// Creation de la methode toString

	@Override
	public String toString() {
		return super.toString() + "\nMois de publication: " + mois + "\nAnnee de publication: " + annee
				+ "\n______________________________________________________________________";

	}
}
