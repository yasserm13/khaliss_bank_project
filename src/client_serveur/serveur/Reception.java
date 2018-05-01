package client_serveur.serveur;

import java.io.BufferedReader;
import java.io.IOException;

public class Reception implements Runnable {

	private BufferedReader input;
	private String message = null, login = null;
	
	public Reception(BufferedReader in, String login){
		
		this.input = in;
		this.login = login;
	}
	
	public void run() {
		
		while(true){
	        try {
	        	
			message = input.readLine();
			System.out.println(login+" : "+message);
			
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
