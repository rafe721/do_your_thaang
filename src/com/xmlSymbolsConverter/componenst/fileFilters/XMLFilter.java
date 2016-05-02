package com.xmlSymbolsConverter.componenst.fileFilters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XMLFilter extends FileFilter {
	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub
		if(f.isDirectory())
		{
			return true;	
		}
		if(f.getName().endsWith(".txt"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "XML Document(.xml)";
	}
	
	public void printData()
	{
		System.out.println("Text Document");
	}

}
