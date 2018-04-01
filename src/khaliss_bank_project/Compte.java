package khaliss_bank_project;

public class Compte {
	
	private int numCompte;
	private String typeCompte;
	private String historique; //Fichier
	private float solde;
	
	public int getNumCompte() {
		return numCompte;
	}
	
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	
	public String getTypeCompte() {
		return typeCompte;
	}
	
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	
	public float getSolde() {
		return solde;
	}
	
	public void setSolde(float solde) {
		this.solde = solde;
	}
	
	public void affHistoriqueCompte(String nomFichier) { //a changer par un fichier
		
	}
}
