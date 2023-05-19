package fr.doranco.cryptage.algo;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

//The Digital Signature Algorithm (DSA)
//The DSA algorithm involves four operations: key generation (which creates the key pair), key distribution, signing and signature verification.
public class Cryptage_DSA {

	// Generating the asymmetric key pair
	// using SecureRandom class
	// functions and RSA algorithm.
	public static KeyPair Generate_DSA_KeyPair() throws Exception {
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		keyPairGenerator.initialize(1024, new SecureRandom());
		return keyPairGenerator.generateKeyPair();
	}
	
	// Function to implement Digital signature
	// using SHA256 and RSA algorithm
	// by passing private key.
	public static byte[] Create_Digital_Signature(byte[] input, PrivateKey Key) throws Exception {
		Signature signature = Signature.getInstance("DSA");
		signature.initSign(Key);
		signature.update(input);
		return signature.sign();
	}
	
	
	// Function for Verification of the
		// digital signature by using the public key
	public static void Verify_Digital_Signature(byte[] input, byte[] signatureToVerify, PublicKey key)
			throws Exception {
		Signature signature = Signature.getInstance("DSA");
		signature.initVerify(key);
		signature.update(input);
		
		boolean ok = signature.verify(signatureToVerify);
		System.out.println("Signature is "+ (ok ? "OK" : "NOT OK") + "!\n");
//		if (signature.verify(signatureToVerify)) {
//			System.out.println("The message is properly signed.");
//		} else {
//			System.err.println("It is not possible to validate the signature.");
//		}
	}
	
}