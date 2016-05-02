package com.xmlSymbolsConverter.util;

public class HTMLEntityResolver 
{
	public static String resolveAllEntities(String toConvert)
	{
        int length;
        char[] chars = toConvert.toCharArray();
        length = toConvert.length();
        StringBuilder entityBuilder;
        StringBuilder sentence = new StringBuilder();;
        for (int i=0;i<length;i++)
        {
        	if(chars[i]=='&')
        	{
        		entityBuilder = new StringBuilder();
        		entityBuilder.append(chars[i]);
        		entityBuilder.append(chars[i+1]);
        		entityBuilder.append(chars[i+2]);
        		entityBuilder.append(chars[i+3]);
        		if(entityBuilder.toString().equalsIgnoreCase("&gt;"))
        		{
        			sentence.append('>');
        			i+=3;
        		}
        		else if(entityBuilder.toString().equalsIgnoreCase("&lt;"))
        		{
        			sentence.append('<');
        			i+=3;
        		}
        		else
        		{
        			entityBuilder.append(chars[i+4]);
        			entityBuilder.append(chars[i+5]);
        			if(entityBuilder.toString().equalsIgnoreCase("&quot;"))
        			sentence.append('\"');
        			i+=5;
        		}
        		
        	}
        	else
        	{
        		sentence.append(chars[i]);
        	}
        	
        }
        return sentence.toString();
	}
}
