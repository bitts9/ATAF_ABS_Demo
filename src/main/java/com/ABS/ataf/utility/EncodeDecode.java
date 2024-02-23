package com.ABS.ataf.utility;

import org.apache.commons.codec.binary.Base64;

public class EncodeDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String originalInput = "secret_sauce";
		String encString = EncodeDecode.encodeData(originalInput);
		System.out.println(encString);
		System.out.println(EncodeDecode.decodeData(encString));
	}
	
	public static String encodeData(String eStr) {
		String encodedString = new String(Base64.encodeBase64(eStr.getBytes()));
		return encodedString;
	}
	
	public static String decodeData(String dStr) {
		String decodedString = new String(Base64.decodeBase64(dStr.getBytes()));
		return decodedString;
	}

}
