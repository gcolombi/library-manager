//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 5*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//

public class Dictionnaire extends Document {

	// Creation d'un enum de langue

	enum Langue {
		Francais, Anglais, Espagnol, Latin, Allemand
	}

	// Creation des variables

	private Langue language;
	private String descriptif = "<< Ce document est de type dictionnaire, une dictionnaire est un ouvrage de reference contenant l'ensemble des mots d'une langue. >>";

	// Creation du constructeur d'un dictionnaire

	public Dictionnaire(String id, String titre, int nbreExemplaire, Langue language) {
		super(id, titre, nbreExemplaire);
		this.language = language;
	}

	// Creation getter/setter

	// a corriger avec un bon nom
	public Langue getMatiere() {
		return language;
	}

	public void setMatiere(Langue language) {
		this.language = language;
	}

	// Methode Polymorphe

	@Override
	public String description() {
		return descriptif;
	}

	// Creation methode toString

	public String toString() {
		return super.toString() + "\nLangue: " + language
				+ "\n______________________________________________________________________";

	}
}