package fr.doranco.cryptage.main;

import javax.crypto.SecretKey;

import fr.doranco.cryptage.dao.IUserDao;
import fr.doranco.cryptage.dao.ParamDao;
import fr.doranco.cryptage.dao.UserDao;
import fr.doranco.cryptage.entity.Param;
import fr.doranco.cryptage.entity.User;
import fr.doranco.cryptage.keys.KeyGenerateClasse;

public class AddKeyMain {

	public static void main(String[] args)  {
	
		ParamDao paramDao = new ParamDao();
		
		Param paramKeyByte = new Param();
		//byte[] cleByte =paramKeyByte.convertCleSercetToCleBye();
		//paramKeyByte.setCleByte(cleByte);
		
		try {
			paramKeyByte = paramDao.addParamKey(paramKeyByte);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(paramKeyByte);
		

		
		 
		 
		 
	}

}
