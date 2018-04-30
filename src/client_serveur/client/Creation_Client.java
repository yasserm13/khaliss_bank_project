package client_serveur.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import divers.Menu;
import divers.OutilsNewClient;
import divers.ToolsNewClient;
import khaliss_bank_project.Client;

public class Creation_Client implements Runnable {

	private Socket socket;
	public static String login = null;
	private PrintWriter output = null;
	private BufferedReader input = null;
	
	
	public Creation_Client(Socket s, String log) {
		this.socket = s;
		this.login = log;
	}
	
	@Override
	public void run() {
		Client nClient = new Client();
		
		try {
			System.out.println("Client: Thread Creation_Client");
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			/*1*/System.out.println(input.readLine());
			OutilsNewClient nc = new OutilsNewClient(socket);
       		nClient  = nc.creerClient(login);
       		output.println(nClient.getM_addDomicile());
       		output.println(nClient.getM_prenom());
       		output.println(nClient.getM_mail());
       		
       		
       		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
