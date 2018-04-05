package khaliss_bank_project;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Banquier extends Personne {
	public ArrayList<Client> m_listeClient;
	
	public Banquier() { //constructeur par defaut
		super ();
	}; 
	
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
	
	public void affListeClient() {
		//Accès au fichier CSV avec un chemin absolu 
        String FichierCSV = "Fichiers\\listeBanquierClients.csv";
        BufferedReader br = null;
        String line = "";//caractère de fin de ligne valeurs du CSV
        String cvsSplitBy = ","; //caractère de séparation des valeurs du CSV

        try {

            br = new BufferedReader(new FileReader(FichierCSV));
            line = br.readLine();
            while ((line = br.readLine()) != null) {

	            // utiliser la virgule comme séparateur
	            String[] ligne = line.split(cvsSplitBy);
	            
	            //Affichage de sa liste de client
	            if (this.m_nom.equals(ligne[4])) {
	            	System.out.println(ligne[0]+'\t'+ ligne[1]+'\t'+ ligne[2]+'\t'+ligne[3]);
	            } 
            }
            // Exception fichier non trouvé
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Input-Output (Flux) Exception
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}

	
}
