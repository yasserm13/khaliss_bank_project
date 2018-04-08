package divers;
import java.security.*;

public class CryptageMdpMD5 {
	
	//Permet d'encoder une chaine passé en pramètre avec l'algo MD5
	public static String avoirMdpCrypte(String cle) {
		byte[] cleUnique = cle.getBytes(); // ma cle unique
		byte[] hash = null; //mon hash
		
		try {
			hash = MessageDigest.getInstance("MD5").digest(cleUnique); // on choisi l'algorithme MD5
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("Pas de cryptage MD5 dans cette VM");
		}
		
		StringBuffer chaineHashe = new StringBuffer();
		for (int i=0 ; i < hash.length; ++i) {
			String hexa = Integer.toHexString(hash[i]);
			if (hexa.length() == 1) {
				chaineHashe.append('0');
				chaineHashe.append(hexa.charAt(hexa.length()-1));
			}else
			{
				chaineHashe.append(hexa.charAt(hexa.length()-2));
			}		
		}
		return chaineHashe.toString();
	}
	
	//Permer de tester une chaine et une valeur encodé (la chaine est en héxa)
	public static boolean testMdp(String chaineNonEncode, String valeurHexaMD5DeRef) throws NoSuchAlgorithmException {
		String testMdpEncode = CryptageMdpMD5.avoirMdpCrypte(chaineNonEncode);
		return (testMdpEncode.equals(valeurHexaMD5DeRef));
	}
}
