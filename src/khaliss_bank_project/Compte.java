package khaliss_bank_project;
import java.util.*;
public class Compte {
	
	private String m_mailTitulaire;
	private int m_numCompte;
	private String m_typeCompte;
	private String m_historique; //Fichier
	private double m_solde;
	
	//Constructeur par defaut
	public Compte() { 
		this.m_mailTitulaire = "" ;
		this.m_numCompte = 0 ;
		this.m_typeCompte = "";
		this.m_solde = 0;
	} 
	
	public Compte(int nc, String mt, String tc) {
		this.m_numCompte = nc;
		this.m_mailTitulaire = mt;
		this.m_typeCompte = tc;
	}
	
	public int getM_numCompte() {
		return m_numCompte;
	}
	
	public void setM_numCompte(int numCompte) {
		this.m_numCompte = numCompte;
	}
	
	public String getM_typeCompte() {
		return m_typeCompte;
	}
	
	public void setM_typeCompte(String typeCompte) {
		this.m_typeCompte = typeCompte;
	}
	
	public double getM_solde() {
		return m_solde;
	}
	
	public void setM_solde(double solde) {
		this.m_solde = solde;
	}
	
	public String getM_mailTitulaire() {
		return m_mailTitulaire;
	}

	public void setM_mailTitulaire(String m_mailTitulaire) {
		this.m_mailTitulaire = m_mailTitulaire;
	}

	public void affHistoriqueCompte(String nomFichier) { //a changer par un fichier
		
	}
	
}
