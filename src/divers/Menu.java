package divers;
import java.io.*;
import java.util.ArrayList;


import khaliss_bank_project.*;


public class Menu implements InterfaceKB{
	private BufferedReader br;
	
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
	        	   e.printStackTrace();
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
			choix = lireEntreeInt(0, 2);
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
			System.out.println("│                  ┌────────────────────────────┐ │");
			System.out.println("│ Adresse mail [1] │                            │ │");
			System.out.println("│                  └────────────────────────────┘ │");
			System.out.println("│                  ┌────────────────────────────┐ │");
			System.out.println("│ Mot de Passe [2] │                            │ │");
			System.out.println("│                  └────────────────────────────┘ │");
			System.out.println("│                                                 │");
			System.out.println("│*****************KHALISS BANK********************│");
			System.out.println("│                                                 │");
			System.out.println("│ [0]: Menu principal                             │");
			System.out.println("└─────────────────────────────────────────────────┘");
			choix = lireEntreeInt(0, 2);
			switch (choix) {
	        case 0:
	        	demarrer();
	            break;
	        case 1:
            	System.out.print("Saisir votre @ mail: ");
                break;
            case 2: 
            	System.out.print("Saisir mot de passe: ");
                break;
	        default:
	        	 System.out.println("Mauvais choix, recommencez !"); // Action par défaut en cas de mauvais choix
			}
		}
	}
	
	
	public Client creerClient(String p_mail)
	{
		Client newClient = new Client();
		
		newClient.setM_mail(p_mail);
		
		// mot de passe
		//newClient.setM_motDePasse("rantsi");
		
		System.out.println("Veuillez saisir votre nom: ");
		newClient.setM_nom(LectureClavier.saisirPhrase());
		System.out.println("");
		
		System.out.println("Veuillez saisir votre prenom: ");
		newClient.setM_prenom(LectureClavier.saisirPhrase());
		System.out.println("");
		
		System.out.println("Veuillez saisir la ville dans laquelle vous êtes domicilié: ");
		newClient.setM_addDomicile(LectureClavier.saisirPhrase());
		System.out.println("");
		
		System.out.println("Veuillez selectioner un conseiller bancaire: ");
		newClient.setM_nomConseiller(selectBanquier());
		System.out.println("");
		
		LoadSaveFile.setListToFile(newClient);
		
		
		
		
		
		return newClient;
	}
	
	
	
	
	public String selectBanquier()
	
	{	
		
		String nomBanquier = new String(""); 
		ArrayList<Client> list = new ArrayList<>();
		ArrayList<String> listBanquiers = new ArrayList<>();
		String khalissMail = new String("@khaliss-bank.fr");
		
		
		list = Banquier.LClientBanquier();

		for(int i=0; i<list.get(0).getNbValues(); ++i ) 
		{
			
				if (list.get(2).getValue(i).endsWith(khalissMail))
				{
					listBanquiers.add(list.get(0).getValue(i));
				}
		}
				
		
		int ok = 0;
		
		do
		{
			
			for(int i=0; i<listBanquiers.size(); ++i)
			{
			System.out.println(i+1 + ": "+listBanquiers.get(i));
			}
		
			int choix = LectureClavier.saisirInt();
		
			if(choix > listBanquiers.size())
			{
				System.out.println("votre saisie ne correspond à aucune des propositions. \n Veuillez Réesayer!!");
			}
			else
			{
				ok = 1;
				
				System.out.println("Vous avez choisi comme banquier: " + listBanquiers.get(choix-1) + "\nIl sera trés heureux de travailler avec vous.");
				
				nomBanquier = listBanquiers.get(choix-1) ;
			}
			
		}while(ok != 1 );	
		
		

	
	return nomBanquier;

	}
}
