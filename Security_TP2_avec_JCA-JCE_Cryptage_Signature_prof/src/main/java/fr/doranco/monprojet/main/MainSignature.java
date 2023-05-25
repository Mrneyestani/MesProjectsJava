package fr.doranco.monprojet.main;

import java.security.KeyPair;

import fr.doranco.monprojet.cryptage.algo.AlgorithmeSignature;
import fr.doranco.monprojet.cryptage.keys.GenerateKeys;
import fr.doranco.monprojet.enums.SignatureEnum;

public class MainSignature {

	public static void main(String[] args) {

		try {
			String message = "Bienvenu(s) chez Doranco.";
			byte[] messageInBytes = message.getBytes("UTF-8");

			KeyPair kp = GenerateKeys.getKeySignature(SignatureEnum.DSA.getAlgorithme(), 1024);

			byte[] messageSigned = AlgorithmeSignature.sign(SignatureEnum.DSA.getAlgorithme(), messageInBytes, kp);
			
			System.out.println("Signature effectuée avec succès.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
