package com.xmlSymbolsConverter.stringOperationCheckers;

public class SubStringCheckers 
{

	public static void main(String args[])
	{
		String mainString = " sag <Soap> ugoylgvlsuadfgcosatf </Soap> soap";
		System.out.println("The first String is "+mainString);
		System.out.println("After removing anything before <Soap> and after </Soap>       : "+mainString.substring(mainString.indexOf("<Soap>"),mainString.indexOf("</Soap>"))+"</Soap>");
	}
	
	
}
