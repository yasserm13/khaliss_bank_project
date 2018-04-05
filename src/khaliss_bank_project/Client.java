package khaliss_bank_project;

import java.util.ArrayList;

public class Client extends Personne{
	private String m_addDomicile = "";
	private String m_nomConseiller = "";
	private int m_numCompte;
	public ArrayList<Compte> m_listeCompte;
	
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
	
	public String toString() {
		return this.m_nom+" "+this.m_prenom+" "+this.m_mail+" "+this.m_addDomicile+" "+this.m_nomConseiller+" ";
	}
	
	public Client() { //constructeur par defaut
		super ();
	}; 
	
	public Client(String N,String P, String M, String MDP, String AD, String NC) { //constructeur 2
		super (N,P,M,MDP);
		this.m_addDomicile = AD;
		this.m_nomConseiller = NC;
	}; 
}
