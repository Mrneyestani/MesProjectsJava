package fr.doranco.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.text.SimpleDateFormat;

import javax.crypto.spec.SecretKeySpec;

import fr.doranco.enums.AlgorithmeCryptage;

public final class Conversion {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private Conversion() {
	}
	
	public static final  byte[] convertObjectToBytes(Object object) throws IOException {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutput out = new ObjectOutputStream(bos)) {
			out.writeObject(object);
			return bos.toByteArray();
		} 
	}
	
	public static final Object convertBytesToObject(byte[] bytes) throws IOException, ClassNotFoundException {
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
				ObjectInput in = new ObjectInputStream(bis)) {
			return in.readObject();
		} 
	}
	
	public static final String convertBytesToString(byte[] bytes, String encodage) throws UnsupportedEncodingException {
		
		if (encodage == null) {
			encodage = "UTF-8";
		}
		String byteInString;
		try {
			byteInString = new String(bytes, encodage);
		} catch(UnsupportedEncodingException e) {
			byteInString = new String(bytes, "UTF-8");
		}
		return byteInString;
	}

	public static final byte[] convertStringToBytes(String chaine, String encodage) throws UnsupportedEncodingException {
		
		if (encodage == null) {
			encodage = "UTF-8";
		}
		byte[] stringInByte;
		try {
			stringInByte = chaine.getBytes(encodage);
		} catch(UnsupportedEncodingException e) {
			stringInByte = chaine.getBytes("UTF-8");
		}
		return stringInByte;
	}

	public static final byte[] convertKeyToBytes(Key key) {
		return key.getEncoded();
	}

	public static final Key convertBytesToKey(byte[] keyInBytes) {
		return new SecretKeySpec(keyInBytes, AlgorithmeCryptage.DES.toString());
	}

	public static final java.util.Date convertStringToDateUtil(String dateStr) throws Exception {

		if (dateStr == null || dateStr.trim().isEmpty()) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL ou vide !");
		}
		return formatter.parse(dateStr);
	}

	public static final String convertDateUtilToString(java.util.Date date) throws Exception {
		
		if (date == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return formatter.format(date);
	}

	public static final java.util.Date convertDateSqlToDateUtil(java.sql.Date sqlDate) throws Exception {
		if (sqlDate == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return new java.util.Date(sqlDate.getTime());
	}

	public static final java.sql.Date convertDateUtilToDateSql(java.util.Date utilDate) throws Exception {
		if (utilDate == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return new java.sql.Date(utilDate.getTime());
	}
}
