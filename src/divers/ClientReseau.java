package divers;

import java.io.*;
import java.net.*;

public class ClientReseau {
	public static Socket m_mySocket = null;
	//public static Thread m_t1;
	
	ClientReseau(){
		super();
	}

	public static void ClientLocale1() {
			
		BufferedReader input;
		PrintWriter output;
		
		try {
			
			m_mySocket = new Socket(InetAddress.getLocalHost(), 2018);
			System.out.println("Demande de connexion");
			
			input = new BufferedReader(new InputStreamReader(m_mySocket.getInputStream()));
			String message_distant = input.readLine();
			System.out.println(message_distant);
			
			m_mySocket.close();
		
		}catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
		
	public static void ClientLocale2(String ip_server, int port) {

		try {
			
			System.out.println("Demande de connexion");
			m_mySocket = new Socket(ip_server, port);
			System.out.println("Connexion etablie avec le serveur !");
			
			m_mySocket.close();
			
			}catch(UnknownHostException uhe) {
				uhe.printStackTrace();
				System.err.println("Impossible de se connecter à l'adresse "+m_mySocket.getLocalAddress());
			}catch(IOException ioe) {
				ioe.printStackTrace();
				System.err.println("Aucun serveur à l'écoute du port "+m_mySocket.getLocalPort());
			}
	}
}