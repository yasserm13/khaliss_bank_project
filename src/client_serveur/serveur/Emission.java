package client_serveur.serveur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Emission implements Runnable {

	private PrintWriter output;
	private String message = null;
	private Scanner sc = null;
	
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
