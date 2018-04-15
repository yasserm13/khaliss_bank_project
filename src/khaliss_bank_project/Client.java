package khaliss_bank_project;

import java.util.ArrayList;

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
		return this.m_nom+" "+this.m_prenom+" "+this.m_mail+" "+this.m_motDePasse+" "+this.m_addDomicile+" "+this.m_nomConseiller+" ";
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
}