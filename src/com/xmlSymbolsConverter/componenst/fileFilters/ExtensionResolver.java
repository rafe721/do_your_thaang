package com.xmlSymbolsConverter.componenst.fileFilters;

import javax.swing.filechooser.FileFilter;

public class ExtensionResolver {

	public static String getFileExtension(FileFilter aFilter)
	{
		if(aFilter instanceof TextFilter)
		{
			return ".txt";
		}
		else if(aFilter instanceof XMLFilter)
		{
			return ".xml";
		}
		
		return ".txt";
	}
	
}
