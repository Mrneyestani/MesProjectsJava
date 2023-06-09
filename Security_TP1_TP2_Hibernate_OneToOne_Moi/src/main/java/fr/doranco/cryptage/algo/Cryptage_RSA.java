package fr.doranco.cryptage.algo;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public final class Cryptage_RSA {

	// Signing Algorithm
	private static final String SIGNING_ALGORITHM = "SHA256withRSA";
	private static final String RSA = "RSA";
	private static Scanner sc;

	// Function to implement Digital signature
	// using SHA256 and RSA algorithm
	// by passing private key.
	public static byte[] Create_Digital_Signature(byte[] input, PrivateKey Key) throws Exception {
		Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
		signature.initSign(Key);
		signature.update(input);
		return signature.sign();
	}

	// Generating the asymmetric key pair
	// using SecureRandom class
	// functions and RSA algorithm.
	public static KeyPair Generate_RSA_KeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
		keyPairGenerator.initialize(2048, new SecureRandom());
		return keyPairGenerator.generateKeyPair();
	}

	// Function for Verification of the
	// digital signature by using the public key
	public static boolean Verify_Digital_Signature(byte[] input, byte[] signatureToVerify, PublicKey key)
			throws Exception {
		Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
		signature.initVerify(key);
		signature.update(input);
		return signature.verify(signatureToVerify);
	}

}
