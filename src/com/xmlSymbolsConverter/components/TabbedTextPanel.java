package com.xmlSymbolsConverter.components;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TabbedTextPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        JTextArea textArea;

        
        public TabbedTextPanel(){
        	textArea = new JTextArea();
        	textArea.setText("");
        	JScrollPane scrollPane = new JScrollPane(textArea);

        	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    		
    		setLayout(new GridLayout(1,1));
            
            add(scrollPane);
        }
        
    public TabbedTextPanel(String text){
    	textArea = new JTextArea(5, 20);
    	textArea.setText(text);
        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        
        add(scrollPane);
    }

    public JTextArea getTextArea() {
    	return textArea;
    }
}
