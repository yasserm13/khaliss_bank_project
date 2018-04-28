package client_serveur.client;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import divers.Menu;
import khaliss_bank_project.Client;
import khaliss_bank_project.Personne;

import java.io.*;

public class Connexion_serveur implements Runnable {

	private Socket socket = null;
	public static Thread t2,t3;
	public static String login = null, mdp = null, msg1 = null;
	private PrintWriter output = null;
	private BufferedReader input = null;
	private Scanner sc = null;
	private boolean connect = false;
	
	public Connexion_serveur(Socket s){
		
		socket = s;
	}
	
	public void run() {
		
		try {
			
		output = new PrintWriter(socket.getOutputStream());
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		sc = new Scanner(System.in);
		
		while(!connect ){
			/*
			//Saisi du mail
			System.out.println(input.readLine());
			login = sc.nextLine();
			output.println(login);
			output.flush();
			
			if(rechercheClient(login)) {
				//Saisi du mdp
				System.out.println(input.readLine());
				mdp = sc.nextLine();
				output.println(mdp);
				output.flush();
			}else {
				Menu m = new Menu();
				System.out.println("\nVotre @mail est inconnu de notre BDD, création de votre compte: ");
				m.creerClient(login);
			}
			
			if (login.endsWith("khaliss-bank.fr")) {
				t2 = new Thread(new Aff_Menu_Banquier(socket));
				t2.start();
			}else {
				t3 = new Thread(new Aff_Menu_Client(socket));
				t3.start();
			}
			
			if(input.readLine().equals("connecte")){
				System.out.println("Je suis connecte "); 
				connect = true;
			}
			
			else {
				System.err.println("Les informations saisies sont incorrectes ");  //affiche le msg en rouge
			}
		}
		*/
		t2 = new Thread(new Chat_ClientServeur(socket));
		t2.start();
		
		/*
		if (login.endsWith("khaliss-bank.fr")) {
			t2 = new Thread(new Aff_Menu_Banquier(socket));
			t2.start();
		}else {
			t3 = new Thread(new Aff_Menu_Client(socket));
			t3.start();
		}*/
		}
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Le serveur ne repond plus ");
		}
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