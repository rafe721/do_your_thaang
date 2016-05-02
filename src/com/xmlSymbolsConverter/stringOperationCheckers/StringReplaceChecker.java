package com.xmlSymbolsConverter.stringOperationCheckers;

public class StringReplaceChecker {
    public static void main(String[] args) {
        String s = "&lt;be the man&gt; &quot;oh!yeah&quot; &lt;\\be the man&gt;";
        int length;
        System.out.println("s = " + s);
        char[] chars = s.toCharArray();
        length = s.length();
        StringBuilder stringBuilder;
        StringBuilder sentence = new StringBuilder();;
        for (int i=0;i<length;i++)
        {
        	if(chars[i]=='&')
        	{
        		stringBuilder = new StringBuilder();
        		stringBuilder.append(chars[i]);
        		stringBuilder.append(chars[i+1]);
        		stringBuilder.append(chars[i+2]);
        		stringBuilder.append(chars[i+3]);
        		if(stringBuilder.toString().equalsIgnoreCase("&gt;"))
        		{
        			sentence.append('>');
        			i+=3;
        		}
        		else if(stringBuilder.toString().equalsIgnoreCase("&lt;"))
        		{
        			sentence.append('<');
        			i+=3;
        		}
        		else
        		{
        			stringBuilder.append(chars[i+4]);
        			stringBuilder.append(chars[i+5]);
        			if(stringBuilder.toString().equalsIgnoreCase("&quot;"))
        			sentence.append('\"');
        			i+=5;
        		}
        		
        	}
        	else
        	{
        		sentence.append(chars[i]);
        	}
        	
        }
        System.out.println("Answer: "+sentence.toString());
    }
}