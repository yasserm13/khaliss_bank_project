package client_serveur.client;

import java.io.*;
import java.net.*;

public class Client {

	public static Socket socket = null;
	public static Thread t1;
	
	public static void main(String[] args) {
		try {
			
			System.out.println("Demande de connexion");
			socket = new Socket("172.20.10.2", 2018); // ou ("localhost", 2018) pour faire les tests
			System.out.println("Connexion etablie avec le serveur !");// Si le message s'affiche c'est que je suis connecté
			System.out.println("----------------[ Authentification ]----------------");

			t1 = new Thread(new Connexion_serveur(socket));//thread
			t1.start();	
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("Impossible de se connecter à l'adresse "+socket.getLocalAddress());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Aucun serveur à l'écoute du port "+socket.getLocalPort());
		}
	}
}