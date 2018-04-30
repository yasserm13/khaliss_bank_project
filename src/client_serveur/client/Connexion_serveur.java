package client_serveur.client;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

import divers.Menu;
import divers.ToolsNewClient;
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
			String status;
			
			//Recup saisi du mail
			System.out.println(input.readLine());
			login = sc.nextLine();
			output.println(login);
			output.flush();
			
			//Recup saisi du mdp
			System.out.println(input.readLine());
			mdp = sc.nextLine();
			output.println(mdp);
			output.flush();
			
			/*1*/status = input.readLine();
			
			switch (status) {
	            case "connecte":
	            	System.out.println("Je suis connecte");
	            	t2 = new Thread(new Chat_ClientServeur(socket));
	        		t2.start();
	                break;
	            case "non_connecte":
	            	System.out.println("Les informations saisies sont incorrectes"); 
	           /*2*/System.out.println(input.readLine());
	           
	           		t3 = new Thread(new Creation_Client(socket, login));
	           		t3.start();
	                break;
	            case "c": 
	            	System.out.println("Fonction 3");
	                break;
	            default:
	            	 System.out.println("Mauvais choix, recommencez !"); // Action par dÃ©faut en cas de mauvais choix
			}
			
			/*
			//Recup saisi du mdp
			System.out.println(input.readLine());
			mdp = sc.nextLine();
			output.println(mdp);
			output.flush();
		
		
			if(input.readLine().equals("connecte")){
				System.out.println("Je suis connecte "); 
				connect = true;
			}
			else {
				System.err.println("Les informations saisies sont incorrectes");  //affiche le msg en rouge
			}
			*/
		}
		
		//t2 = new Thread(new Chat_ClientServeur(socket));
		//t2.start();
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Le serveur ne repond plus ");
		}
	}
}