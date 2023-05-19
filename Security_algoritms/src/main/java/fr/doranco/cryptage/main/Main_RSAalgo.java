package fr.doranco.cryptage.main;

import java.security.KeyPair;

import javax.xml.bind.DatatypeConverter;

import fr.doranco.cryptage.algo.Cryptage_RSA;

public class Main_RSAalgo {

	public static void main(String args[]) throws Exception {
		Boolean CHEAT_MESSAGE = false;
		Boolean CHEAT_SIGNATURE = false;
		String input = "Hello! je suis un stagière en informatique";
		byte[] inputByte = input.getBytes();
		
		KeyPair keyPair = Cryptage_RSA.Generate_RSA_KeyPair();
		System.out.println("Message original : "+input);
		System.out.println(keyPair.getPrivate());
		System.out.println(keyPair.getPublic());
		
		// Function Call
		byte[] signature = Cryptage_RSA.Create_Digital_Signature(inputByte, keyPair.getPrivate());

		System.out.println("Signature Value:\n " + DatatypeConverter.printHexBinary(signature));
		if (CHEAT_MESSAGE) {
			inputByte[0]++;
		}
		if (CHEAT_SIGNATURE) {
			signature[4]++;
		}
		System.out.println("Verification: "
				+ Cryptage_RSA.Verify_Digital_Signature(input.getBytes(), signature, keyPair.getPublic()));
	}
}
