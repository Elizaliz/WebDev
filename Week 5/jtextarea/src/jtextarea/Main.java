/*
 * Main.java
 *
 * Created on September 28, 2007, 11:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jtextarea;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

class Main extends JFrame implements ActionListener {

    private final JButton btn = new JButton("Print...");
    private final JPanel btnPnl = new JPanel();
    private final JTextArea area = new JTextArea(25, 80);
    public Main()    {
	setTitle( "Text Area Application" );
	setBackground( Color.gray );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	area.setLineWrap(true);
	area.setWrapStyleWord(true);
	add( area, BorderLayout.CENTER );
	btnPnl.add(btn);
        btn.addActionListener(this);
	add(btnPnl, BorderLayout.SOUTH);
	
	// Load a file into the text area, catching any exceptions
	try {
            File file = new File(getClass().getResource("build.xml").toURI());
	    FileReader fileStream = new FileReader( file );
	    area.read( fileStream, "build.xml" );
    	} catch( FileNotFoundException e ) {
	    System.out.println( "File not found" );
    	} catch( IOException e ) {
    	    System.out.println( "IOException occurred" );
    	} catch (URISyntaxException urse) {
            System.out.println("URI syntax error");
        }
    }
    
    public void actionPerformed(ActionEvent evt) {
        try {
            area.print();
        } catch (java.awt.print.PrinterException pe) {
            System.err.println("Couldn't print!");
        }
    }
    public static void main( String args[] )
    {
	// Create an instance of the test application
	final Main mainFrame	= new Main();
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Runnable showFrame = new Runnable() {
		public void run() {
		    mainFrame.pack();
		    mainFrame.setVisible(true);
		}
	    };
	SwingUtilities.invokeLater(showFrame);
    }
}

