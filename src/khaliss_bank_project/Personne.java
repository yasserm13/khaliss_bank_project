package khaliss_bank_project;

import java.io.*;
import java.util.*;
import java.lang.*;
import divers.*;
import java.math.*;
/**
 * <b>Personne est une class abstraite</b>
 * <p>
 * Voici les membres de la classe :
 * <ul>
 * <li>m_nom</li>
 * <li> m_prenom</li>
 * <li>m_mail</li>
 * <li>m_motDePasse</li>
 * <li>m_listeCompte</li>
 * </ul>
 * Voici les constructeurs et méthodes de la classe :
 * <ul>
 * <li>Personne()</li>
 * <li>Personne(String N,String P, String M, String MDP)</li>
 * <li>Setter + Getter ex: String getM_nom(), setM_nom(String m_nom) </li>
 * <li>boolean deleteCompte(String mail)</li>
 * <li>ArrayList<Integer> affListeCompte(String c_mail)</li>
 * </ul>
 * </p>
 * <p>
 * <b>Note : </b>Les classes qui heritres de Personne sont : Client et Banquier.
 * </p>
 * 
 * @author Mamadou, Yasser, El-Arif
 * @version 1.0
 */
public abstract class Personne {
	
	protected String m_nom = "";
	protected String m_prenom = ""; 
	protected String m_mail = "";
	protected String m_motDePasse = "";
	static final String UNKNOWN = "XXXX";
	public ArrayList<Client> m_listeCompte;
	
	public Personne() { //constructeur par defaut
		this.m_nom = UNKNOWN;
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
			
	public boolean deleteCompte(String p_mail) { //Verifie l'existance d'un compte
		int num=0;
		int ligneNumCompteToDelete = 999999999;
		ArrayList<Integer> tab = new ArrayList<Integer>();
    	String chemin;
		chemin = System.getProperty("user.dir");
		
		tab = selectToDelete(p_mail);
		if(!tab.isEmpty()) {
			do {
				
				System.out.println("Saisir le numéro de la ligne correspondant au compte à supprimer");
				ligneNumCompteToDelete = (int)LectureClavier.saisirDouble();
			    
				for(int i = 0; i < tab.size(); i++)
			      if(ligneNumCompteToDelete == tab.get(i))
			    	  num = 1;
				
			}while(num == 0);
		}else {
			System.out.println("Il n'y a pas de compte associé à ce client !");
		}
		if(num == 1) {
			System.out.println("La Ligne: "+ligneNumCompteToDelete+" est selectionnée pour être supprimée");
			LoadSaveFile.deleteLine(chemin+"/"+"src\\khaliss_bank_project\\fichiers\\listeComptes.csv",ligneNumCompteToDelete);
			System.out.println("Le compte est supprimé");
			return true;
		}else {
			return false;
		}
	}
	
	
  
    
	
	public ArrayList<Integer> selectToDelete(String c_mail) {
		m_listeCompte = listeComptesKB();
		int detect = 0 ;
		int detect1 = 0 ;
		int count=0;
		ArrayList<Integer> tab = new ArrayList<Integer>(0);
		
		for(int i=0; i<m_listeCompte.get(0).getNbValues(); ++i ) {
			detect1=0;
			for(int j=0;j<m_listeCompte.size(); ++j) {
				//System.out.print(i+"\t");
				detect=0;
				if (c_mail.equals(m_listeCompte.get(0).getValue(i))){
					detect1++;
					if(detect1 == 1) {
						count = i+1;
						tab.add(count);
						System.out.print(count+"\t");//permet l'identification de la ligne
					}
					System.out.print(String.format("%-35s",m_listeCompte.get(j).getValue(i)));
					detect=1;
				}
			}
			if(detect == 1)
				System.out.println("");						
		}
		
		return tab;
	}
	
    public void openCompte(String p_mailClient){
    //Creer le compte
    	double solde;
    	Compte newCompte = new Compte();
    	String typeDeCompte;
    	char choix;
    	newCompte.setM_numCompte((int)( Math.random()*( 99999999 - 11111110 + 1 ) ) + 1111110);
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
	    	case 'A':
    			typeDeCompte="Livret_A";
    			//Compte.verifExistanceDeCompte(p_mailClient,typeDeCompte);//To do 
    			newCompte.setM_typeCompte(typeDeCompte);
	    		break;
	    	case 'B':
	    		typeDeCompte="Livret_de_développement_durable_et_solidaire_(LDDS)";
	    		newCompte.setM_typeCompte(typeDeCompte);
	    		break;
	    	case 'C':
	    		typeDeCompte="Livret_jeune";
	    		newCompte.setM_typeCompte(typeDeCompte);
	    		break;
	    	case 'D':
	    		typeDeCompte="Plan_épargne_logement_(PEL)";
	    		newCompte.setM_typeCompte(typeDeCompte);
	    		break;
	    	default: System.out.println("Choix_non_existant");
	    		break;
		}
    	
   		System.out.println("Veuillez saisir le solde");
   		solde = LectureClavier.saisirDouble();
   		newCompte.setM_solde(solde);
    	LoadSaveFile.setListClientsToFile(newCompte);

    	

	}
    
	public static ArrayList<Client> listeComptesKB(){
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le répertoire courant de l'utilisateur
		ArrayList<Client> lstCompte = new ArrayList<>();
		LoadSaveFile.getListFromFile(chemin+"/"+"src\\khaliss_bank_project\\fichiers"+"/"+"listeComptes.csv", lstCompte);
		return lstCompte;
	}
	
	public void affListeComptesClient(String p_mail) {
		ArrayList<String> listeComptes = new ArrayList<>();
	}
	
	public void afficheListeComptesClient(String p_mail)
	{		
		System.out.println("type de compte:"+ "						  Numéro de compte:"+"					 Solde:");
		
		for(int i=0; i<m_listeCompte.get(0).getNbValues(); ++i) 
		{
			if(m_listeCompte.get(0).getValue(i).equals(p_mail))
			{
				System.out.print(i+1+": ");
				
				for(int j=1;j<m_listeCompte.size(); ++j) 
				{
					System.out.print(String.format("%-55s",m_listeCompte.get(j).getValue(i)));
				}
				
				System.out.println("");
			}
			
		}
	}

	public boolean sendArgent(String p_mail) {
		
		int choix;
		String numeroCompteCredit = new String("");
		double montantVirement = 0, newSoldeDebit = 0, newSoldeCredit = 0;
		
		m_listeCompte = listeComptesKB();
		
		System.out.println("________________________________________________________________");
		
		do 
		{
			
			System.out.println("Selectionner le compte à Débiter:");
			afficheListeComptesClient(p_mail);
			choix = (int)LectureClavier.saisirDouble();
		
			if(choix < 0 || choix==0 || choix > m_listeCompte.size()+1 || !m_listeCompte.get(0).getValue(choix-1).equals(p_mail))
			{
				System.out.println("Le compte saisie ne correspond à aucun des comptes proposés!!");
			}
		
		}while(choix < 0 || choix==0 || choix > m_listeCompte.size()+1 ||!m_listeCompte.get(0).getValue(choix-1).equals(p_mail));
		
		 
		
		System.out.println("Vous avez selectionné le compte numéro: "+m_listeCompte.get(2).getValue(choix-1) + "\n");
		
		System.out.println("Saisir le numéro du compte à créditer :");
		numeroCompteCredit = LectureClavier.saisirPhrase();
		
		System.out.println("Saisir le montant du virement :");
		montantVirement = LectureClavier.saisirDouble(); //gérer le découvert
		
		newSoldeDebit = Double.parseDouble(m_listeCompte.get(3).getValue(choix-1)) - montantVirement;
		
		System.out.println("\nVotre virement de "+montantVirement  +"€ vres le compte: "+ numeroCompteCredit+ " a été effectuer avec succès!! \nVotre nouveau solde est de :\n"+newSoldeDebit+"€");
		
		Compte newCompteDebit  = new Compte(m_listeCompte.get(0).getValue(choix-1),m_listeCompte.get(1).getValue(choix-1),Integer.parseInt(m_listeCompte.get(2).getValue(choix-1)),newSoldeDebit);
		LoadSaveFile.setCompteToFile(newCompteDebit);
		LoadSaveFile.deleteLine(System.getProperty("user.dir")+"/"+"src\\khaliss_bank_project\\fichiers\\listeComptes.csv",choix);
		
		m_listeCompte = listeComptesKB();
		
		for(int i=0; i<m_listeCompte.get(0).getNbValues(); ++i )
		{
			
				if(numeroCompteCredit.equals(m_listeCompte.get(2).getValue(i)))
				{
					newSoldeCredit = Double.parseDouble(m_listeCompte.get(3).getValue(i)) + montantVirement;
					
					Compte newCompteCredit  = new Compte(m_listeCompte.get(0).getValue(i),m_listeCompte.get(1).getValue(i),Integer.parseInt(m_listeCompte.get(2).getValue(i)),newSoldeCredit);
					
					LoadSaveFile.deleteLine(System.getProperty("user.dir")+"/"+"src\\khaliss_bank_project\\fichiers\\listeComptes.csv",i+1);
					
					LoadSaveFile.setCompteToFile(newCompteCredit);
					
					
					
					break;
				}
			
		}
		
		
		
		
		
		return true;
	}
}