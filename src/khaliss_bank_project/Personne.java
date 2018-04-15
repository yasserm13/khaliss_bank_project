package khaliss_bank_project;

import java.io.*;
import java.util.*;
import java.lang.*;
import divers.*;
import java.math.*;

public abstract class Personne {
	protected String m_nom = "";
	protected String m_prenom = ""; 
	protected String m_mail = "";
	protected String m_motDePasse = "";
	static final String UNKNOWN = "XXXX";
	
	public Personne() { //constructeur par defaut
		this.m_nom =UNKNOWN;
		this.m_prenom = UNKNOWN;
		this.m_mail = UNKNOWN;
		this.m_motDePasse = UNKNOWN;
	}; 
	
	public Personne(String N,String P, String M, String MDP) { //constructeur 2
		this.m_nom = N;
		this.m_prenom = P;
		this.m_mail = M;
		this.m_motDePasse = MDP;
	};

	@Override 
	//Override signifie qu'on redefini une class mere
	public String toString() {
		return this.m_nom+" "+this.m_prenom+" "+this.m_mail+" ";
	}
	
	public String getM_nom() {
		return m_nom;
	}

	public void setM_nom(String m_nom) {
		this.m_nom = m_nom;
	}


	public String getM_prenom() {
		return m_prenom;
	}


	public void setM_prenom(String m_prenom) {
		this.m_prenom = m_prenom;
	}
	
	public String getM_mail() {
		return m_mail;
	}

	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}
	
	public String getM_motDePasse() {
		return m_motDePasse;
	}


	public void setM_motDePasse(String m_motDePasse) {
		this.m_motDePasse = m_motDePasse;
	}
	 
	public abstract boolean modifInfoPerso(int infoAmodif); //methode virtuel a implementer dans les classes filles
		
	
	public boolean deleteCompte(int numCompte) {
		//A faire
		return true;
	}
	
	public boolean sendArgent(Compte cptDebit, Compte cptCredit) {
		//A faire
		return true;
	}
	
	public void openCompte(String p_mailClient){
	    //Creer le compte
	    	double solde;
	    	Compte newCompte = new Compte();
	    	char choix;
	    	newCompte.setM_numCompte((int)( Math.random()*( 99999999 - 1111 + 1 ) ) + 1111);
	    	
	    	newCompte.setM_mailTitulaire(p_mailClient);
	    	System.out.println("Veuillez choisir un type de compte");
	    	do {
		    	System.out.println("A-	Livret A\n" + 
		    			"B-   	Livret de développement durable et solidaire (LDDS)\n" + 
		    			"C-   	Livret jeune\n" + 
		    			"D-   	Plan épargne logement (PEL)\n");
		    	choix = LectureClavier.saisirCaractere();
		    	
	    	}while(choix != 'A' && choix != 'B' && choix != 'C' && choix != 'D');
	    	
	    	switch (choix){
		    	case 'A':	newCompte.setM_typeCompte("Livret_A");
		    		break;
		    	case 'B':newCompte.setM_typeCompte("Livret_de_développement_durable_et_solidaire_(LDDS)");
					break;
		    	case 'C':newCompte.setM_typeCompte("Livret_jeune");
					break;
		    	case 'D':newCompte.setM_typeCompte("Plan_épargne_logement_(PEL)");
					break;
		    	default: System.out.println("Choix_non_existant");
		    		break;
			}
	    
	   		System.out.println("Veuillez saisir le solde");
	   		solde = LectureClavier.saisirDouble();
	    	
	    	newCompte.setM_solde(solde);
	    	
	    	LoadSaveFile.setListClientsToFile(newCompte);

	    	

		}

}