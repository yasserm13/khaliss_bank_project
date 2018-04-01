package khaliss_bank_project;

import java.util.ArrayList;

public class Client extends Personne{
	private String m_addDomicile = "";
	private String nomConseiller = "";
	private int m_numCompte;
	public ArrayList<Compte> m_listeCompte;
	
	public String getM_addDomicile() {
		return m_addDomicile;
	}
	
	public void setM_addDomicile(String m_addDomicile) {
		this.m_addDomicile = m_addDomicile;
	}
	
	public String getNomConseiller() {
		return nomConseiller;
	}
	
	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
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

}
