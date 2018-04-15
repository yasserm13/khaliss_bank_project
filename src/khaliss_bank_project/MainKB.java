package khaliss_bank_project;

import java.security.NoSuchAlgorithmException;
import java.util.*;

import divers.*;
import client_serveur.serveur.*;
import client_serveur.client.*;

public class MainKB {

	public static void main(String[] args) {
		/*
		Menu m = new Menu();
		m.demarrer();
		m.creerClient("test");
		
		Client c2 = new Client("MOUSSA","Yasser","yasser.moussa@niama.fr","f71dbe52628a3f83a77ab494817525c6","Marseille","MOUSSA");
		System.out.println(c2);
		System.out.println();
		
		// Cryptage MD5	
		CryptageMdpMD5.CryptageMdp("toto", c2.getM_motDePasse());
		*/
		
		//Test client serveur
		//Serveur.getIpLocale();
		Serveur.LancerServeur();
	}
}