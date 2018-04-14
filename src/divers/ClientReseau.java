package divers;

import java.io.*;
import java.net.*;
import java.util.*; 

public class ClientReseau {
	public static Socket m_mySocket = null;
	public static Thread m_t1;
	
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
			 //m_t1 = new Thread(new ClientConnexion(m_mySocket)); //thread
			 //m_t1.start();
			
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

class ClientConnexion implements Runnable  {
	
	private Socket socketDuClient = null ;
	public static Thread t2;
	public static String login = null, mdp = null, msg1=null;
	
	private  boolean connect = false;
	private BufferedReader input = null;
	private PrintWriter output = null;
	private Scanner sc = null;
	

	public ClientConnexion(Socket s) { //constructeur
		socketDuClient = s;
	}


	@Override
	public void run() {

		try {
			
			output = new PrintWriter(socketDuClient.getOutputStream());
			input = new BufferedReader(new InputStreamReader(socketDuClient.getInputStream()));	
			sc = new Scanner(System.in);

			while(!connect ){
				//Saisi du mail
				System.out.println(input.readLine());
				login = sc.nextLine();
				output.println(login);
				output.flush();
				
				//Saisi du mdp
				System.out.println(input.readLine());
				mdp = sc.nextLine();
				output.println(mdp);
				output.flush();
				
				if(input.readLine().equals("connecte")){		
					System.out.println("Je suis connecté "); 
					connect = true;
				 }
				
				else {
					System.err.println("Vos informations sont incorrectes "); 
				}
			}
			/*	
			t2 = new Thread(new Chat_ClientServeur(socket));
			t2.start();
			*/
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Le serveur ne répond plus ");
		}
	}
}

