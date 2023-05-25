package fr.doranco.monprojet.cryptage.algo;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public final class AlgorithmeSignature {

	private AlgorithmeSignature() {
	}
	
	public final static byte[] sign(String algorithm, byte[] data, KeyPair kp) throws Exception {
		
		Signature signature = null;
		switch (algorithm) {
		case "DSA":
			signature = Signature.getInstance(algorithm);
			signature.initSign(kp.getPrivate());
			signature.update(data);
			byte[] dataSigned = signature.sign();
			boolean isSignatureOk = verify(signature, data, kp, dataSigned);
			if (isSignatureOk) {
				return dataSigned;
			} else {
				throw new Exception("La signature ne s'est pas faite correctement !");
			}
		case "RSA":
			throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas encore implémenté !");
		default:
			throw new NoSuchAlgorithmException("L'algorithme '" + algorithm + "' n'est pas pris en charge !");
		}
	}
	
	private static final boolean verify(Signature signature, byte[] data, KeyPair kp, byte[] dataSigned) throws Exception {
		
		signature.initVerify(kp.getPublic());
		signature.update(data);
		return signature.verify(dataSigned);
	}
}
