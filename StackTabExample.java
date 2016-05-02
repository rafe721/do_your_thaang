package com.xmlSymbolsConverter.examples;

import java.util.Stack;

public class StackTabExample {
	public static void main(String[] args) 
	{
		String text = "<tab> <hi this is tab1 <tab2> hi this is tab2 <tab3> this is tab3 <\\tab3> <\\tab2> <tab3> this is tab 3 <\\tab3> <\\tab> <tab4> hi this is tab4 <\\tab4>";
		char[] textArray = text.toCharArray();
		
		StringBuilder tagBuilder = new StringBuilder();
		StringBuilder textBuilder = new StringBuilder();
		StringBuilder contentBuilder = new StringBuilder();
		
		Stack<String> tagStack = new Stack<String>();
		
		for (int i = 0; i < textArray.length; i++) 
		{
			if (textArray[i] == '<') 
			{
				if(textBuilder.length()>0)
				{
					contentBuilder.append("\n");
					for(int j=0;j<tagStack.size();j++)
						contentBuilder.append("\t");
					contentBuilder.append(textBuilder.toString().trim());
					textBuilder = new StringBuilder();
				}
				if (tagBuilder.length() == 0)
				{
					tagBuilder.append(textArray[i]);
				}
				else 
				{
					contentBuilder.append("\n");
					for(int j=0;j<tagStack.size();j++)
						contentBuilder.append("\t");
					contentBuilder.append(tagBuilder.toString());
					tagBuilder = null;
					tagBuilder = new StringBuilder();
					tagBuilder.append(textArray[i]);
				}
			}
			
			else if (textArray[i] == '>') 
			{
				if (tagBuilder.length() == 0)
				{
					textBuilder.append(textArray[i]);
				}
				else 
				{
					tagBuilder.append(textArray[i]);
					System.out.println(tagBuilder.toString());
					if(!tagStack.isEmpty())
					{
						String aTag = tagStack.peek();
						aTag = aTag.replaceAll("<", "");
						aTag = aTag.replaceAll(">", "");
						String tempTag = tagBuilder.toString();
						tempTag = tempTag.replaceAll("<", "");
						tempTag = tempTag.replaceAll(">", "");
						if(tempTag.endsWith(aTag) && (tempTag.contains("\\")) && (tempTag.length()-aTag.length()==1))
						{
							tagStack.pop();
							contentBuilder.append("\n");
							for(int j=0;j<tagStack.size();j++){
								contentBuilder.append("\t");
							}
							contentBuilder.append(tagBuilder.toString());
						}
						else
						{
							contentBuilder.append("\n");
							for(int j=0;j<tagStack.size();j++){
								contentBuilder.append("\t");
							}
							contentBuilder.append(tagBuilder.toString());
// System.out.println(tagBuilder.toString());
							tagStack.push(tagBuilder.toString());
						}
					}
					else
					{
						contentBuilder.append("\n");
						for(int j=0;j<tagStack.size();j++)
							contentBuilder.append("\t");
						contentBuilder.append(tagBuilder.toString());
						tagStack.push(tagBuilder.toString());
					}
					tagBuilder = null;
					tagBuilder = new StringBuilder();
				}
			
			} 
			else if(tagBuilder.length()!=0)
			{
				tagBuilder.append(textArray[i]);
			}
			else 
			{
				if(textBuilder.length()==0 && textArray[i]==' ')
				{
					// do nothing
				}
				else
				{
					textBuilder.append(textArray[i]);
				}
			}
			
		}
		System.out.print(contentBuilder.toString());
	}
}
