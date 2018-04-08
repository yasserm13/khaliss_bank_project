package divers;

import java.io.*;
import java.net.*;

public class ClientServer {
	
	public InetAddress m_localAddress;
	public InetAddress m_serverAddress;
	
	public ClientServer() { //constructeur par defaut;
		super();
	};
	
	public void getIpClientServer(String serverAddress) {
		try {
			m_localAddress = InetAddress.getLocalHost();
			System.out.println("L'adresse ip de la machine locale est: "+m_localAddress );
			
			m_serverAddress = InetAddress.getByName(serverAddress);
			System.out.println("L'adresse ip du serveur est: "+m_serverAddress );
					
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
		
	}
	
	public void Server() {
		
		ServerSocket socketServeur;
		Socket socketDuServeur;
		BufferedReader input;
		PrintWriter output;
		
		try {
			
		 socketServeur = new ServerSocket(2018);
		 System.out.println("Le serveur est à l'écoute du port : "+socketServeur.getLocalPort());
		 socketDuServeur = socketServeur.accept();
		 	System.out.println("Une personne s'est connecte ");
		 output = new PrintWriter(socketDuServeur.getOutputStream());
		 output.println("Vous êtes connectee !! ");
		 output.flush();
		 
		 socketServeur.close();
		 socketDuServeur.close();
		 
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	public void ClientLocale() {
		
		Socket mySocket;
		BufferedReader input;
		PrintWriter output;
		
		try {
			
		mySocket = new Socket(InetAddress.getLocalHost(), 2018);
		System.out.println("Demande de connexion");
		
		input = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
		String message_distant = input.readLine();
		System.out.println(message_distant);
		
		mySocket.close();
		
		}catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	

}
