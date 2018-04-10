package khaliss_bank_project;

import java.io.IOException;
import java.util.ArrayList;

import divers.LectureClavier;
import divers.LoadSaveFile;

public class Client extends Personne{
	private String m_addDomicile = "";
	private String m_nomConseiller = "";
	private int m_numCompte;
	public ArrayList<Compte> m_listeCompte;
	private ArrayList<String> values;
	
	public Client() { //constructeur par defaut
		super ();
	}; 
	
	public Client(String N,String P, String M, String MDP, String AD, String NC) { //constructeur 2
		super (N,P,M,MDP);
		this.m_addDomicile = AD;
		this.m_nomConseiller = NC;
	}; 
	

	public String toString() {
		return this.m_nom+" "+this.m_prenom+" "+this.m_mail+" "+this.m_addDomicile+" "+this.m_nomConseiller+" ";
	}
	
	public String getM_addDomicile() {
		return m_addDomicile;
	}
	
	public void setM_addDomicile(String m_addDomicile) {
		this.m_addDomicile = m_addDomicile;
	}
	
	public String getM_nomConseiller() {
		return m_nomConseiller;
	}
	
	public void setM_nomConseiller(String nomConseiller) {
		this.m_nomConseiller = nomConseiller;
	}
	
	public int getM_numCompte() {
		return m_numCompte;
	}
	
	public void setM_numCompte(int m_numCompte) {
		this.m_numCompte = m_numCompte;
	}

	@Override
	public boolean modifInfoPerso(int infoAmodif) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Test avec la fonction load file
	public Client(ArrayList<String> values) {
        this.values = values;
    }
	
	public void printValue() {
        this.values.forEach(System.out::println);
    }

    public String getValue(int i) {
        return this.values.get(i);
    }

    public int getNbValues() {
        return this.values.size();
    }
    
	public ArrayList<Client> LClient(){
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le répertoire courant de l'utilisateur
		
		ArrayList<Client> lstClient = new ArrayList<>();
		LoadSaveFile.getListFromFile(chemin+"/"+"src\\khaliss_bank_project\\fichiers"+"/"+"listeBanquiersClients.csv", lstClient);
		return lstClient;
	}
	
    public int openCompte(String mailClient) throws IOException{//Creer le compte
		int random = 0;
		String numCompte;
		char reponse;
		ArrayList<Client> m_listClient ;
		System.out.println("Fonction Open Compte");
		do {
			do{ 
				System.out.println("Vous êtes sur le point de creer un compte");
				System.out.println("O --> pour quitter\nN --> pour poursuivre");
				reponse = LectureClavier.lireChar();
			}while(reponse != 'O' && reponse != 'N');
			
			if(reponse == 'O') {
				System.out.println("Generation de rand");
				random =(int) (Math.random()*999999999);     //Génération d'un chiffre aléatoire
				//numCompte = String.valueOf(random);
				numCompte = "999999999";
				System.out.println("Chargement de la liste des clients");
				m_listClient = LClient();
				System.out.println("Fin Chargement de la liste des clients");
				int detect = 0;
				do {
					System.out.println("Test si numéro existe");
					for(int i=0; i<m_listClient.get(0).getNbValues(); ++i ) {
						System.out.println("Première boucle fo");
						ArrayList<String> gVal = new ArrayList<>();
						for(int j=0;j<m_listClient.size(); ++j) {
							System.out.println("Deuxième boucle for");
							if (numCompte.equals(m_listClient.get(5).getValue(i))){
								random =(int) (Math.random()*999999999);
								//numCompte = String.valueOf(random);
								detect++;
								System.out.println("J'ai un compte de même numéro "+detect+1+" fois");
							}
						}
					}
				}while(detect == 4);
				System.out.println("Le compte est ouvert");
			}
			
			reponse = 'N';
		}while(reponse != 'O' && reponse != 'N');
		
		return random;
	}
}
