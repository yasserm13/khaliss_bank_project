package divers;

import java.io.*;
import java.net.*;

public class Server {
	
	//Pour la méthode getIpClientServer(String serverAddress);
	public InetAddress m_localAddress;
	public InetAddress m_serverAddress;
	
	//Pour la méthode  ServerMethode() 
	public ServerSocket socketServeur;
	public Socket socketDuServeur;
	public BufferedReader input;
	public PrintWriter output;
	
	public Server() { //constructeur par defaut;
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
	
	public void ServerMethode1() { //sans Thread
			
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
	
	public void ServerMethode2() { // avec Thread
		
		try {
			
		 socketServeur = new ServerSocket(2018);
		 System.out.println("Le serveur est à l'écoute du port : "+socketServeur.getLocalPort());
		 
		 Thread t = new Thread(new AccepterClients(socketServeur));
		 t.start();
		 System.out.println("Mes employeurs sont prêts !");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

class AccepterClients implements Runnable{
	private ServerSocket socketServeur;
	private Socket socketDuServeur;
	private int nbClient = 1;

	public AccepterClients(ServerSocket s) {
		socketServeur = s;
	}

	@Override
	public void run() {
		 try {
			 while(true) {
				 socketDuServeur = socketServeur.accept(); // si un client se co on l'accepte
				 System.out.println("Le client numero "+nbClient+" est connecté !");
				 nbClient ++;
				 socketDuServeur.close();
			 }
		 }catch(IOException ioe){
			 ioe.printStackTrace();
		 }
		
	}
}