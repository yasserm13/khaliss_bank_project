package divers;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


import khaliss_bank_project.*;

public class Menu implements InterfaceKB{
	private BufferedReader br;
	private Socket socket;
	
	public Menu() { //constructeur par defaut
        this.br = new BufferedReader (new InputStreamReader (System.in));
    }
	
	public int lireEntreeInt(int min, int max) {
	       int choix;
	       while (true) {
	           try {
	               choix = Integer.parseInt(br.readLine()); 
	               if (choix >= min && choix <= max) {
	                    break;
	               }
	           } catch (Exception e) {
	        	   System.out.println("Mauvaise valeur, veuillez saisir un entier !"); 
	       }
	   }
	    return choix;
	}
	
	private int menu_01() {
		int choix;
		System.out.println("");
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("│             WELCOME TO KHALISS BANK             │");
		System.out.println("├─────────────────────────────────────────────────┤");
		System.out.println("│                                                 │");
		System.out.println("│  1: Fonction 1                                  │");
		System.out.println("│  2: Fonction 2                                  │");
		System.out.println("│  3: Fonction 3                                  │");
		System.out.println("│  0: Quitter                                     │");
		System.out.println("│                                                 │");
		System.out.println("│*****************KHALISS BANK********************│");
		System.out.println("│                                       [Banquier]│");
		System.out.println("└─────────────────────────────────────────────────┘");
		System.out.print("Votre choix : ");
		choix = lireEntreeInt(0, 3);
		return choix;
	}
	
	private int menu_02() {
		int choix;
		System.out.println("");
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("│             WELCOME TO KHALISS BANK             │");
		System.out.println("├─────────────────────────────────────────────────┤");
		System.out.println("│                                                 │");
		System.out.println("│  1: Fonction 1                                  │");
		System.out.println("│  2: Fonction 2                                  │");
		System.out.println("│  3: Fonction 3                                  │");
		System.out.println("│  0: Quitter                                     │");
		System.out.println("│                                                 │");
		System.out.println("│*****************KHALISS BANK********************│");
		System.out.println("│                                         [Client]│");
		System.out.println("└─────────────────────────────────────────────────┘");
		System.out.print("Votre choix : ");
		choix = lireEntreeInt(0, 3);
		return choix;
	}
	
	private void menu_03() {
		int choix;
		while (true) {
			System.out.println("");
			System.out.println("┌─────────────────────────────────────────────────┐");
			System.out.println("│                 FONCTION 3                      │");
			System.out.println("├─────────────────────────────────────────────────┤");
			System.out.println("│  1: Fonction 1                                  │");
			System.out.println("│  2: Fonction 2                                  │");
			System.out.println("│                                                 │");
			System.out.println("│*****************KHALISS BANK********************│");
			System.out.println("│ [0]: Menu principal                             │");
			System.out.println("└─────────────────────────────────────────────────┘");
			System.out.print("Votre choix : ");
			choix = lireEntreeInt(0, 2);
			switch (choix) {
            case 0:
            	demarrerB();
                break;
            case 1:
            	System.out.println("Fonction 1");
                break;
            case 2: 
            	System.out.println("Fonction 2");
                break;
            default:
            	 System.out.println("Mauvais choix, recommencez !"); // Action par dÃ©faut en cas de mauvais choix
			}
		}
	}
	
	public void demarrerB() {
        while (true) {
            int choix = menu_01();
            switch (choix) {
                case 0:
                	System.out.println("");
                	System.out.println("Vous avez choisi de quitter le programme !");
                	System.out.println("Le programme est termine.");
                    System.exit(0);
                    break;
                case 1:
                	System.out.println("Fonction 1");
                    break;
                case 2: 
                	System.out.println("Fonction 2");
                    break;
                case 3:
                	menu_03();
                    break;
                default:
                	System.out.println("Mauvais choix, recommencez !"); // Action par dÃ©faut en cas de mauvais choix
            }
        }
    }
	
	public void demarrerC() {
        while (true) {
            int choix = menu_02();
            switch (choix) {
                case 0:
                	System.out.println("");
                	System.out.println("Vous avez choisi de quitter le programme !");
                	System.out.println("Le programme est termine.");
                    System.exit(0);
                    break;
                case 1:
                	System.out.println("Fonction 1");
                    break;
                case 2: 
                	System.out.println("Fonction 2");
                    break;
                case 3:
                	System.out.println("Fonction 3");
                    break;
                default:
                	System.out.println("Mauvais choix, recommencez !"); // Action par dÃ©faut en cas de mauvais choix
            }
        }
    }
	
	public Client creerClient(String p_mail)
	{
		Client newClient = new Client();
				
		newClient.setM_mail(p_mail);
		
		System.out.println("Veuillez saisir votre nom: ");
		newClient.setM_nom(LectureClavier.saisirPhrase());
		System.out.println("");
		
		System.out.println("Veuillez saisir votre prenom: ");
		newClient.setM_prenom(LectureClavier.saisirPhrase());
		System.out.println("");
		
		System.out.println("Veuillez saisir la ville dans laquelle vous êtes domicilié: ");
		newClient.setM_addDomicile(LectureClavier.saisirPhrase());
		System.out.println("");
		
		//mot de passe
		
		System.out.println("Veuillez saisir votre mot de passe: ");
		try {
				newClient.setM_motDePasse(CryptageMdpMD5.avoirMdpCrypte(LectureClavier.saisirPhrase()));	
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} 
		
		
		System.out.println("Veuillez selectioner un conseiller bancaire: ");
		newClient.setM_nomConseiller(selectBanquier());
		System.out.println("");
		
		newClient.openCompte(p_mail);
		LoadSaveFile.setListToFile(newClient);
		
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("│             WELCOME TO KHALISS BANK             │");
		System.out.println("├─────────────────────────────────────────────────┤");
		System.out.println("│    __$__                                        │");
		System.out.println("│     ***Let Us Make Your Money Great Again***    │");
		System.out.println("│                                                 │");
		System.out.println("└─────────────────────────────────────────────────┘");
		
		return newClient;
	}
	
	
	
	
	public String selectBanquier()
	
	{	
				String nomBanquier = new String("");
				char choix;
				
				do {
			    	System.out.println("A- Yasser MOUSSA\n" + 
			    			"B- Mamadou MAREGA\n" + 
			    			"C- El-Arif AHAMADA\n" );
			    	choix = LectureClavier.saisirCaractere();
		    	}while(choix != 'A' && choix != 'B' && choix != 'C');
		    	
		    	switch (choix){
			    	case 'A':
			    		System.out.println("\nVous avez choisi comme banquier: M.Yasser MOUSSA\nIl sera trés heureux de travailler avec vous.");
			    		nomBanquier = "MOUSSA";
			    		break;
			    	case 'B':
			    		System.out.println("\nVous avez choisi comme banquier: M.Mamadou MAREGA\nIl sera trés heureux de travailler avec vous.");
			    		nomBanquier = "MAREGA";
			    		break;
			    	case 'C':
			    		System.out.println("\nVous avez choisi comme banquier: El-Arif AHAMADA\nIl sera trés heureux de travailler avec vous.");
			    		nomBanquier = "AHAMADA";
			    		break;
			    	default:
			    		System.out.println("Choix_non_existant");
			    		break;
				}
				
	return nomBanquier;

	}
}