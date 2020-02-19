public class Livre extends Document {

	// Creation des variables d'un livre

	private String auteur;
	private int nbrePages;

	// Creation du constructeur d'un livre

	public Livre(String id, String titre, int nbreExemplaire, String auteur, int nbrePages) {
		super(id, titre, nbreExemplaire);
		this.auteur = auteur;
		this.nbrePages = nbrePages;
	}

	// Creation getter/setter

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getNbrePages() {
		return nbrePages;
	}

	public void setNbrePages(int nbrePages) {
		this.nbrePages = nbrePages;
	}

	// Methode polymorphe retourne null car on ne cree pas de 'livres' en soit, soit
	// un roman ou un manuel.

	@Override
	public String description() {
		return null;

	}

	// Creation methode toString

	@Override
	public String toString() {
		return super.toString() + "\nNom de l'auteur(e): " + auteur + "\nNombre de pages: " + nbrePages;

	}
}
