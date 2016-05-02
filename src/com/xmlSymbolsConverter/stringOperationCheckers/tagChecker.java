package com.xmlSymbolsConverter.stringOperationCheckers;

public class tagChecker {
	public static void main(String[] args) {

		String aTag = "<tab>";
		aTag=aTag.replaceAll("<", " ");
		aTag=aTag.replaceAll(">", " ");
		aTag=aTag.trim();
		String tempTag = "<\\tab>";
		tempTag = tempTag.replaceAll("<", " ");
		tempTag = tempTag.replaceAll(">", " ");
		tempTag = tempTag.trim();
		
		System.out.print(aTag);

		System.out.print(tempTag);

		if(tempTag.endsWith(aTag) && (tempTag.contains("\\")) && (tempTag.length()-aTag.length()==1))
		{
			System.out.print("Done");
		}
	}
}
