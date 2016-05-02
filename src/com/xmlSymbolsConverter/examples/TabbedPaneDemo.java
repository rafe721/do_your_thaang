package com.xmlSymbolsConverter.examples;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rahul
 */
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;


public class TabbedPaneDemo extends JFrame implements Runnable {

    public void run() {
        
    }

    static class TextDemoPanel extends JPanel{
        private JTextArea textArea;

        public TextDemoPanel(String text){
            textArea = new JTextArea(5, 20);
            textArea.setText(text);
            JScrollPane scrollPane = new JScrollPane(textArea);

            add(scrollPane);
        }

        public JTextArea getTextArea() {
            return textArea;
        }
    }
    
    static class SetTextAction extends AbstractAction {
        private JTabbedPane tabbedPane;

        public SetTextAction(JTabbedPane tabbedPane){
            super("Set text");
            this.tabbedPane = tabbedPane;
        }

        public void actionPerformed(ActionEvent e) {
            String value = JOptionPane.showInputDialog(tabbedPane, "Text", "New text");
            if (value != null){
                TextDemoPanel panel = (TextDemoPanel)tabbedPane.getSelectedComponent();
                if (panel != null)
                    panel.getTextArea().setText(value);
            }
        }
    }

    private void createAndShowGUI() {
        

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Tab 1", new TextDemoPanel("Tab 1 text"));
        tabbedPane.addTab("Tab 2", new TextDemoPanel("Tab 2 text"));
        tabbedPane.addTab("Tab 3", new TextDemoPanel("Tab 3 text"));

        this.add(tabbedPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem item = new JMenuItem(new SetTextAction(tabbedPane));

        menu.add(item);

        setJMenuBar(menuBar);

        this.pack();
        setVisible(true);
        
        
    }

    public TabbedPaneDemo()
            {
                super("TabbedPaneDemo");
                
                setLocation(300,300);
                setSize(700,500);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                createAndShowGUI();
                Thread th;
                th = new Thread(this);
                th.start();
            }
    
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
        
        TabbedPaneDemo demo = new TabbedPaneDemo();
    }
}