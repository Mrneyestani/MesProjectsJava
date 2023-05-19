package fr.doranco.cryptage.main;

import java.security.KeyPair;

import javax.xml.bind.DatatypeConverter;

import fr.doranco.cryptage.algo.Cryptage_RSA;

public class Main_RSAalgo {

	public static void main(String args[]) throws Exception {

		String input = "Hello! je suis un stagière en informatique";
		
		KeyPair keyPair = Cryptage_RSA.Generate_RSA_KeyPair();
		System.out.println("Message original : "+input);
		System.out.println(keyPair.getPrivate());
		System.out.println(keyPair.getPublic());
		
		// Function Call
		byte[] signature = Cryptage_RSA.Create_Digital_Signature(input.getBytes(), keyPair.getPrivate());

		System.out.println("Signature Value:\n " + DatatypeConverter.printHexBinary(signature));

		System.out.println("Verification: "
				+ Cryptage_RSA.Verify_Digital_Signature(input.getBytes(), signature, keyPair.getPublic()));
	}
}
