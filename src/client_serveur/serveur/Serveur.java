package client_serveur.serveur;

import java.io.*;
import java.net.*;

public class Serveur {
	
	//Pour la m�thode getIpLocale();
	public static InetAddress m_localAddress;
	
	//Pour la m�thode  ServerMethode()
	public static ServerSocket m_socketServeur = null;
	public Socket m_socketDuServeur;
	public static  Thread m_t;
	
	public Serveur() { //constructeur par defaut;
		super();
	};
	
	public static void getIpLocale() {
		try {
			m_localAddress = InetAddress.getLocalHost();
			System.out.println("L'adresse ip de la machine locale est : "+m_localAddress );			
		}catch(UnknownHostException e){
			e.printStackTrace();
		}
	}
	
	public static void LancerServeur() { // avec Thread
		
		try {
			m_socketServeur = new ServerSocket(2018);
			System.out.println("Le serveur est � l'�coute du port : "+m_socketServeur.getLocalPort());
		
			m_t = new Thread(new Accepter_connexion_clients(m_socketServeur));
			m_t.start();
		
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Le port "+m_socketServeur.getLocalPort()+" est d�j� utilis� !");
		}
	}
}