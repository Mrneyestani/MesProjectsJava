package fr.doranco.cryptage.main;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.xml.bind.DatatypeConverter;

import fr.doranco.cryptage.algo.Cryptage_DSA;

public class Main_DSAalgo {

	public static void main(String args[]) {
		try {
			Boolean CHEAT_MESSAGE = true;
			Boolean CHEAT_SIGNATURE = true;
			// expéditeur Génère une signature numérique pour un message
			String message = "Transfer $2000 to account S314542.0";
			byte[] messageBayte = message.getBytes();
			System.out.println("Message original : " + message);

			// Générer clé privé à signer le message
			KeyPair keyPair = Cryptage_DSA.Generate_DSA_KeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			System.out.println(privateKey);

			// Générer la clé publique à envoyer au destinataire
			PublicKey publicKey = keyPair.getPublic();
			System.out.println(publicKey);

			// créer la signature digital et signer le message
			byte[] signature = Cryptage_DSA.Create_Digital_Signature(messageBayte, privateKey);

			System.out.println("Signature Value:\n " + DatatypeConverter.printHexBinary(signature));

			if (CHEAT_MESSAGE) {
				messageBayte[0]++;
			}
			if (CHEAT_SIGNATURE) {
				signature[4]++;
			}
			System.out.println("--- Example with a valid signature ---");
			Cryptage_DSA.Verify_Digital_Signature(messageBayte, signature, publicKey);

			System.out.println("--- Example with a invalid signature: the message was changed  ---");
			String anotherMessage = "Don't let yesterday take up too much of today.";
			Cryptage_DSA.Verify_Digital_Signature(anotherMessage.getBytes(), signature, publicKey);

			String message2 = "The pessimist sees difficulty in every opportunity.";
			KeyPair keyPair2 = Cryptage_DSA.Generate_DSA_KeyPair();
			
			PublicKey publicKey2 = keyPair2.getPublic();
			System.out.println(publicKey2);
			byte[] signature2 = Cryptage_DSA.Create_Digital_Signature(message2.getBytes(), keyPair2.getPrivate());

			System.out.println(
					"--- Example with a invalid signature: using signature that does not match with the current message ---");
			Cryptage_DSA.Verify_Digital_Signature(messageBayte, signature2, publicKey2);

			System.out.println("--- Example with a invalid signature: using public key from another user ---");
			Cryptage_DSA.Verify_Digital_Signature(messageBayte, signature, publicKey2);

			System.out.println("--- Example with a valid signature:  ---");
			Cryptage_DSA.Verify_Digital_Signature(message2.getBytes(), signature2, publicKey2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
