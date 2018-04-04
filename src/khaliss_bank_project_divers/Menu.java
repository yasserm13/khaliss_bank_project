package khaliss_bank_project_divers;
import java.util.Scanner;
import java.io.*;

public class Menu{
	
	private Scanner scan;
	private BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	
	public Menu() { //constructeur par defaut
        this.scan = new Scanner(System.in);
    }

	private int menu_01() {
		int choix;
		System.out.println("");
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("│             WELCOME TO KHALISS BANK             │");
		System.out.println("├─────────────────────────────────────────────────┤");
		System.out.println("│  1: Login                                       │");
		System.out.println("│  2: Fonction 2                                  │");
		System.out.println("│  3: Fonction 3                                  │");
		System.out.println("│  0: Quitter                                     │");
		System.out.println("└─────────────────────────────────────────────────┘");
		System.out.print("Votre choix : ");
		choix = lireEntreeInt(0, 3);
		return choix;
	}
	
	public void demarrer() {
        while (true) {
            int choix = menu_01();
            switch (choix) {
                case 0:
                	System.out.println("");
                	System.out.println("Vous avez choisi de quitter le programme !");
                	System.out.println("Le programme est terminé.");
                    System.exit(0);
                    break;
                case 1:
                	login();
                    break;
                case 2: 
                	menu_02();
                    break;
                case 3:
                	System.out.println("Fonction 3");
                    break;
                default:
                	System.out.println("Mauvais choix, recommencez !"); // Action par défaut en cas de mauvais choix
            }
        }
    }
	
	private void menu_02() {
		int choix;
		while (true) {
			System.out.println("");
			System.out.println("┌─────────────────────────────────────────────────┐");
			System.out.println("│                 FONCTION 2                      │");
			System.out.println("├─────────────────────────────────────────────────┤");
			System.out.println("│  1: Fonction 1                                  │");
			System.out.println("│  2: Fonction 2                                  │");
			System.out.println("│  0: Menu principal                              │");
			System.out.println("└─────────────────────────────────────────────────┘");
			System.out.print("Votre choix : ");
			choix = lireEntreeInt (0, 2);
			switch (choix) {
            case 0:
            	demarrer();
                break;
            case 1:
            	System.out.println("Fonction 1");
                break;
            case 2: 
            	System.out.println("Fonction 2");
                break;
            default:
            	 System.out.println("Mauvais choix, recommencez !"); // Action par défaut en cas de mauvais choix
			}
		}
	}
	
	private void login() {
		int choix;
		while (true) {
			System.out.println("");
			System.out.println("┌─────────────────────────────────────────────────┐");
			System.out.println("│                     LOGIN                       │");
			System.out.println("├─────────────────────────────────────────────────┤");
			System.out.println("│                                                 │");
			System.out.println("│               ┌───────────────────────────────┐ │");
			System.out.println("│ Adresse mail :│                               │ │");
			System.out.println("│               └───────────────────────────────┘ │");
			System.out.println("│               ┌───────────────────────────────┐ │");
			System.out.println("│ Mot de Passe :│                               │ │");
			System.out.println("│               └───────────────────────────────┘ │");
			System.out.println("│                                                 │");
			System.out.println("│*****************KHALISS BANK********************│");
			System.out.println("│                                                 │");
			System.out.println("│ 0: Menu principal                               │");
			System.out.println("└─────────────────────────────────────────────────┘");
			choix = lireEntreeInt (0, 0);
			switch (choix) {
	        case 0:
	        	demarrer();
	            break;
	        default:
	        	 System.out.println("Mauvais choix, recommencez !"); // Action par défaut en cas de mauvais choix
			}
		}
	}
	
	private int lireEntreeInt(int min, int max) {
	       int choix;
	       while (true) {
	           try {
	               //choix = Integer.parseInt(scan.nextLine());
	               choix = Integer.parseInt(br.readLine()); 
	               if (choix >= min && choix <= max) {
	                    break;
	               }
	           } catch (Exception e) {
	        	   e.printStackTrace();
	        	   System.out.println("Mauvaise valeur, veuillez saisir un entier !"); 
	       }
	   }
	    return choix;
	}
	 /*
	private float lireEntreeFloat(int min, float max) {
		float montant;
	    	while (true) {
	            try {
	                montant = Float.parseFloat(scan.nextLine());
	                if (montant >= min && montant <= max) {
	                    break;
	                }
	            } catch (Exception e) {
	              	e.printStackTrace();
	                System.out.println("Mauvaise valeur, veuillez saisir un reel !");
	        }
	    }
	    return montant;
	}*/
}
