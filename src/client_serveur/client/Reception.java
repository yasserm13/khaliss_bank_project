package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;


public class Reception implements Runnable {

	private BufferedReader input;
	private String message = null;
	
	public Reception(BufferedReader in){
		
		this.input = in;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	
			message = input.readLine();
			System.out.println("Le serveur vous dit :" +message);
			
		    } catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}