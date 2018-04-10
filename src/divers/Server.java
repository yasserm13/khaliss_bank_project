package divers;

import java.io.*;
import java.net.*;

public class Server {
	
	//Pour la méthode getIpClientServer(String serverAddress);
	public InetAddress m_localAddress;
	public InetAddress m_serverAddress;
	
	//Pour la méthode  ServerMethode() 
	public static ServerSocket m_socketServeur = null;
	public Socket m_socketDuServeur;
	public static  Thread m_t;
	
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
			
			 m_socketServeur = new ServerSocket(2018);
			 System.out.println("Le serveur est à l'écoute du port : "+m_socketServeur.getLocalPort());
			 
			 m_socketDuServeur = m_socketServeur.accept();
			 
			 System.out.println("Une personne s'est connecte ");
			 	
			 output = new PrintWriter(m_socketDuServeur.getOutputStream());
			 output.println("Vous êtes connectee !! ");
			 output.flush();
			 
			 m_socketServeur.close();
			 m_socketDuServeur.close();
		 
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void ServerMethode2() { // avec Thread
		
		try {
			
		 //m_localAddress = InetAddress.getLocalHost();
		 m_socketServeur = new ServerSocket(2018);
		 
		 System.out.println("Le serveur est à l'écoute du port : "+m_socketServeur.getLocalPort());
		 
		 m_t = new Thread(new AccepterClients(m_socketServeur)); //thread
		 m_t.start();
		 
		 System.out.println("Serveur : mes employeurs sont prêts !");
		 
		 //Ecriture sur le client ?
		 /*
		 output = new PrintWriter(m_socketDuServeur.getOutputStream());
		 output.println("Vous êtes connectee !! ");
		 output.flush();
		 m_socketDuServeur.close();
		 */
		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Le port "+ m_socketServeur.getLocalPort()+ " est deja utilise !");
		}
	}
}

class AccepterClients implements Runnable{
	
	private ServerSocket socketServeur;
	private Socket socketDuServeur;
	private int nbClient = 1;

	public AccepterClients(ServerSocket s) { //constructeur
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