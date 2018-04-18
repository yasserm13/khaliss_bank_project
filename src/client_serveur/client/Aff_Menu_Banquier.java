package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import divers.*;

public class Aff_Menu_Banquier implements Runnable {
	private Socket socket;
	
	private PrintWriter out = null;
	private BufferedReader in = null;
		
	public Aff_Menu_Banquier(Socket s){
		socket = s;
	}
	
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//Afficher menu Banquier
			Menu m = new Menu();
			m.demarrerB();
   
		} catch (IOException e) {
			System.err.println("Le serveur distant s'est deconnecte !");
		}
	}
}