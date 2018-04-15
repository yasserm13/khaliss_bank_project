package client_serveur.serveur;

import java.io.*;
import java.net.*;


public class Accepter_connexion_clients implements Runnable{

	private ServerSocket socketserver = null;
	private Socket socket = null;
	public Thread t1;
	
	public Accepter_connexion_clients(ServerSocket socketServeur){ //contructeur
	 socketserver = socketServeur;
	}
	
	public void run() {
		
		try {
			while(true){
				
			socket = socketserver.accept();
			System.out.println("Un client veut se connecter ! ");
			
			t1 = new Thread(new Authentification(socket));
			t1.start();
			
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur serveur");
		}
	}
}