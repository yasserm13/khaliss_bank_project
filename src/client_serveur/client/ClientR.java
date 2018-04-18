package client_serveur.client;

import java.io.*;
import java.net.*;

//Client Reseau
public class ClientR {
	
	public static Socket socket = null;
	public static Thread t1;
	
	public static void LancerClient() { // avec Thread
		try {
			
			System.out.println("Demande de connexion");
			socket = new Socket("172.17.0.25", 2018); // ou ("localhost", 2018) pour faire les tests
			System.out.println("Connexion etablie avec le serveur !");// Si le message s'affiche c'est que je suis connecte
			System.out.println("┌─────────────────────────────────────────────────┐");
			System.out.println("│             WELCOME TO KHALISS BANK             │");
			System.out.println("├─────────────────────────────────────────────────┤");
			System.out.println("│                Authentification                 │");
			System.out.println("└─────────────────────────────────────────────────┘");

			t1 = new Thread(new Connexion_serveur(socket));//thread
			t1.start();	
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter a l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Aucun serveur a l'ecoute du port "+socket.getLocalPort());
		}
		
	}
}