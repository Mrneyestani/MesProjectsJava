package fr.doranco.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AdaptorDate {
	
	private static final String formatDate = "dd/MM/yyyy";
	
	public static final java.util.Date convertDateSqlToDateUtil(java.sql.Date dateSql) {
		return new java.util.Date(dateSql.getTime());
	}
	
	public static final java.sql.Date convertDateUtilToDateSql(java.util.Date dateUtil) {
		return new java.sql.Date(dateUtil.getTime());
	}

	public static final java.util.Date convertDateStringToDateUtil(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		java.util.Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		return date;
	}
	
	public static final java.sql.Date convertDateStringToDateSql(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		java.sql.Date date = null;
		try {
			date = (java.sql.Date) formatter.parse(dateStr);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
	
	public static final String convertDateUtilToDateString(Date date, String dateFormat) {

		String returnValue = "";
		if (date != null)
			returnValue = new SimpleDateFormat(dateFormat).format(date);

		return returnValue;
	}
	
	public static final String convertDateSqlToDateString(java.sql.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.format(date);
	}
}
