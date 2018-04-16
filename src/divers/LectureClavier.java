package divers;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
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
		
		int Int = 0;
		
            try 
            {
            	Int = saisie.nextInt();
            	saisie.nextLine();
            }
            catch (Exception e) 
            {
              	e.printStackTrace();
                System.out.println("Mauvaise valeur, veuillez saisir un entier!");
                Int=saisirInt();
            }
            
            return Int;
	}
	
	
	
	
	public static double saisirDouble()
	{
		Scanner saisie = new Scanner(System.in);
		
		double Double = 0;
		
            try 
            {
            	Double = saisie.nextDouble();
            	saisie.nextLine();
            	
            	return Double;
            }
            catch (Exception e) 
            {
              	e.printStackTrace();
                System.out.println("Mauvaise valeur, veuillez saisir un entier!");
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
	        System.out.println("Lettre le charact�re entr� est: "+reponse);
	    } catch(StringIndexOutOfBoundsException e) {
	    	System.out.println("Saisie non valide");
	    	reponse = saisirCaractere();
	    }
	    
       	return reponse;

     		
	}
}

