package fr.doranco.cryptage.algo;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.lang3.RandomStringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Encrypt with PBEWithMD5AndDES ALGO with SALT encryption mode and encoding/decoding BASE64
 * https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html
 * Every implementation of the Java platform is required to support the following standard Cipher transformations with the keysizes in parentheses:
		AES/CBC/NoPadding (128)
		AES/CBC/PKCS5Padding (128)
		AES/ECB/NoPadding (128)
		AES/ECB/PKCS5Padding (128)
		DES/CBC/NoPadding (56)
		DES/CBC/PKCS5Padding (56)
		DES/ECB/NoPadding (56)
		DES/ECB/PKCS5Padding (56)
		DESede/CBC/NoPadding (168)
		DESede/CBC/PKCS5Padding (168)
		DESede/ECB/NoPadding (168)
		DESede/ECB/PKCS5Padding (168)
		RSA/ECB/PKCS1Padding (1024, 2048)
		RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
		RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
 */
public class Cryptage_PBEWithMD5AndDES {
    private static final String ALGORITHM = "PBEWithMD5AndDES";
    // Iteration count
    private static final int ITERATION_COUNT = 20;
    private static final String UNICODE_FORMAT  = "UTF-8";

    /**
     * Constructor
     */
    public Cryptage_PBEWithMD5AndDES(){ }
    
    /**
     * Generate Complex Password due to Secret Key Value
     * @return
     * @throws Exception
     */
   
    public static byte[] generateComplexPasswordOrSecretKeyValue() throws Exception {
    	byte[] passwordOrKeyValue = RandomStringUtils.randomAscii(16).getBytes(UNICODE_FORMAT);
    	KeySpec keySpec = new PBEKeySpec(new String(passwordOrKeyValue).toCharArray());
        SecretKey secretKey = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(keySpec);
        return secretKey.getEncoded();
       
    }
    
    /**
     * Creates the SALT.
     * Creates a Secure Random Number Generator and an empty 8byte array. Fill the array.
     * Returns the SALT.
     * @return
     * @throws Exception
     */
    public static byte[] generateSALT() throws Exception {
    	byte[] saltValue = null;
    	//saltValue = { (byte) 0xc8, (byte) 0x73, (byte) 0x61, (byte) 0x1d, (byte) 0x1a, (byte) 0xf2, (byte) 0xa8, (byte) 0x99,  };    	
    	//saltValue = "HOJAvaLu".getBytes(UNICODE_FORMAT);
    	{
    		SecureRandom r = new SecureRandom();
        	byte[] newSeed = r.generateSeed(8);
        	r.setSeed(newSeed);
        	saltValue = new byte[8];
        	r.nextBytes(saltValue);
    	}
    	return saltValue;
    }

    
    /**
     * Encrypt given encrypted content
     * @param passwordOrKeyValue
     * @param content
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(char[] passwordOrKeyValue, byte[] content, byte[] salt) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
       
        // Create PBE parameter set with SALT and COUNTER
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, ITERATION_COUNT);
        		
        // Create SecretKey
        PBEKeySpec pbeKeySpec = new PBEKeySpec(passwordOrKeyValue);
        SecretKey key = keyFactory.generateSecret(pbeKeySpec);

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance(ALGORITHM);
        
        // Initialize PBE Cipher with key, PBE parameter set
        pbeCipher.init(Cipher.ENCRYPT_MODE, key, pbeParamSpec);
        
        byte[] encryptedContent = pbeCipher.doFinal(content);
        return base64Encode(encryptedContent).getBytes(UNICODE_FORMAT);
    }

    /**
     * Transform a byte array to ALPHANUMERIC string via encoding Base64
     * @param bytes
     * @return
     */
    private static String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }


    /**
     * Decrypt given encrypted content
     * @param passwordOrKeyValue
     * @param content
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(char[] passwordOrKeyValue, byte[] content, byte[] salt) throws Exception {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);

        // Create PBE parameter set with SALT and COUNTER
        PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, ITERATION_COUNT);

        // Create SecretKey
        PBEKeySpec pbeKeySpec = new PBEKeySpec(passwordOrKeyValue);
        SecretKey key = keyFactory.generateSecret(pbeKeySpec);
        
        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance(ALGORITHM);
        
        // Initialize PBE Cipher with key, PBE parameter set
        pbeCipher.init(Cipher.DECRYPT_MODE, key, pbeParamSpec);
        return pbeCipher.doFinal(base64Decode(new String(content)));
    }


    /**
     * Transform ALPHANUMERIC string to byte array via decoding Base64
     * @param property
     * @return
     * @throws IOException
     */
    private static byte[] base64Decode(String property) throws IOException {
        return new BASE64Decoder().decodeBuffer(property);
    }

}
