package com.guimcarneiro.fightclub.utils;

import java.util.Base64;

public class CommonUtils {

	public static String convertByteArrayToBase64(byte[] byteArray) {
		String encodedString = Base64.getEncoder().encodeToString(byteArray);
		return encodedString;
	}
	
	public static byte[] convertBase64ToByteArray(String encodedString) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		return decodedBytes;
	}
	
}
