package co.develhope.StudioMedicoGruppo2Java8.utility;

import java.util.Random;

public class StringUtility {

	private static final String ALPHABET = "qwertyuiopasdfghjklzxcvbnm1234567890";
	private static Random random = new Random();
	

	private StringUtility() {}
	
	public static String generateRandomString(int numChars) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numChars; i++) {
			sb.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return sb.toString();
	}
}
