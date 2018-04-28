package divers;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import client_serveur.serveur.Authentification;
import khaliss_bank_project.*;

public class Menu implements InterfaceKB{
	private BufferedReader br;
	private Socket socket;
	public ArrayList<Client> m_listeLoginMdp;
	
	
	public String p_mail;
	
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
		System.out.println("│  1: Modifier mes informations personnelles      │");
		System.out.println("│  2: Afficher ma liste de clients                │");
		System.out.println("│  3: Ouvrir un nouveau compte client             │");
		System.out.println("│  4: Effectuer un virement d'un compte client    │");
		System.out.println("│  5: Supprimer un compte client                  │");
		System.out.println("│  0: Quitter                                     │");
		System.out.println("│                                                 │");
		System.out.println("│*****************KHALISS BANK********************│");
		System.out.println("│                                       [Banquier]│");
		System.out.println("└─────────────────────────────────────────────────┘");
		System.out.print("Votre choix : ");
		choix = lireEntreeInt(0, 5);
		return choix;
	}
	
	private int menu_02() {
		int choix;
		System.out.println("");
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("│             WELCOME TO KHALISS BANK             │");
		System.out.println("├─────────────────────────────────────────────────┤");
		System.out.println("│                                                 │");
		System.out.println("│  1: Modifier mes informations personnelles      │");
		System.out.println("│  2: Afficher mes comptes                        │");
		System.out.println("│  3: Effectuer un virement                       │");
		System.out.println("│  4: Ouvrir un nouveau compte bancaire           │");
		System.out.println("│  5: Supprimer un compte client                  │");
		System.out.println("│  0: Quitter                                     │");
		System.out.println("│                                                 │");
		System.out.println("│*****************KHALISS BANK********************│");
		System.out.println("│                                         [Client]│");
		System.out.println("└─────────────────────────────────────────────────┘");
		System.out.print("Votre choix : ");
		choix = lireEntreeInt(0, 5);
		return choix;
	}
	
	private int menu_03() {
		int choix;
		System.out.println("");
		System.out.println("┌─────────────────────────────────────────────────┐");
		System.out.println("│              WELCOME TO KHALISS BANK            │");
		System.out.println("├─────────────────────────────────────────────────┤");
		System.out.println("│  1: Login                                       │");
		System.out.println("│                                                 │");
		System.out.println("│*****************KHALISS BANK********************│");
		System.out.println("│ [0]: Quitter le programme                       │");
		System.out.println("└─────────────────────────────────────────────────┘");
		System.out.print("Votre choix : ");
		choix = lireEntreeInt(0, 1);
		return choix;
	}
	
	private void menu_04() {
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
	
	private void menu_05() {
		int choix;
		while (true) {
			System.out.println("");
			System.out.println("┌─────────────────────────────────────────────────┐");
			System.out.println("│              WELCOME TO KHALISS BANK            │");
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
	
	public void demarrer() {
        while (true) {
            int choix = menu_03();
            switch (choix) {
                case 0:
                	System.out.println("");
                	System.out.println("Vous avez choisi de quitter le programme !");
                	System.out.println("Le programme est termine.");
                    System.exit(0);
                    break;
                case 1:
                	//@mail
        			System.out.println("Entrez votre adresse email : ");
        			String email = new String(LectureClavier.saisirPhrase());
        			p_mail = email;
        			if(rechercheClient(email)) {
        				//@mail
        				String mdp;
        				do {
        				System.out.println("Entrez votre mot de passe : ");
        			    mdp = new String(LectureClavier.saisirPhrase());
        			
        					
        				}while(!isValid(email, mdp));	
            			
        			}else {
        				System.out.println("\nVotre @mail est inconnu de notre BDD, création de votre compte: ");
        				creerClient(email);
        			}
        			
        			if (email.endsWith("khaliss-bank.fr")) {
        				demarrerB();
        				
        			}else {
        				int m2 = menu_02();
        				demarrerC();
        			}
        			
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
                	System.out.println("Cette fonction est en cours de devellopement (2 mai)");
                    break;
                case 2: 
                	System.out.println("Liste de clients :");
                	System.out.println("Cette fonction est en cours de devellopement (2 mai)");
                    break;
                    
                case 3:
                	System.out.println("Ouvrir un nouveau compte client: ");
                	System.out.println("Entrez  l'adresse email du nouveau client: ");
        			String email = new String(LectureClavier.saisirPhrase());
        			creerClient(email);
                    break;
                
                case 4:
                	System.out.println("Transferer de l'argent d'un compte client: ");
                	System.out.println("Cette fonction est en cours de devellopement (2 mai)");
                	
                    break;
                case 5:
                	System.out.println("Supprimer un compte: ");
                	System.out.println("Cette fonction est en cours de devellopement (2 mai)");
                	
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
                	System.out.println("Cette fonction est en cours de devellopement (2 mai)");
                    break;
                case 2: 
                	System.out.println("Liste des comptes:");
                	Personne.afficheListeComptesClient(p_mail);
                    break;
                case 3:
                	System.out.println("Effectuer un virement :");
                	Personne.sendArgent(p_mail);
                    break;
                case 4:
                	System.out.println("Ouvrir un nouveau compte bancaire:");
                	Personne.openCompte(p_mail);
                    break;
                case 5:
                	System.out.println("Supprimer un compte: ");
                	System.out.println("Cette fonction est en cours de devellopement (2 mai)");
                	
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
		
		//newClient.setM_nomConseiller("XX");
		
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
	
	public boolean rechercheClient(String p_mail)
	{		
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le r�pertoire courant de l'utilisateur
		
		ArrayList<Client> lstClient = new ArrayList<>();
		LoadSaveFile.getListFromFile(chemin+"/"+"src\\khaliss_bank_project\\fichiers"+"/"+"listeBanquiersClients.csv", lstClient);
		
		for(int i=0; i<lstClient.get(0).getNbValues(); ++i) 
		{
			if(lstClient.get(2).getValue(i).equals(p_mail))
			{
				return true;
			}
			
		}
		return false;
	}
	
	public static ArrayList<Client> LloginMdp(){
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le r�pertoire courant de l'utilisateur
		
		ArrayList<Client> lstClient = new ArrayList<>();
		LoadSaveFile.getListFromFile(chemin+"/"+"src\\khaliss_bank_project\\fichiers"+"/"+"listeBanquiersClients.csv", lstClient);
		return lstClient;
	}
	
	public ArrayList<String> affListeLoginMdp(String c_mail) {
		
		m_listeLoginMdp = LloginMdp();
		int detect = 0 ;
		int detect1 = 0 ;
		ArrayList<String> lgMdp = new ArrayList<String>();
		
		for(int i=0; i<m_listeLoginMdp.get(0).getNbValues(); ++i ) {
			detect1=0;
			for(int j=0;j<m_listeLoginMdp.size(); ++j) {
				detect=0;
				if (c_mail.equals(m_listeLoginMdp.get(2).getValue(i))){
					detect1++;
					if(detect1 == 1) {
						lgMdp.add(m_listeLoginMdp.get(3).getValue(i));
					}
					detect=1;
				}
			}
			if(detect == 1)
				System.out.println("");						
		}
		return lgMdp;
	}
	
	private static boolean isValid(String login, String mdp) {
		
		boolean connexion = false;
		String mdp_recup = null;
		ArrayList<String> lgMdp = new ArrayList<String>();
		
		Authentification a = new Authentification();
		lgMdp = a.affListeLoginMdp(login);
		try{
			mdp_recup = lgMdp.get(0);
			connexion = CryptageMdpMD5.CryptageMdp(mdp, mdp_recup);
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le login ou le mot de passe du client n'est pas bon !");
			connexion = CryptageMdpMD5.CryptageMdp(mdp, mdp_recup);
		}	
		return connexion;	
	}
}