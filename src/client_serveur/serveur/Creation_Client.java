package client_serveur.serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

import divers.CryptageMdpMD5;
import divers.LectureClavier;
import divers.LoadSaveFile;
import divers.Menu;
import divers.ToolsNewClient;
import khaliss_bank_project.Client;

public class Creation_Client implements Runnable {

	private Socket socket;
	public static String login = null;
	
	private PrintWriter output = null;
	private BufferedReader input = null;
	
	public Creation_Client(Socket s,String log) {
		this.socket = s;
		this.login = log;
	}
	
	@Override
	public void run() {
		Client newClient = new Client();
		
		try {
			System.out.println("Serveur: Thread Creation_Client");
			
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			/*1*/output.println("Création compte");
			System.out.println(input.readLine()+" addDomicile");
			System.out.println(input.readLine()+" prenom");
			System.out.println(input.readLine()+" mail");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
