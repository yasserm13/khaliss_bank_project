package khaliss_bank_project;

import java.security.NoSuchAlgorithmException;
import java.util.*;

import divers.*;
import client_serveur.serveur.*;
import client_serveur.client.*;

/**
 * <b>MainKB est la classe principale du programme</b>
 * <p>
 * Voici les membres de la classe :
 * <ul>
 * <li>m_nom</li>
 * <li> m_prenom</li>
 * <li>m_mail</li>
 * <li>m_motDePasse</li>
 * <li>m_listeCompte</li>
 * </ul>
 * </p>
 * <p>
 * <b>Note : </b>Les classe qui heritres de Personne sont : Client et Banquier
 * </p>
 * 
 * @author Mamadou, Yasser, El-Arif
 * @version 1.0
 */
public class MainKB {

	public static void main(String[] args) {
		/*
		Menu m = new Menu();
		m.demarrer();
		//m.creerClient("test");
		
		Client c2 = new Client("MOUSSA","Yasser","yasser.moussa@niama.fr","f71dbe52628a3f83a77ab494817525c6","Marseille","MOUSSA");
		//System.out.println(c2);
		//System.out.println();
		
		Banquier b1 = new Banquier("MAREGA", "mamadou", "mamadou.marega@khaliss-bank.fr", "toto");
		b1.affListeClient(); 

		// Cryptage MD5	
		CryptageMdpMD5.CryptageMdp("moussa","639583119441bd84c373c314afd2814d");
		*/
		
		//Test client serveur
		//Serveur.getIpLocale();
		//ClientR.LancerClient();
		Serveur.LancerServeur();
		
	}
}