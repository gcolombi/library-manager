import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ListeDocuments {

	// Creation du scanner et du arraylist pour les documents

	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Document> library = new ArrayList<Document>();
	private static Roman.Prixlitt[] liste2 = { Roman.Prixlitt.Nebula, Roman.Prixlitt.Costa }; // *** SERT POUR LES DOCUMENTS PREDEFINI SEULEMENT *** NOTE POUR LOUIS (DERNIERE METHODE)

	// Creation getter / setter arraylist

	public static ArrayList<Document> getLibrary() {
		return library;
	}

	public void setLibrary(ArrayList<Document> library) {
		ListeDocuments.library = library;
	}

	// Creation de la methode pour generer un identifiant de 10 caracteres(lettres
	// et chiffres melanges)

	public static String generateId() {

		final String id = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		while (true) {
			for (int i = 0; i < 10; i++) {
				builder.append(id.charAt(random.nextInt(id.length())));
			}
			if (checkId(builder.toString())) {
				return builder.toString();
			}
		}
	}

	// Creation methode pour verifier si le id est deja attribue a un document

	public static boolean checkId(String checkValue) {

		boolean test = true;

		for (int i = 0; i < library.size(); i++) {

			if (library.get(i).getId().equals(checkValue)) {
				return false;
			}

		}
		return test;
	}

	// Creation de la methode pour ajouter une revue

	public static void addRevue() {

		System.out.println("======================================================================");
		System.out.println("=                  Creation et ajout d'une Revue.                    =");
		System.out.println("======================================================================");
		try {
			scan.nextLine();
			String uniqueId = generateId();
			System.out.println("Voici le numero d'enregistrement: " + uniqueId);
			System.out.println("Entrez le titre: ");
			String title = scan.nextLine();
			System.out.println("Entrez le nombre de copies: ");
			int copie = scan.nextInt();
			scan.nextLine();
			System.out.println("Entrez le mois de publication: ");
			String month = scan.nextLine();
			System.out.println("Entrez l'annee de publication:");
			int year = scan.nextInt();

			Revue revue = new Revue(uniqueId, title, copie, month, year);
			library.add(revue);
			System.out.println("Revue ajoute.");
			scan.nextLine();

		} catch (InputMismatchException e) {
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
			scan.nextLine();
		}
	}

	// Creation de la methode pour choix de langue d'un dictionnaire

	public static Dictionnaire.Langue choixLangue() {

		int choix = 0;
		Dictionnaire.Langue choixLangue = null;

		while (choix < 1 || choix > 5) {
			System.out.println("Choisissez la langue du dictionnaire: ");
			System.out.println("1: Francais.");
			System.out.println("2: Anglais.");
			System.out.println("3: Espagnol.");
			System.out.println("4: Latin.");
			System.out.println("5: Allemand.");
			choix = scan.nextInt();

			switch (choix) {
			case 1:
				System.out.println("La langue du dictionnaire est le " + Dictionnaire.Langue.Francais);
				choixLangue = Dictionnaire.Langue.Francais;
				break;
			case 2:
				System.out.println("La langue du dictionnaire est l'" + Dictionnaire.Langue.Anglais);
				choixLangue = Dictionnaire.Langue.Anglais;
				break;
			case 3:
				System.out.println("La langue du dictionnaire est l'" + Dictionnaire.Langue.Espagnol);
				choixLangue = Dictionnaire.Langue.Espagnol;
				break;
			case 4:
				System.out.println("La langue du dictionnaire est le " + Dictionnaire.Langue.Latin);
				choixLangue = Dictionnaire.Langue.Latin;
				break;
			case 5:
				System.out.println("La langue du dictionnaire est l'" + Dictionnaire.Langue.Allemand);
				choixLangue = Dictionnaire.Langue.Allemand;
				break;
			default:
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				break;
			}
		}
		return choixLangue;
	}

	// Creation de la methode pour ajouter un dictionnaire

	public static void addDictionnaire() {

		System.out.println("======================================================================");
		System.out.println("=               Creation et ajout d'un Dictionnaire.                 =");
		System.out.println("======================================================================");
		try {
			scan.nextLine();
			String uniqueId = generateId();
			System.out.println("Voici le numero d'enregistrement: " + uniqueId);
			System.out.println("Entrez le titre: ");
			String title = scan.nextLine();
			System.out.println("Entrez le nombre de copies: ");
			int copie = scan.nextInt();
			scan.nextLine();
			Dictionnaire.Langue choix = choixLangue();

			Dictionnaire dictionnaire = new Dictionnaire(uniqueId, title, copie, choix);
			library.add(dictionnaire);
			System.out.println("Dictionnaire ajoute.");
			scan.nextLine();

		} catch (InputMismatchException e) {
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
			scan.nextLine();
		}

	}

	// Creation de la methode pour choix de la matiere d'un manuel

	public static Manuel.Discipline choixMatiere() {

		int choix = 0;
		Manuel.Discipline choixMatiere = null;

		while (choix < 1 || choix > 6) {
			System.out.println("Choisissez la matiere du manuel: ");
			System.out.println("1: Informatique.");
			System.out.println("2: Chimie.");
			System.out.println("3: Physique.");
			System.out.println("4: Mathematiques.");
			System.out.println("5: Sante.");
			System.out.println("6: Education.");
			choix = scan.nextInt();

			switch (choix) {
			case 1:
				System.out.println("La matiere du manuel est l'" + Manuel.Discipline.Informatique);
				choixMatiere = Manuel.Discipline.Informatique;
				break;
			case 2:
				System.out.println("La matiere du manuel est la " + Manuel.Discipline.Chimie);
				choixMatiere = Manuel.Discipline.Chimie;
				break;
			case 3:
				System.out.println("La matiere du manuel est la " + Manuel.Discipline.Physique);
				choixMatiere = Manuel.Discipline.Physique;
				break;
			case 4:
				System.out.println("La matiere du manuel est sur les " + Manuel.Discipline.Mathematiques);
				choixMatiere = Manuel.Discipline.Mathematiques;
				break;
			case 5:
				System.out.println("La matiere du manuel est la " + Manuel.Discipline.Sante);
				choixMatiere = Manuel.Discipline.Sante;
				break;
			case 6:
				System.out.println("La matiere du manuel est l'" + Manuel.Discipline.Education);
				choixMatiere = Manuel.Discipline.Education;
				break;
			default:
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				break;
			}
		}
		return choixMatiere;
	}

	// Creation de la methode pour ajouter un manuel

	public static void addManuel() {

		System.out.println("======================================================================");
		System.out.println("=                 Creation et ajout d'un Manuel.                     =");
		System.out.println("======================================================================");
		try {
			scan.nextLine();
			String uniqueId = generateId();
			System.out.println("Voici le numero d'enregistrement: " + uniqueId);
			System.out.println("Entrez le titre: ");
			String title = scan.nextLine();
			System.out.println("Entrez le nombre de copies: ");
			int copie = scan.nextInt();
			scan.nextLine();
			System.out.println("Entrez le nom de l'auteur: ");
			String authorsName = scan.nextLine();
			System.out.println("Entrez le nombre de pages:");
			int pageCount = scan.nextInt();
			scan.nextLine();
			Manuel.Discipline choix = choixMatiere();

			Manuel manuel = new Manuel(uniqueId, title, copie, authorsName, pageCount, choix);
			library.add(manuel);
			System.out.println("Manuel ajoute.");
			scan.nextLine();

		} catch (InputMismatchException e) {
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
			scan.nextLine();
		}
	}

	// Creation de la methode pour ajouter un roman

	public static void addRoman() {

		Roman.Prixlitt[] liste = new Roman.Prixlitt[8];

		System.out.println("======================================================================");
		System.out.println("=                  Creation et ajout d'un Roman.                     =");
		System.out.println("======================================================================");
		try {
			scan.nextLine();
			String uniqueId = generateId();
			System.out.println("Voici le numero d'enregistrement: " + uniqueId);
			System.out.println("Entrez le titre: ");
			String title = scan.nextLine();
			System.out.println("Entrez le nombre de copies: ");
			int copie = scan.nextInt();
			scan.nextLine();
			System.out.println("Entrez le nom de l'auteur: ");
			String authorsName = scan.nextLine();
			System.out.println("Entrez le nombre de pages:");
			int pageCount = scan.nextInt();
			scan.nextLine();
			choixPrixLitteraire(liste);

			Roman roman = new Roman(uniqueId, title, copie, authorsName, pageCount, removeNull(liste));
			library.add(roman);
			System.out.println("Roman ajoute.");
			scan.nextLine();

		} catch (InputMismatchException e) {
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
			scan.nextLine();
		}

	}

	// Creation de la methode pour retirer les valeurs null de la liste de prix
	// literaire(s)

	public static Roman.Prixlitt[] removeNull(Roman.Prixlitt[] liste) {

		ArrayList<Roman.Prixlitt> list = new ArrayList<Roman.Prixlitt>();
		for (Roman.Prixlitt g : liste)
			if (g != null)
				list.add(g);
		return list.toArray(new Roman.Prixlitt[0]);
	}

	// Creation de la methode pour choix du ou des prix litteraires d'un roman

	public static Roman.Prixlitt[] choixPrixLitteraire(Roman.Prixlitt[] liste) {

		int choix;
		boolean stop = false;
		String reponse;

		while (!stop) {
			System.out.println("Choisissez le ou les prix litteraire(s) du roman: ");
			System.out.println("1: Prix Goncourt.");
			System.out.println("2: Prix Renaudot.");
			System.out.println("3: Prix Femina.");
			System.out.println("4: Prix Senghor.");
			System.out.println("5: Prix Nebula.");
			System.out.println("6: Prix Booker.");
			System.out.println("7: Prix Medicis.");
			System.out.println("8: Prix Costa.");
			choix = scan.nextInt();

			switch (choix) {
			case 1:
				Array.set(liste, choix - 1, Roman.Prixlitt.Goncourt);
				break;
			case 2:
				Array.set(liste, choix - 1, Roman.Prixlitt.Renaudot);
				break;
			case 3:
				Array.set(liste, choix - 1, Roman.Prixlitt.Femina);
				break;
			case 4:
				Array.set(liste, choix - 1, Roman.Prixlitt.Senghor);
				break;
			case 5:
				Array.set(liste, choix - 1, Roman.Prixlitt.Nebula);
				break;
			case 6:
				Array.set(liste, choix - 1, Roman.Prixlitt.Booker);
				break;
			case 7:
				Array.set(liste, choix - 1, Roman.Prixlitt.Medicis);
				break;
			case 8:
				Array.set(liste, choix - 1, Roman.Prixlitt.Costa);
				break;
			default:
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				break;

			}
			System.out.println("Avez-vous termine de saisir le ou les prix litteraire(s) ? Oui ou Non.)");
			reponse = scan.next();
			while (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
				System.out.println("Entrez Oui ou Non:");
				reponse = scan.next();
			}
			if (reponse.equalsIgnoreCase("oui")) {
				stop = true;
			}
		}
		return liste;
	}

	// Creation de la methode pour ajouter un document en choissant le type

	public static void ajouterDocument() {

		boolean stop = false;

		int choix;

		while (!stop) {
			System.out.println("_______________________________________________________________________");
			System.out.println("==========================Ajout de Documents===========================");
			System.out.println("____________________Choisissez le type de documents ___________________");
			System.out.println("1: Revue.");
			System.out.println("2: Dictionnaire.");
			System.out.println("3: Manuel.");
			System.out.println("4: Roman.");
			System.out.println("0: Retour au menu principal.");
			choix = scan.nextInt();

			switch (choix) {
			case 1:
				System.out.println("Ajout d'une Revue.");
				addRevue();
				break;
			case 2:
				System.out.println("Ajout d'un Dictionnaire.");
				addDictionnaire();
				break;
			case 3:
				System.out.println("Ajout d'un Manuel.");
				addManuel();
				break;
			case 4:
				System.out.println("Ajout d'un Roman.");
				addRoman();
				break;
			case 0:
				stop = true;
				scan.nextLine();
				break;
			default:
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				ajouterDocument();
				break;

			}
		}
	}

	// Creation de la methode pour supprimer document

	public static void supprimerDocument() {

		int choix;
		boolean exit = false;
		String reponse;

		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}
		afficherListe();
		try {
			System.out.println();
			System.out.println("Choisir un document a supprimer de la liste: ");
			choix = scan.nextInt();

			if (choix >= 1 && choix <= library.size()) {

				do {
					System.out.println("Etes-vous sur de vouloir supprimer le document de la liste ? (Oui/Non)");
					reponse = scan.next();
					while (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
						System.out.println("Entrez oui ou non");
						reponse = scan.next();
					}
					if (reponse.equalsIgnoreCase("oui")) {
						exit = true;
						library.remove(choix - 1);
						System.out.println("======================================================================");
						System.out.println("Le document choisi a bien ete supprime de la liste.");
					} else
						System.out.println("Le document n'a pas ete supprime.");
					break;

				} while (!exit);
				scan.nextLine();
			} else {
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				supprimerDocument();
			}
		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour afficher la liste de tout les documents avec le
	// titre et le id

	public static void afficherListe() {

		int index = 1;

		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}

		for (Document d : library) {

			System.out.println((index++) + ": " + d.getTitre() + " " + d.getId());
		}
	}

	// Creation de la methode pour afficher les caracteristiques d'un document

	public static void afficherDocument() {

		boolean documentId = false;

		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}

		System.out.println("Entrez le numero d'enregistrement a 10 caracteres du document: ");
		String id = scan.next();

		for (int i = 0; i < library.size(); i++) {
			if (id.equalsIgnoreCase(library.get(i).getId())) {
				System.out.println("Toutes les caracteristiques du document sont: " + "\n" + library.get(i) + "\n"
						+ library.get(i).description());
				documentId = true;
				scan.nextLine();
			}
		}
		if (!documentId)
			System.out.println("Le document n'existe pas, veuillez ressayer.");
		System.out.println("**********************************************************************");
	}

	// Creation de la methode pour modifier prix litteraire d'un roman

	public static void affichagePrixLitt() {

		String choix;
		int index = 1;
		boolean prixLittAff = false;
		boolean checkRoman = false;

		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}

		for (Document d : library) {

			if (d instanceof Roman) {
				System.out.println(
						(index++) + ": " + "Titre: " + d.getTitre() + " | " + "Auteur: " + ((Roman) d).getAuteur());
				checkRoman = true;
			}
		}
		if (!checkRoman) {
			System.out.println("La liste ne comprend pas de document de type roman.");
			return;
		}
		System.out.println();
		System.out.println("Veuillez choisir un roman par son titre:");

		choix = scan.nextLine();

		for (int i = 0; i < library.size(); i++) {

			if (choix.equalsIgnoreCase(library.get(i).getTitre()) && library.get(i) instanceof Roman) {
				prixLittAff = true;
				System.out.println("Voici le ou les prix litteraire(s) du roman choisi: "
						+ Arrays.toString(((Roman) library.get(i)).getListe()));
				System.out.println();
			}
		}

		if (!prixLittAff) {
			System.out.println("Entree invalide, veuillez reessayer.");
			System.out.println("**********************************************************************");
			affichagePrixLitt();
		}
	}

	// Creation de la methode pour augmenter le nombre d'exemplaire d'un document

	public static void augmenterNbreCopies() {

		int index = 1;
		int choix;
		int nbre;
		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}
		for (Document d : library) {

			System.out.println((index++) + ": " + d.getId());
		}
		try {
			System.out.println();
			System.out.println("Veuillez choisir un document par son numero:");
			choix = scan.nextInt();
			scan.nextLine();
			if (choix >= 1 && choix <= library.size()) {

				System.out.println("Voici le nombre d'exemplaire actuel du document choisi: "
						+ library.get(choix - 1).getNbreExemplaire());
				System.out.println();
				System.out.println("Combien d'exemplaire voulez-vous ajouter a ce document?");
				nbre = scan.nextInt();
				Document document = library.get(choix - 1);
				document.ajoutNbreExemplaire(nbre);
				System.out.println(
						"Vous avez ajoute " + nbre + " exemplaire(s) au document " + library.get(choix - 1).getId());
				scan.nextLine();
			} else {
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				augmenterNbreCopies();
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour diminuer le nombre d'exemplaire d'un document

	public static void diminuerNbreCopies() {

		int index = 1;
		int choix;
		int nbre;
		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}
		for (Document d : library) {

			System.out.println((index++) + ": " + d.getId());
		}
		try {
			System.out.println();
			System.out.println("Veuillez choisir un document par son numero: ");
			choix = scan.nextInt();
			scan.nextLine();
			if (choix >= 1 && choix <= library.size()) {

				System.out.println("Voici le nombre d'exemplaire actuel du document choisi: "
						+ library.get(choix - 1).getNbreExemplaire());
				System.out.println();
				System.out.println("Combien d'exemplaire voulez-vous retirer a ce document?");
				nbre = scan.nextInt();
				Document document = library.get(choix - 1);
				document.reduireNbreExemplaire(nbre);
				System.out.println(
						"Vous avez retire " + nbre + " exemplaire(s) au document. " + library.get(choix - 1).getId());
				scan.nextLine();
			} else {
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				diminuerNbreCopies();
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour modifier le titre d'un document

	public static void modifTitreDocument() {

		int choix;
		String newTitre;
		String reponse;
		boolean exit = false;

		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}
		afficherListe();

		try {
			System.out.println();
			System.out.println("Veuillez choisir un document par son numero:");
			choix = scan.nextInt();
			scan.nextLine();
			if (choix >= 1 && choix <= library.size()) {

				System.out.println("Voici le titre du document choisi: " + library.get(choix - 1).getTitre());
				System.out.println();
				System.out.println("Quel est le nouveau titre pour le document choisi?");
				newTitre = scan.nextLine();
				System.out.println();
				do {
					System.out.println("Etes-vous sur de vouloir modifier le titre du document ? (Oui/Non)");
					reponse = scan.next();
					while (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
						System.out.println("Entrez oui ou non.");
						reponse = scan.next();
					}
					if (reponse.equalsIgnoreCase("oui")) {
						exit = true;
						library.get(choix - 1).setTitre(newTitre);
						System.out.println("Le titre du document a bien ete modifie");

					} else
						System.out.println("Le titre du document n'a pas ete modifie.");
					break;

				} while (!exit);
				scan.nextLine();

			} else {
				System.out.println("Entree invalide, veuillez reessayer.");
				System.out.println("**********************************************************************");
				modifTitreDocument();
			}

		} catch (InputMismatchException e) {
			scan.next();
			System.out.println("**********************************************************************");
			System.out.println("Entree invalide.");
		}
	}

	// Creation de la methode pour modifier l'auteur d'un livre

	public static void modifAuteurLivre() {

		int index = 1;
		String choix;
		String newAuteur;
		String reponse;
		boolean exit = false;
		boolean checkLivre = false;
		boolean checkAuteur = false;

		if (library.isEmpty()) {
			System.out.println("La liste est vide.");
			return;
		}

		for (Document d : library) {

			if (d instanceof Livre) {
				System.out.println(
						(index++) + ": " + "Titre: " + d.getTitre() + " | " + "Auteur: " + ((Livre) d).getAuteur());
				checkLivre = true;
			}
		}
		if (!checkLivre) {
			System.out.println("La liste ne comprend pas de livre.");
			return;
		}
		System.out.println();
		System.out.println("Veuillez choisir un livre par son titre:");
		choix = scan.nextLine();

		for (int i = 0; i < library.size(); i++) {
			if (choix.equalsIgnoreCase(library.get(i).getTitre()) && library.get(i) instanceof Livre) {
				checkAuteur = true;

				System.out.println("Voici l'auteur du livre choisi: " + ((Livre) library.get(i)).getAuteur());
				System.out.println();
				System.out.println("Quel est le nouveau prenom et nom de l'auteur ?");
				newAuteur = scan.nextLine();
				System.out.println();
				do {
					System.out.println("Etes-vous sur de vouloir modifier l'auteur du livre ? (Oui/Non)");
					reponse = scan.next();
					while (!reponse.equalsIgnoreCase("oui") && !reponse.equalsIgnoreCase("non")) {
						System.out.println("Entrez oui ou non.");
						reponse = scan.next();
					}
					if (reponse.equalsIgnoreCase("oui")) {
						exit = true;
						((Livre) library.get(i)).setAuteur(newAuteur);
						System.out.println(
								"L'auteur du livre : " + library.get(i).getTitre() + " " + "a bien ete modifie.");

					} else
						System.out.println("L'auteur du livre n'a pas ete modifie.");

					break;

				} while (!exit);
				scan.nextLine();
			}
		}
		if (!checkAuteur) {
			System.out.println("Entree invalide, veuillez reessayer.");
			System.out.println("**********************************************************************");
			modifAuteurLivre();
		}

	}

	// Creation de la methode pour ajouter 8 documents predefenis (deux de chaque
	// type)

	public static void addDocPredef() {

		Roman roman1 = new Roman("LIBRARY001", "Permanent record", 5, "Edward Snowden", 352, liste2);
		library.add(roman1);
		Roman roman2 = new Roman("LIBRARY002", "Java software solutions", 7, "John Lewis", 800, liste2);
		library.add(roman2);
		Manuel manuel1 = new Manuel("LIBRARY003", "Computer science", 21, "Mourad Badri", 525, Manuel.Discipline.Informatique);
		library.add(manuel1);
		Manuel manuel2 = new Manuel("LIBRARY004", "Sciencia", 21, "Matt Tweed", 416, Manuel.Discipline.Physique);
		library.add(manuel2);
		Revue revue1 = new Revue("LIBRARY005", "How to be a better programmer", 9, "November", 2018);
		library.add(revue1);
		Revue revue2 = new Revue("LIBRARY006", "Learning Python", 11, "December", 2017);
		library.add(revue2);
		Dictionnaire dictionnaire1 = new Dictionnaire("LIBRARY007", "Larousse", 2, Dictionnaire.Langue.Francais);
		library.add(dictionnaire1);
		Dictionnaire dictionnaire2 = new Dictionnaire("LIBRARY008", "Larousse", 2, Dictionnaire.Langue.Anglais);
		library.add(dictionnaire2);

		System.out.println("Vous avez ajoute 8 documents de type Roman, Manuel, Revue et Dictionnaire (deux de chaque type).");
	}
}
