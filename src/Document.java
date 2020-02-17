//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 5*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//
abstract public class Document {

	// Creation des variables d'un document

	private String id;
	private String titre;
	private int nbreExemplaire;

	// Creation du constructeur

	public Document(String id, String titre, int nbreExemplaire) {

		this.id = id;
		this.titre = titre;
		this.nbreExemplaire = nbreExemplaire;

	}

	// Creation getter/setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbreExemplaire() {
		return nbreExemplaire;
	}

	public void setNbreExemplaire(int nbreExemplaire) {
		this.nbreExemplaire = nbreExemplaire;
	}

	// Creation mini methode pour augmenter le nombre de copies qui est appeler dans
	// le methode principale dans ListeDocuments

	public int ajoutNbreExemplaire(int nbreCopies) {
		this.nbreExemplaire = (this.nbreExemplaire + nbreCopies);
		return this.nbreExemplaire;
	}
	// Creation mini methode pour reduire le nombre de copies qui va etre appeler
	// dans le methode principale dans ListeDocuments

	public int reduireNbreExemplaire(int nbreCopies) {
		this.nbreExemplaire = (this.nbreExemplaire - nbreCopies);
		return this.nbreExemplaire;
	}

	// Creation methode generique pour le polymorphisme

	public abstract String description();

	// Creation methode toString

	@Override
	public String toString() {
		return "# d'identification: " + id + "\nTitre: " + titre + "\nNombre de copies en inventaire: "
				+ nbreExemplaire;

	}

}
