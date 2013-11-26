package com.ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.controller.ActionController;


public class MainFrame extends JFrame{
	
	public String[] strArr = {"Letter1","Letter2","Letter3"};
	JList<String> letters;
	public MainFrame(){
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 initComponents();
	     pack();
	     setLocationRelativeTo(null);
	     setVisible(true);
	}

	protected void initComponents() {
		 if (!(getContentPane().getLayout() instanceof GridBagLayout)) {
             getContentPane().setLayout(new GridBagLayout());
		 }
		 letters = new JList<String>(strArr);
		letters.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				
				ActionController.getInstance().selectLetter(letters.getSelectedValue());
			}
		});		 
		 /*********/
		 letters.setFixedCellHeight(50);
		 letters.setFixedCellWidth(200);
		 letters.setFocusable(false);
		 
		 /*********/
		 this.add(letters);
     }
	
	public static void main(String[] args) {
		   javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    //Use the System look and feel
	                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

	                    Double jvmVersion = new Double(System.getProperty("java.specification.version"));
	                    if (jvmVersion.doubleValue() < 1.4) {
	                        JOptionPane.showMessageDialog(null, " Require Java 1.4 ", " Problem ", JOptionPane.ERROR_MESSAGE);
	                        System.exit(1);
	                     } else {
	                        new MainFrame();
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	}

}
