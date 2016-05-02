package com.xmlSymbolsConverter.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import com.xmlSymbolsConverter.components.StatusBar;
import com.xmlSymbolsConverter.components.TabbedTextPanel;
import com.xmlSymbolsConverter.examples.ButtonTabComponent;
import com.xmlSymbolsConverter.util.HTMLEntityResolver;
import com.xmlSymbolsConverter.util.XMLLanguageFormatter;

public class XSCController extends JFrame implements ActionListener, Runnable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	JMenuBar menuBar;
	
	JMenu fileMenu;
	JMenuItem newAction;
	JMenuItem openAction;
	JMenuItem saveAction;
	JMenuItem exitAction;
	
	JMenu editMenu;
	JMenuItem cutAction;
	JMenuItem copyAction;
	JMenuItem pasteAction;
	JMenuItem convertAction;
	
	JMenu formatMenu;
	JMenuItem fontAction;
	
	JMenu languageMenu;
	JMenuItem xmlAction;
	
	ButtonTabComponent aButtonTab;
	JTabbedPane tabbedPane;
	JScrollPane scrollPane;
	
	JFileChooser fileChooser;
	
	StatusBar statusBar;
	
	
	int tabCount = 1;

	
	
	public XSCController()
	{
		super("Do your thaang,.. :)");
		this.setLocation(200, 200);
		this.setSize(800,500);
		
		initMenu();
		
		this.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		TabbedTextPanel textPanel = new TabbedTextPanel(); 
//		System.out.println("tabCount : "+tabCount);
		tabbedPane.addTab("new page #"+tabCount++,textPanel);
		initTabComponent();
		this.add(tabbedPane, "Center");
		
		statusBar = new StatusBar();
		this.add(statusBar, "South");
		
		
		
		fileChooser = new JFileChooser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		Thread th;
		th = new Thread();
		th.start();

	}
	
	public void initMenu()
	{
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		newAction =   new JMenuItem("New");
		openAction =  new JMenuItem("Open");
		saveAction =  new JMenuItem("save");
		exitAction =  new JMenuItem("Exit");
		
		fileMenu.add(newAction);
		fileMenu.addSeparator();
		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		fileMenu.addSeparator();
		fileMenu.add(exitAction);

		menuBar.add(fileMenu);
		
		editMenu = new JMenu("Edit");
		cutAction =   new JMenuItem("Cut");
		copyAction =  new  JMenuItem("Copy");
		pasteAction =  new JMenuItem("Paste");
		convertAction = new JMenuItem("Convert");

		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		editMenu.addSeparator();
		editMenu.add(convertAction);
		
		menuBar.add(editMenu);
		
		formatMenu = new JMenu("Format");
		fontAction =   new JMenuItem("Font");
		
		formatMenu.add(fontAction);
		
		menuBar.add(formatMenu);
		
		languageMenu = new JMenu("Language");
		xmlAction =   new JMenuItem("xml");
		
		languageMenu.add(xmlAction);
		
		menuBar.add(languageMenu);
		
		newAction.addActionListener(this);
		openAction.addActionListener(this);
		saveAction.addActionListener(this);
		exitAction.addActionListener(this);
		
		cutAction.addActionListener(this);
		copyAction.addActionListener(this);
		pasteAction.addActionListener(this);
		convertAction.addActionListener(this);
		
		fontAction.addActionListener(this);
		
		xmlAction.addActionListener(this);
		
	}
	
	public void actionPerformed(final ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource().equals(newAction))
		{			
			
			TabbedTextPanel textPanel = new TabbedTextPanel(); 
			
//			System.out.println("tabCount : "+tabCount);
			
			tabbedPane.addTab("new page #"+tabCount++,textPanel);
			initTabComponent();
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
		}
		else if(e.getSource().equals(openAction))
		{
			int returnValue = fileChooser.showOpenDialog(XSCController.this);
			
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				JTextArea textArea = new JTextArea();
				//This is where the application opens the file.
				System.out.println("Opening: " + file.getName() + ".\n");
				try {
					FileInputStream fileInput = new FileInputStream(file);
					DataInputStream in = new DataInputStream(fileInput);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					textArea.setText("");
					String strLine;
					//Read File Line By Line
					while ((strLine = br.readLine()) != null)   {
						// Print the content on the console
						textArea.append(strLine+"\n");
					}
					//Close the input stream
					in.close();
					
					TabbedTextPanel textPanel = new TabbedTextPanel(); 
					((JTextArea)textPanel.getTextArea()).setText(textArea.getText());
					tabbedPane.addTab(file.getName(),textPanel);
					initTabComponent();
					tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {                 
				//user Cancels open Action             
			}             
			
		}
		else if(e.getSource().equals(saveAction))
		{
			int returnVal = fileChooser.showSaveDialog(XSCController.this);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				TabbedTextPanel aTextPanel = (TabbedTextPanel)tabbedPane.getSelectedComponent();
				JTextArea textArea = aTextPanel.getTextArea();
				//This is where a real application would save the file.
				System.out.println("Saving: " + file.getName() + ".\n");   
				// if file doesnt exists, then create it
					try {
						
						file.createNewFile();
						
						FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fileWriter);
						
						String text = textArea.getText();
						int totalLines = textArea.getLineCount();
						for (int i=0; i < totalLines; i++) 
						{
							int start = textArea.getLineStartOffset(i);
							int end = textArea.getLineEndOffset(i);
							String line = text.substring(start, end);

							bw.write(line);
						}
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	 
				tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), file.getName());
				
				
				
				}
			else
			{
//				System.out.println("Save command cancelled by user.\n"); 
			}
		}
		else if(e.getSource().equals(exitAction))
		{
			System.exit(0);
		}
		else if(e.getSource().equals(cutAction))
		{
			TabbedTextPanel atextPanel = (TabbedTextPanel) tabbedPane.getSelectedComponent();
			//System.out.println(atextPanel.getTextArea().getSelectedText());
			//atextPanel.getTextArea().replaceSelection("");
			atextPanel.getTextArea().cut();
			//textArea.replaceSelection("");
		
		}
		else if(e.getSource().equals(copyAction))
		{
			TabbedTextPanel atextPanel = (TabbedTextPanel) tabbedPane.getSelectedComponent();
			atextPanel.getTextArea().copy();
//			System.out.println(textArea.getSelectedText());
		}
		else if(e.getSource().equals(pasteAction))
		{
			TabbedTextPanel atextPanel = (TabbedTextPanel) tabbedPane.getSelectedComponent();
			atextPanel.getTextArea().paste();
			//System.exit(0);
		}
		else if (e.getSource().equals(convertAction))
		{
			
			TabbedTextPanel atextPanel = (TabbedTextPanel) tabbedPane.getSelectedComponent();
			
			String temp = atextPanel.getTextArea().getText();
			temp = HTMLEntityResolver.resolveAllEntities(temp);
			atextPanel.getTextArea().setText(temp);
			JOptionPane.showMessageDialog(this,"The convertion has been successful");
		}
		else if (e.getSource().equals(fontAction))
		{
			
			//do nothing :) not yet defined
		}
		else if (e.getSource().equals(xmlAction))
		{
			TabbedTextPanel atextPanel = (TabbedTextPanel) tabbedPane.getSelectedComponent();
			
			String temp = atextPanel.getTextArea().getText();
			temp = HTMLEntityResolver.resolveAllEntities(temp);
			atextPanel.getTextArea().setText(XMLLanguageFormatter.formatTextAsXML(temp));
			JOptionPane.showMessageDialog(this,"The Formatting has been successful");
		}
		 
		
	}
	
	public static void main(String args[])
	{
		XSCController x = new XSCController();
		
		try {
		      UIManager.setLookAndFeel(new WindowsLookAndFeel());
		    } catch (Exception e) {

		    }
	}
	public void run() {
		// TODO Auto-generated method stub
		
	}

	private void initTabComponent() {
		int i = tabbedPane.getTabCount();
			tabbedPane.setTabComponentAt(i-1,
                 new ButtonTabComponent(tabbedPane));
    }
	
}
