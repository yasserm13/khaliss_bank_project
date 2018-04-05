package divers;

import java.io.*;
import java.util.*;
import khaliss_bank_project.Client;

public class LoadSaveFile {
	   /*-----------------Class pour la lecture du fichier cible-----------------*/
    public static void getListFromFile(String path, ArrayList<Client> listeClient) {
        File file = new File(path);
        String[] names = null;
        
        try {
            Scanner inputStream = new Scanner(file); //Flux d'entrée
            String str = inputStream.next();
            names = str.split(","); // On choisit la virgule comme séparateur
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
        }
        
    }

}
