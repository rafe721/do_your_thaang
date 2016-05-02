package com.xmlSymbolsConverter.stringOperationCheckers;

public class ReplaceTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String text = "&quot; &lt; &gt; &quot; &lt; &gt; &quot; &lt; &gt; \"";
		text=text.replaceAll("&quot;", "\"");
		text=text.replaceAll("&lt;", "<");
		text=text.replaceAll("&gt;", ">");
		System.out.println(text);
	}

}
