package divers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptageMdpMD5 {
	
	//Permet d'encoder une chaine passe en prametre avec l'algo MD5
	public static String avoirMdpCrypte(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5"); //// on choisi l'algorithme MD5 ou SHA
		md.update(password.getBytes());
		byte[] b  = md.digest();
		StringBuffer sb  = new StringBuffer();
		for(byte b1 : b ){
			sb.append(Integer.toHexString(b1 & 0xff)).toString();
		}
		return sb.toString();
	}

	//Permet de tester une chaine (mdp) et une valeur encode en héxa
	public static boolean testMdp(String chaineNonEncode, String valeurHexaMD5DeRef) throws NoSuchAlgorithmException {
		String testMdpEncode = CryptageMdpMD5.avoirMdpCrypte(chaineNonEncode);
		return (testMdpEncode.equals(valeurHexaMD5DeRef));
	}
	
	//Permet de faire un essai de cryptage avec un mdp et un hash (ex: mdp = toto, hash = f71dbe52628a3f83a77ab494817525c6 )
	public static boolean CryptageMdp(String mdp, String mdpHashe){
		
		try {
			
			if (CryptageMdpMD5.testMdp(mdp, mdpHashe)){
				System.out.println("Le mdp est verifie");
				return true;
			}
			else {
				System.out.println("Le mdp n'est pas verifie");
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}