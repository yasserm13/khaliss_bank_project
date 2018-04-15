package divers;
import java.util.*;

import java.io.*;


public class LectureClavier {
	
	private BufferedReader br;
	
	public LectureClavier() { //constructeur par defaut
        this.br = new BufferedReader (new InputStreamReader (System.in));
    }


	public float lireEntreeFloat(int min, float max) {
		float montant=0;
		int erreur = 0; 
	    	do{
	    		erreur = 0;
	            try {
	                montant = Float.parseFloat(br.readLine());
	                if (montant >= min && montant <= max) {
	                    break;
	                }
	            } catch (Exception e) {
	              	erreur=1;
	                System.out.println("Mauvaise valeur, veuillez saisir un reel !");
	                }
	    }while(erreur == 1);
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
		
		int Int = 0;
				
            try 
            {
            	
            	Int = saisie.nextInt();
            	saisie.nextLine();
            	
            } catch (Exception e){
           System.out.println("Mauvaise valeur, veuillez saisir un entier!");
                Int = saisie.nextInt();
            }
            return Int;
    	
	}
	
	
	
	
	public static double saisirDouble()
	{
		Scanner saisie = new Scanner(System.in);
		double Double = 0;
			
			try {
				Double = saisie.nextDouble();
            	saisie.nextLine();
            	
				}catch(InputMismatchException e) {
					System.out.println("Mauvaise valeur, veuillez saisir un chiffre correct!");
					Double = saisirDouble();
				}
	
          return Double;
    	}
	public static char saisirCaractere()
	{
	    Scanner sc = new Scanner(System.in);
	    String str;
	    char reponse = '.';
	    try
	    {
	        str = sc.nextLine();
	        str = str.toUpperCase();
	        reponse = str.charAt(0);
	        System.out.println("Lettre le charactère entré est: "+reponse);
	    } catch(StringIndexOutOfBoundsException e) {
	    	System.out.println("Saisie non valide");
	    	reponse = saisirCaractere();
	    }
	    
       	return reponse;

     		
	}
}

