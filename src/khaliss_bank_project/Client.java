package khaliss_bank_project;

import java.io.*;
import java.util.*;

import divers.*;


public class Client extends Personne{
	private String m_addDomicile = "";
	private String m_nomConseiller = "";
	private int m_numCompte;
	//public ArrayList<Compte> m_listeCompte;
	private ArrayList<String> values;
	//public ArrayList<Client> m_listeCompte;

	
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
	
/*	public ArrayList<Client> LClientCompte(){
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le répertoire courant de l'utilisateur
		ArrayList<Client> lstCompte = new ArrayList<>();
		LoadSaveFile.getListFromFile(chemin+"/"+"src\\khaliss_bank_project\\fichiers"+"/"+"listeComptes.csv", lstCompte);
		return lstCompte;
	}
	
	public void affListeCompte(String c_mail) {
		m_listeCompte = LClientCompte();
		int detect = 0 ;
		int detect1 = 0 ;
		for(int i=0; i<m_listeCompte.get(0).getNbValues(); ++i ) {
			detect1=0;
			for(int j=0;j<m_listeCompte.size(); ++j) {
				//System.out.print(i+"\t");
				detect=0;
				if (c_mail.equals(m_listeCompte.get(0).getValue(i))){
					detect1++;
					if(detect1 == 1)
						System.out.print(i+"\t");//permet l'identification de la ligne
					System.out.print(String.format("%-35s",m_listeCompte.get(j).getValue(i)));
					detect=1;
				}
			}
			if(detect == 1)
				System.out.println("");						
		}
	}*/
}
