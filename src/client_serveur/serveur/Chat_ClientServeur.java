package client_serveur.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Chat_ClientServeur implements Runnable {

	private Socket socket = null;
	private BufferedReader input = null;
	private PrintWriter output = null;
	
	private String login = "clients";
	private Thread t3, t4;
	
	public Chat_ClientServeur(Socket s, String log){
		
		socket = s;
		login = log;
	}
	
	public void run() {
		
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			t3 = new Thread(new Reception(input,login));
			t3.start();
			
			t4 = new Thread(new Emission(output));
			t4.start();
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(login +"s'est deconnecte ");
		}
	}
}
