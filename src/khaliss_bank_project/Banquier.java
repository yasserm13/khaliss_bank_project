package khaliss_bank_project;
import java.io.*;
import java.util.*;
import divers.*;

public class Banquier extends Personne {
	public ArrayList<Client> m_listeClient;
	
	public Banquier(String N,String P, String M, String MDP) { //constructeur 2
		super (N,P,M,MDP);
	}; 
	
	public String toString() {
		return this.m_nom+" "+this.m_prenom+" "+this.m_mail+" ";
	}
	
	@Override
	public boolean modifInfoPerso(int infoAmodif) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public ArrayList<Client> LClient(){
		ArrayList<Client> lstClient = new ArrayList<>();
		LoadSaveFile.getListFromFile("C:\\Users\\yasser.moussa\\eclipse-workspace-projets\\khaliss_bank_project\\src\\khaliss_bank_project\\fichiers\\listeBanquiersClients.csv", lstClient);
		return lstClient;
	}
	
	public void affListeClient() {
		m_listeClient = LClient();
		int detect = 0 ;
		for(int i=0; i<m_listeClient.get(0).getNbValues(); ++i ) {
			ArrayList<String> gVal = new ArrayList<>();
				
			for(int j=0;j<m_listeClient.size(); ++j) {
				detect=0;
				if (this.m_nom.equals(m_listeClient.get(4).getValue(i)))
				{
					System.out.print(m_listeClient.get(j).getValue(i)+'\t');
					detect=1;
				}
			}
			if(detect == 1)
				System.out.println("");						
		}
	}
/*
	private void deleteClient() {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		m_listeClient = LClient() ;
		try {
			System.out.println("Saisir le mail du client à supprimer: ");
			String tmp_mail = br.readLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		if (tmp_mail.equals(ligne[2]))) {
			
		}
	}*/
}
