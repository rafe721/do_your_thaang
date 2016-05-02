package com.xmlSymbolsConverter.util;

public class SymbolConverter {

	public static String convertSymbols(String text) 
	{
		// TODO Auto-generated method stub
		text=text.replaceAll("&quot;", "\"");
		text=text.replaceAll("&lt;", "<");
		text=text.replaceAll("&gt;", ">");
		return text;
	}
	
}
