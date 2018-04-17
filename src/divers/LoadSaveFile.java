package divers;

import java.io.*;
import java.util.*;
import khaliss_bank_project.*;

public class LoadSaveFile {
	   /*-----------------Class pour la lecture du fichier cible-----------------*/
    public static void getListFromFile(String path, ArrayList<Client> listeClient) {
        File file = new File(path);
        String[] names = null;
        
        try {
            Scanner inputStream = new Scanner(file); //Flux d'entr�e
            String str = inputStream.next();
            names = str.split(","); // On choisit la virgule comme s�parateur
            int nbG = names.length; //Avoir le nombre de courbe

            ArrayList<String[]> lines = new ArrayList<>();// On stocke les lignes dans un objet ArrayList
            inputStream.hasNext(); //skip first line
            while(inputStream.hasNext())
                lines.add(inputStream.next().split(","));

            for(int i = 0 ; i < nbG ; ++i)
            {
                ArrayList<String> gVal = new ArrayList<>(); 

                for(int j = 0 ; j < lines.size() ; ++j)
                {
                    String f = lines.get(j)[i]; //On parse les valeurs en float
                    gVal.add(f);
                }

               listeClient.add(new Client(gVal)); //Ajout des valeurs dans l'ArrayList
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
			System.out.println("L'ouverture du fichier a echoue !");
        }        
    }
    
    public static void setListToFile(Client clBanque) {
		PrintWriter fich;
		
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le r�pertoire courant de l'utilisateur
		
    	try {
				File fichier = new File(chemin+"/"+"src\\khaliss_bank_project\\fichiers","listeBanquiersClients.csv");//Cr�er un fichier dans le r�pertoire donn� en param�tre

				if(fichier.exists() && fichier.isFile()){
					fich = new PrintWriter(new BufferedWriter(new FileWriter(fichier, true))); //true c'est elle qui permet d'�crire � la suite des donn�es enregistr�es et non de les remplacer
					System.out.println("le fichier existe deja");
					fich.println(clBanque.getM_nom()+","+clBanque.getM_prenom()+","+clBanque.getM_mail()+","+clBanque.getM_addDomicile()+","+clBanque.getM_nomConseiller());
					fich.close();
				
				} else {
					fich = new PrintWriter(new BufferedWriter(new FileWriter(fichier, true))); //true c'est elle qui permet d'�crire � la suite des donn�es enregistr�es et non de les remplacer
					System.out.println("le fichier vient d'etre cree");
					fich.println("Nom,Prenom,Adresse_Email,Mot_De_Passe_Crypte,Adresse_Domicile,Numero__De_Compte,Nom_Conseiller");
					fich.println(clBanque.getM_nom()+","+clBanque.getM_prenom()+","+clBanque.getM_mail()+","+clBanque.getM_motDePasse()+","+clBanque.getM_addDomicile()+","+clBanque.getM_numCompte()+","+clBanque.getM_nomConseiller());
					fich.close();
				 }
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("L'ouverture du fichier a echoue !");
		} catch (IOException e) {
			e.printStackTrace();
		  }
		  }
    
    public static void setListClientsToFile(Compte compte) {
    	
		PrintWriter fich;
		String chemin;
		chemin = System.getProperty("user.dir");//Permet d'avoir le r�pertoire courant de l'utilisateur
		
    	try {
				File fichier = new File(chemin+"/"+"src\\khaliss_bank_project\\fichiers","listeComptes.csv");//Cr�er un fichier dans le r�pertoire donn� en param�tre

				if(fichier.exists() && fichier.isFile()){
					fich = new PrintWriter(new BufferedWriter(new FileWriter(fichier, true))); //true c'est elle qui permet d'�crire � la suite des donn�es enregistr�es et non de les remplacer
					System.out.println("le fichier existe deja");
					fich.println(compte.getM_mailTitulaire()+","+compte.getM_typeCompte()+","+compte.getM_numCompte()+","+compte.getM_solde());
					fich.close();
				
				} else {
					fich = new PrintWriter(new BufferedWriter(new FileWriter(fichier, true))); //true c'est elle qui permet d'�crire � la suite des donn�es enregistr�es et non de les remplacer
					System.out.println("le fichier vient d'etre cree");
					fich.println("Adresse_Email,Type_de_compte,Numero_De_Compte,Solde");
					fich.println(compte.getM_mailTitulaire()+","+compte.getM_typeCompte()+","+compte.getM_numCompte()+","+compte.getM_solde());
					fich.close();
				 }
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("L'ouverture du fichier a echoue !");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static boolean deleteLine(String fileName, int lineNumber) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
             
            PrintWriter fich;
            
            StringBuffer sb = new StringBuffer(); 
            String line;    
            int nbLinesRead = 0;       
            while ((line = reader.readLine()) != null) {
            	System.out.println(line);
                if (nbLinesRead != lineNumber) {
                    sb.append(line + "\n");
                }
                nbLinesRead++;
            }
            reader.close();
            
            fich = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            fich.print(sb);
            fich.close();

 
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}