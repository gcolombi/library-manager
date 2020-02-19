public class Manuel extends Livre {

	// Creation enum discipline avec les differente matiere d'un manuel

	enum Discipline {
		Informatique, Chimie, Physique, Mathematiques, Sante, Education
	}

	// Creation des variables propre a un dictionnaire

	private Discipline matiere;
	private String descriptif = "<< Ce document est de type Manuel, un manuel est un ouvrage dictatique regroupant l'essentiel des connaissances relatives a un domaine donne. >>";

	// Creation du constructeur d'un Manuel

	public Manuel(String id, String titre, int nbreExemplaire, String auteur, int nbrePages, Discipline matiere) {
		super(id, titre, nbreExemplaire, auteur, nbrePages);

		this.matiere = matiere;
	}

	// Creation getter / setter

	public Discipline getMatiere() {
		return matiere;
	}

	public void setMatiere(Discipline matiere) {
		this.matiere = matiere;
	}

	// Methode polymorphe

	@Override
	public String description() {
		return descriptif;
	}

	// Creation de la methode toString

	@Override
	public String toString() {
		return super.toString() + "\nDomaine du Manuel: " + matiere
				+ "\n______________________________________________________________________";

	}

}
