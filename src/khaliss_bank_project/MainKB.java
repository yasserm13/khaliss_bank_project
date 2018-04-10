package khaliss_bank_project;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import java.util.*;
import divers.*;

public class MainKB {

	public static void main(String[] args) {
		
		ArrayList<Client> lstClient = new ArrayList<>();
		LoadSaveFile.getListFromFile("C:\\Users\\mamadou.marega\\eclipse-workspace\\khaliss_bank_project\\src\\khaliss_bank_project\\fichiers\\listeBanquiersClients.csv", lstClient);
		
		
		/*lstClient.get(4).printValue();
	    System.out.println();
	    System.out.println(lstClient.get(0).getNbValues()); // pour avoir le nb de ligne
	    System.out.println(lstClient.size());// pour avoir le nb de colonne
	    */
		/*
		for(int i=0; i<lstClient.get(0).getNbValues(); ++i ) {
			
			for(int j=0;j<lstClient.size(); ++j) 		
				System.out.print(lstClient.get(j).getValue(i)+" ");
			System.out.println("");
		}
		
		
		Menu m = new Menu();
		m.demarrer();
		
		*/
		Client c1 = new Client(); 
		Client c2 = new Client("MOUSSA","Yasser","yasser.moussa@niama.fr","monMDP","Marseille","MOUSSA");
		System.out.println(c1);
		System.out.println(c2);
		int numCompte = 0;
				
		/*Banquier b1 = new Banquier("MOUSSA","Yasser","yasser.moussa@niama.fr","monMDP");
		Banquier b2 = new Banquier("Test1","Yasser","test1.t1@niama.fr","monMDP");
		
		System.out.println("Au banquier 1 maintenant \n");
		b1.affListeClient();
		System.out.println("");
		System.out.println("Au banquier 2 maintenant");
		b2.affListeClient();
		*/
		//LoadSaveFile.setListToFile(c2);
		
		try {
			numCompte = c1.openCompte(c1.getM_mail());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//System.out.println(b1);
		
		/*
		System.out.println(CryptageMdpMD5.avoirMdpCrypte("monmdp44"));
		try {
			if (CryptageMdpMD5.testMdp("sqsq", "1165a5154f5cb"));
				System.out.println("les mdp sont vérifés");
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		*/
	}
}
