package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import divers.Menu;
import khaliss_bank_project.Client;
import khaliss_bank_project.Personne;


public class Emission implements Runnable {

	private String login = null, message = null;
	private Scanner sc = null;
	private String mdp = null;
	
	private PrintWriter output = null;
	private BufferedReader input = null;
	
	public Emission(PrintWriter out) {
		this.output = out;
		
	}

	public void run() {
		
		  sc = new Scanner(System.in);
		 System.out.println("Saisir mail");
		 login = sc.nextLine();
		 
		 if(rechercheClient(login)) {
				//Saisi du mdp
				try {
					System.out.println(input.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mdp = sc.nextLine();
				output.println(mdp);
				output.flush();
			}else {
				Menu m = new Menu();
				System.out.println("\nVotre @mail est inconnu de notre BDD, création de votre compte: ");
				m.creerClient(login);
			}
		 
		  /*
		  while(true){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				output.println(message);
			    output.flush();
			  }*/
	}
	
	public boolean rechercheClient(String p_mail)
	{		
		ArrayList<Client> listeCompte = new ArrayList<>();
		listeCompte = Personne.listeComptesKB();
		
		for(int i=0; i<listeCompte.get(0).getNbValues(); ++i) 
		{
			if(listeCompte.get(0).getValue(i).equals(p_mail))
			{
				return true;
			}
			
		}
		return false;
	}
}
