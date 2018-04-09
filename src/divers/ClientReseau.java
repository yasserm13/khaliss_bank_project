package divers;

import java.io.*;
import java.net.*;

public class ClientReseau {
	public Socket m_mySocket;
	
	ClientReseau(){
		super();
	}

	public void ClientLocale1() {
			
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
		
	public void ClientLocale2() {

		try {
			
		m_mySocket = new Socket("localhost", 2018);
		System.out.println("Demande de connexion");
		
		m_mySocket.close();
		
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
