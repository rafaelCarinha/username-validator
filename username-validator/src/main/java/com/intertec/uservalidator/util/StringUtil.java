package com.intertec.uservalidator.util;


public final class StringUtil {

	public static final String COLON	= ":";
	public static final String COMMA 	= ",";
	public static final String SPACE 	= " ";
	public static final String SLASH 	= "/";
	public static final String NEW_LINE = "\n";
	public static final String EQUAL 	= "=";
	public static final String PIPE 	= "|";
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static boolean isNullOrEmpty(String string) {

		return isNullOrEmpty(string, true);
	}
	
	public static boolean isNullOrEmpty(String string, boolean trim) {

		return (string == null || ((trim) ? string.trim().length() == 0 : string.length() == 0));
	}
	
	
}