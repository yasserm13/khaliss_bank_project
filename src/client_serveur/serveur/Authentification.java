package client_serveur.serveur;

import java.net.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter output = null;
	private BufferedReader input = null;
	private String login = "clients", mdp =  null;
	public boolean authentifier = false;
	public Thread t2;
	private int nbClient = 1;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
			
			//@mail
			output.println("Entrez votre adresse email : ");
			output.flush();
			login = input.readLine();
			
			//@mail
			output.println("Entrez votre mot de passe : ");
			output.flush();
			mdp = input.readLine();

			if(isValid(login, mdp)){
				
				output.println("connecte");
				System.out.println(login +" vient de se connecter ");
				
				System.out.println("Il est le client numero "+nbClient+" connecté !");
				nbClient ++;
				
				output.flush();
				authentifier = true;	
			}
			else {
				output.println("erreur"); output.flush();
			}
		 }
			t2 = new Thread(new Chat_ClientServeur(socket,login));
			t2.start();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(login+" ne répond pas !");
		}
	}
	
	//Lecture du fichier contenant la liste des clients/banquiers
	private static boolean isValid(String login, String pass) {
		
		boolean connexion = false;
		String chemin;
		chemin = System.getProperty("user.dir");
		
		try {
				Scanner sc = new Scanner(new File(chemin+"/"+"src\\client_serveur\\serveur"+"/"+"clients.txt"));//cible to do : listeBanquiersClients.csv
			
				while(sc.hasNext()){
					if(sc.nextLine().equals(login+" "+pass)){ //on suppose que le fichier se presente comme ça : (login mdp) to do
	              	  connexion=true;
	              	  break;
					}
	             }
			
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
			System.out.println("Le fichier n'existe pas !");
		}
		return connexion;
	}
	
	//adaptation pour lire dans notre fichier csv
	private static boolean isValid2(String login, String pass) {
		
		boolean connexion = false;
		String chemin;
		chemin = System.getProperty("user.dir");
		
		try {
				Scanner sc = new Scanner(new File(chemin+"/"+"src\\client_serveur\\serveur"+"/"+"clients.txt"));//cible to do : listeBanquiersClients.csv
			
				while(sc.hasNext()){
					if(sc.nextLine().equals(login+" "+pass)){ //on suppose que le fichier se presente comme ça : (login mdp) to do
	              	  connexion=true;
	              	  break;
					}
	             }
			
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
			System.out.println("Le fichier n'existe pas !");
		}
		return connexion;
	}
}