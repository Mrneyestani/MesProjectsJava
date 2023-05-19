package fr.doranco.cryptage.main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import fr.doranco.cryptage.algo.Cryptage_PBEWithMD5AndDES;



/**
 * Class Test of EncrytionPBEWithMD5AndDES
 * @author Huseyin OZVEREN
 */
public class Main_PBEWithMD5AndDES {

	public static void main(String[] args) {
		try{
			byte[] passwordOrKeyValue = Cryptage_PBEWithMD5AndDES.generateComplexPasswordOrSecretKeyValue();
			System.out.println("Generation of complex password : "+new String(passwordOrKeyValue));
			byte[] salt = Cryptage_PBEWithMD5AndDES.generateSALT();
			System.out.println("SALT used: "+new String(salt));
			aEncryptFile(passwordOrKeyValue, salt);
			bDecryptFile(passwordOrKeyValue, salt);
		}catch(Throwable th){
			th.printStackTrace();
		}
    }
	
    public static void aEncryptFile(byte[] keyValue, byte[] salt) throws Exception {
        try{
            File sourceFile = new File(System.getProperty("user.dir") + "/src/main/resources/pdf_with_text.pdf");
            System.out.println("Size of source file (to encrypt): " + sourceFile.length());

            byte[] content = Files.readAllBytes(sourceFile.toPath());
            //
            byte[] encryptContent = Cryptage_PBEWithMD5AndDES.encrypt(new String(keyValue).toCharArray(), content, salt);
            //
            File targetFile = new File(System.getProperty("user.dir") + "/src/main/resources/pdf_with_text_encrypted_pbe.pdf");
            if(targetFile.exists()){
            	targetFile.delete();
            }
            Files.write(targetFile.toPath(), encryptContent, StandardOpenOption.CREATE_NEW);

            System.out.println("Size of encrypted file : " + targetFile.length());
        } catch(Exception e){
			e.printStackTrace();
        }
    }

    public static void bDecryptFile(byte[] keyValue, byte[] salt) throws Exception {
        try {
            byte[] encryptContent = Files.readAllBytes(new File(System.getProperty("user.dir") + "/src/main/resources/pdf_with_text_encrypted_pbe.pdf").toPath());
            System.out.println("Size of encrypted file (to decrypt): " + encryptContent.length);

            byte[] decryptContent = Cryptage_PBEWithMD5AndDES.decrypt(new String(keyValue).toCharArray(), encryptContent, salt);
            File targetFile = new File(System.getProperty("user.dir") + "/src/main/resources/pdf_with_text_decrypted_pbe.pdf");
            if(targetFile.exists()){
            	targetFile.delete();
            }
            Files.write(targetFile.toPath(), decryptContent, StandardOpenOption.CREATE_NEW);
            
            System.out.println("Size of decrypted file : " + targetFile.length());
        }catch (Exception e){
			e.printStackTrace();
        }
    }
    
}
