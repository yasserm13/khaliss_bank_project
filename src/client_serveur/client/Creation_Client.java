package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import divers.CryptageMdpMD5;
import divers.LectureClavier;
import divers.LoadSaveFile;
import divers.Menu;
import divers.OutilsNewClient;
import khaliss_bank_project.Client;
import khaliss_bank_project.InterfaceKB;

public class Creation_Client implements Runnable,  InterfaceKB {

	private Socket socket;
	public static String login = null;
	private PrintWriter output = null;
	private BufferedReader input = null;
	
	
	public Creation_Client(Socket s, String log) {
		this.socket = s;
		this.login = log;
	}
	
	@Override
	public Client creerClient(String p_mail){
		System.out.println("Je suis dans creerClient");
		Client newClient = new Client();
				
		//newClient.setM_mail(p_mail);
		
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
		//newClient.setM_nomConseiller(selectBanquier());
		System.out.println("");
		
		//newClient.openCompte(p_mail);
		
		newClient.setM_nomConseiller("XX");
		
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

	@Override
	public String selectBanquier(){	
					String nomBanquier = new String("");
					char choix;
					System.out.println("Je suis dans banquier");
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
	
	@Override
	public void run() {
		
		try {
			System.out.println("Client: Thread Creation_Client");
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			Menu m = new Menu();
			m.creerClient(login);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
