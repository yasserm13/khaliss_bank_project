package khaliss_bank_project;

public enum EConstantes {
	
	INCO("UNKNOWN"),
	TST("TEST");
	
	private String m_valeur;
	
	//Constructeur
	EConstantes(String v){
		this.m_valeur = v;
	}
	
	//retourne la valeur
	public String getM_valeur() {
		return m_valeur;
	}
}
