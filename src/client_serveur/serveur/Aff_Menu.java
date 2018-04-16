package client_serveur.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import divers.*;

public class Aff_Menu implements Runnable {
	
	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	
	private Thread t3, t4;

	private Scanner sc;
		
	public Aff_Menu(Socket s){
		socket = s;
	}
	
	public void run() {
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			/*
			sc = new Scanner(System.in);
			
			t4 = new Thread(new Emission(out));
			t4.start();
			
			t3 = new Thread(new Reception(in));
			t3.start();
			*/
			Menu m = new Menu();
			m.demarrer();
			
		} catch (IOException e) {
			System.err.println("Le serveur distant s'est d�connect� !");
		}
	}
}
