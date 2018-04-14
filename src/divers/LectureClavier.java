package divers;
import java.util.*;

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
	
	public static String saisirPhrase()
	{
		String mot = new String();
		Scanner saisie = new Scanner(System.in);
		
		mot = saisie.nextLine();
		
		return mot;
	}
	
	public static int saisirInt()
	{
		Scanner saisie = new Scanner(System.in);
		
		int Int = saisie.nextInt();
		saisie.nextLine();
		
		return Int;
	}
	
	
}

