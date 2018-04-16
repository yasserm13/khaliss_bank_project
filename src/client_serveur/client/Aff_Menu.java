package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import divers.*;

//ClientR
public class Aff_Menu implements Runnable {
	
	private Socket socket;
	
	private PrintWriter out = null;
	private BufferedReader in = null;
		
	public Aff_Menu(Socket s){
		socket = s;
	}
	
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			Menu m = new Menu();
			m.demarrer();
   
		} catch (IOException e) {
			System.err.println("Le serveur distant s'est deconnecte !");
		}
	}

}