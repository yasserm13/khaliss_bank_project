package divers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LectureClavier {
	
	private BufferedReader br;
	
	public LectureClavier() { //constructeur par defaut
        this.br = new BufferedReader (new InputStreamReader (System.in));
    }
	
	public float lireEntreeFloat(int min, float max) {
		float montant;
	    	while (true) {
	            try {
	                montant = Float.parseFloat(br.readLine());
	                if (montant >= min && montant <= max) {
	                    break;
	                }
	            } catch (Exception e) {
	              	e.printStackTrace();
	                System.out.println("Mauvaise valeur, veuillez saisir un reel !");
	        }
	    }
	    return montant;
	}
}
