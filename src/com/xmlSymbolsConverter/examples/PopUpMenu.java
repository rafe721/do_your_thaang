package com.xmlSymbolsConverter.examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class PopUpMenu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JPopupMenu popMenu;
	JMenuItem cut;
	JMenuItem copy;

	public PopUpMenu() {

	    setVisible(true);
	    setSize(300, 300);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    panel = new JPanel();
	    popMenu = new JPopupMenu();
	    cut = new JMenuItem("Cut");
	    popMenu.add(cut);
	    copy = new JMenuItem("Copy");
	    popMenu.add(copy);

	    add(panel);
	    panel.setComponentPopupMenu(popMenu);

	    addMouseListener(new MouseAdapter() {
	        public void mouseReleased(MouseEvent Me) {
	            if (Me.isPopupTrigger()) {
	                popMenu.show(Me.getComponent(), Me.getX(), Me.getY());
	            }
	        }
	    });

	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public static void main(String[] args) {

	    Runnable r = new Runnable() {
	        public void run() {
	            PopUpMenu pop = new PopUpMenu();
	        }
	    };
	    SwingUtilities.invokeLater(r);

	}

}

