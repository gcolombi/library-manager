
//-------------------------------------------------------------------------------------------------------------------------//
//************************************************Devoir 5*****************************************************************//
//												  Auteurs															       //
//			par:  Kim Hardy (HARK12118400)      Gerard Colombi (COLG16058800)       Karyn Gagne (GAGK04549408)             //
//-------------------------------------------------------------------------------------------------------------------------//
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean arret = false;
		int choix = 0;
		int counter = 0;

		while (!arret) {
			try {
				System.out.println("==================== GESTION DE LA BIBLIOTHEQUE ======================");
				System.out.println("                                                                      ");
				System.out.println("                  __...--~~~~~-._   _.-~~~~~--...__                   ");
				System.out.println("                //               `V'               \\\\               ");
				System.out.println("               //                 |                 \\\\              ");
				System.out.println("              //__...--~~~~~~-._  |  _.-~~~~~~--...__\\\\             ");
				System.out.println("             //__....----~~~~._\\\\ | //_.~~~~----....._\\\\          ");
				System.out.println("             ===================\\\\|//====================           ");
				System.out.println("                                `---`                                 ");
				System.out.println("                                                                      ");
				System.out.println("-------------------------- Menu Principal ----------------------------");
				System.out.println("------------ Choisissez parmis une des options suivantes -------------");
				System.out.println("1- Ajout et suppression de romans, manuels, revues et dictionnaires");
				System.out.println("2- Afficher la liste de tous les documents");
				System.out.println("3- Afficher les differentes caracteristiques concernant un document");
				System.out.println("4- Afficher la liste de prix litteraires pour un roman");
				System.out.println("5- Augmentation ou diminution du nombre d'exemplaire du document");
				System.out.println("6- Modification du titre d'un document");
				System.out.println("7- Modification de l'auteur d'un livre");
				System.out.println("8- Creation et ajout de documents predefinis");
				System.out.println("0- Quitter");
				System.out.println("______________________________________________________________________");

				choix = scan.nextInt();

				// Creation switch-case pour le menu principale

				switch (choix) {

				case 1:
					System.out.println("Appuyez sur 1 pour ajouter ou 2 pour supprimer un document.");
					int choice = scan.nextInt();
					if (choice == 1) {
						ListeDocuments.ajouterDocument();
					} else if (choice == 2) {
						ListeDocuments.supprimerDocument();
					} else
						System.out.println("Entree invalide");
					System.out.println("----------------------------------------------------------------------");
					break;
				case 2:
					int index = 1;

					if (ListeDocuments.getLibrary().isEmpty()) {
						System.out.println("La liste est vide.");
						break;
					}

					for (Document d : ListeDocuments.getLibrary()) {

						System.out.println((index++) + ": " + d.getTitre() + " | " + d.getId());
					}
					System.out.println("----------------------------------------------------------------------");
					break;
				case 3:
					ListeDocuments.afficherDocument();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 4:
					ListeDocuments.affichagePrixLitt();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 5:
					System.out.println(
							"Appuyez sur 1 pour augmenter ou 2 pour reduire le nombre d'exemplaire d'un document.");
					int choice1 = scan.nextInt();
					if (choice1 == 1) {
						ListeDocuments.augmenterNbreCopies();
					} else if (choice1 == 2) {
						ListeDocuments.diminuerNbreCopies();
					} else
						System.out.println("Entree invalide");
					System.out.println("----------------------------------------------------------------------");
					break;
				case 6:
					ListeDocuments.modifTitreDocument();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 7:
					ListeDocuments.modifAuteurLivre();
					System.out.println("----------------------------------------------------------------------");
					break;
				case 8:
					if (counter == 0) {
						ListeDocuments.addDocPredef();
						counter++;
					} else {
						System.out.println("Vous avez deja ajouter les 8 documents predefinis.");
					}

					System.out.println("----------------------------------------------------------------------");
					break;
				case 0:
					arret = true;
					break;

				default:
					System.out.println("Entree invalide, veuillez reessayer.");
					System.out.println("----------------------------------------------------------------------");
					break;
				} // end du switch case
			} catch (InputMismatchException e) {
				scan.next();
				System.out.println("======================================================================");
				System.out.println("Entree invalide.");
				
			}
		} // end du while

	} // end de la Mainmethod

}