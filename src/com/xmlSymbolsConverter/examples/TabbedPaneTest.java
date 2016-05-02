package com.xmlSymbolsConverter.examples;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.xmlSymbolsConverter.components.TabbedPane;

public class TabbedPaneTest extends JFrame implements Runnable{

	/**
	 * @param args
	 */
	public TabbedPaneTest()
	{
		setLocation(300,300);
		setSize(700,500);
		setLayout(new BorderLayout());
		TabbedPane tabbedPane = new TabbedPane();
		
		tabbedPane.addTab("new tab 1");
		tabbedPane.addTab("new tab 2");
		tabbedPane.addTab("new tab 3");
		setVisible(true);
		
		add(tabbedPane,"Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Thread th;
		th=new Thread(this);
		th.start();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TabbedPaneTest test = new TabbedPaneTest();
	}


	public void run() {
		// TODO Auto-generated method stub
		
	}

}
