package khaliss_bank_project;

public abstract class Personne {
	protected String m_nom = "";
	protected String m_prenom = ""; 
	protected String m_mail = "";
	protected String m_motDePasse = "";
	static final String UNKNOWN = "XXXX";
	
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

	public void setM_mail(String m_prenom) {
		this.m_mail = m_mail;
	}
	
	public String getM_motDePasse() {
		return m_motDePasse;
	}


	public void setM_motDePasse(String m_prenom) {
		this.m_motDePasse = m_motDePasse;
	}

	@Override 
	//Override signifie qu'on redefini une class mere
	public String toString() {
		return this.m_nom+" "+this.m_prenom+" "+this.m_mail+" ";
	}
	
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
	
	public abstract boolean modifInfoPerso(int infoAmodif); //methode virtuel a implementer dans les classes filles
		
	
	public boolean deleteCompte(int numCompte) {
		//A faire
		return true;
	}
	
	public boolean openCompte(String addMail) {
		//A faire
		return true;
	}
	
	public boolean sendArgent(Compte cptDebit, Compte cptCredit) {
		//A faire
		return true;
	}

}