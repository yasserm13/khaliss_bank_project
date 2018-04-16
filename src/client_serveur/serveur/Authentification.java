package client_serveur.serveur;

import java.net.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import divers.CryptageMdpMD5;
import divers.LoadSaveFile;
import khaliss_bank_project.Client;

import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter output = null;
	private BufferedReader input = null;
	private String login = "clients", mdp =  null;
	public boolean authentifier = false;
	public Thread t2;
	private int nbClient = 1;
	public ArrayList<Client> m_listeLoginMdp;
	
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
			output.println("Entrez votre adresse email : ");
			output.flush();
			login = input.readLine();
			
			//@mail
			output.println("Entrez votre mot de passe : ");
			output.flush();
			mdp = input.readLine();

			if(isValid2(login, mdp)){
				
				output.println("connecte");
				System.out.println(login +" vient de se connecter ");
				
				System.out.println("Il est le client numero "+nbClient+" connect� !");
				nbClient ++;
				
				output.flush();
				authentifier = true;	
			}
			else {
				//output.println("erreur"); output.flush();
				output.println("Mauvais login ou mot de passe !"); output.flush();
			}
		 }
			t2 = new Thread(new Chat_ClientServeur(socket,login));
			t2.start();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(login+" ne r�pond pas !");
		}
	}
	
	//Lecture du fichier contenant la liste des clients/banquiers
	private static boolean isValid(String login, String mdp) {
		
		boolean connexion = false;
		String chemin;
		chemin = System.getProperty("user.dir");
		
		try {
				Scanner sc = new Scanner(new File(chemin+"/"+"src\\client_serveur\\serveur"+"/"+"clients.txt"));//cible to do : listeBanquiersClients.csv
			
				while(sc.hasNext()){
					if(sc.nextLine().equals(login+" "+mdp)){ //on suppose que le fichier se presente comme �a : (login mdp) to do
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
	public static ArrayList<Client> LloginMdp(){
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le r�pertoire courant de l'utilisateur
		
		ArrayList<Client> lstClient = new ArrayList<>();
		LoadSaveFile.getListFromFile(chemin+"/"+"src/khaliss_bank_project/fichiers"+"/"+"listeBanquiersClients.csv", lstClient);
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
					//System.out.print(String.format("%-35s",m_listeLoginMdp.get(j).getValue(i)));
					detect=1;
				}
			}
			if(detect == 1)
				System.out.println("");						
		}
		return lgMdp;
	}
	
	private static boolean isValid2(String login, String mdp) {
		
		boolean connexion = false;
		String mdp_recup = null;
		ArrayList<String> lgMdp = new ArrayList<String>();
		
		Authentification a = new Authentification();
		lgMdp = a.affListeLoginMdp(login);
		try{
			mdp_recup = lgMdp.get(0);
			//System.out.println("Le mot de passe r�cup�r� est : "+mdp);
			connexion = CryptageMdpMD5.CryptageMdp(mdp, mdp_recup);
			
		}catch(IndexOutOfBoundsException e){
			System.out.println("Le login ou le mot de passe du client n'est pas bon !");
			connexion = CryptageMdpMD5.CryptageMdp(mdp, mdp_recup);
		}	
		return connexion;	
	}
}