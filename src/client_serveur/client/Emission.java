package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import divers.Menu;
import khaliss_bank_project.Client;
import khaliss_bank_project.Personne;


public class Emission implements Runnable {

	private String login = null, message = null;
	private Scanner sc = null;
	private String mdp = null;
	
	private PrintWriter output = null;
	private BufferedReader input = null;
	
	public Emission(PrintWriter out) {
		this.output = out;		
	}

	public void run() {
		
		  sc = new Scanner(System.in);  
		  while(true){
			    System.out.println("Votre message :");
				message = sc.nextLine();
				output.println(message);
			    output.flush();
			  }
	}
}
