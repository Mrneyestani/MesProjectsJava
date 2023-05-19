package fr.doranco.exemple.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Dates {
	
	private static final String formatDate = "dd/MM/yyyy";
	
	public static final java.util.Date convertDateSqlToUtil(java.sql.Date dateSql) {
		return new java.util.Date(dateSql.getTime());
	}
	
	public static final java.sql.Date convertDateUtilToSql(java.util.Date dateUtil) {
		return new java.sql.Date(dateUtil.getTime());
	}

	public static final java.util.Date convertStringToDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		java.util.Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static final String convertDateToString(java.sql.Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.format(date);
	}
}
