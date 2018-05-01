package client_serveur.serveur;

import java.net.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import client_serveur.client.Chat_ClientServeur;
import divers.*;
import khaliss_bank_project.*;

import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter output = null;
	private BufferedReader input = null;
	private String login = "clients", mdp =  null;
	public boolean authentifier = false;
	public Thread t2,t3;
	private Scanner sc = null;
	private int nbClient = 1;
	public static ArrayList<Client> m_listeLoginMdp;
	
	public Authentification(){
		 super();
	}
	
	public Authentification(Socket s){
		 socket = s;
	}
	
	public void run() {
	
		try {
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			
		while(!authentifier){
			
			//@mail
			output.println("Entrez votre @mail : ");
			output.flush();
			login = input.readLine();
			
			//mdp
			output.println("Entrez votre mot de passe : ");
			output.flush();
			mdp = input.readLine();
			
			if(isValid(login, mdp)){
				
				output.println("connecte");
				System.out.println(login +" vient de se connecter ");
				
				System.out.println("Il est le client numero "+nbClient+" connecte !");
				nbClient ++;
				
				output.flush();
				authentifier = true;	
				
				t2 = new Thread(new Chat_ServeurClient(socket,login));
				t2.start();
			}
			
			else {
		   /*1*/output.println("non_connecte");
		   /*2*/output.println("\nVotre @mail est inconnu de notre BDD, création de votre compte: ");
				output.flush();
				System.out.println("J'attends d'etre reveillé ");
				t3.wait();
				System.out.println("Je suis reveillé ");
			t3 = new Thread(new  Chat_ServeurClient(socket,login));
			t3.start();
			
			}
		 }
			//Thread coter serveur
		System.out.println("J'ai quitté la boucle while");
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			System.out.println(login+" ne repond pas !");
		}
	}
	
	//adaptation pour lire dans notre fichier csv
	
	private static boolean isValid(String login, String pass) {	
	
		boolean connexion = false, verifMail = false, verifMdp = false ;
		
		m_listeLoginMdp = Banquier.LClientBanquier();
		
		for(int i=0; i<m_listeLoginMdp.get(0).getNbValues(); ++i) 
		{
			if(m_listeLoginMdp.get(2).getValue(i).equals(login)){
				
				verifMail = true;
				if(verifMail == true) {
					
					verifMdp = CryptageMdpMD5.CryptageMdp(pass, m_listeLoginMdp.get(3).getValue(i));
					if(verifMdp == true) 
						connexion=true;
				}
			}
		}
		return connexion;
	}
}