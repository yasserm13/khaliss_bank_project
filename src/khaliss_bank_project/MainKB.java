package khaliss_bank_project;
import divers.*;

public class MainKB {

	public static void main(String[] args) {
		/*
		Menu m = new Menu();
		m.demarrer();
		
		Client c1 = new Client(); 
		Client c2 = new Client("MOUSSA","Yasser","yasser.moussa@niama.fr","monMDP","Marseille","MOUSSA");
		System.out.println(c1);
		System.out.println(c2);
	   */
		Banquier b1 = new Banquier("MOUSSA","Yasser","yasser.moussa@niama.fr","monMDP");
		b1.affListeClient();
		
		//System.out.println(b1);
	}
}
