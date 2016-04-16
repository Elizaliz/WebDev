/*
 * Main.java
 *
 * Created on September 27, 2007, 10:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package lookandfeel;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.synth.*;
import java.text.*;

public class Main extends JFrame implements ActionListener {
  
    JButton motifBtn = new JButton("Motif");
    JButton winBtn = new JButton("Windows");
    JButton javaBtn = new JButton("Java");
    JButton nativeBtn = new JButton("Native");

    public Main() {
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        JMenu jm = new JMenu("File");
        JMenuItem jmi_1 = new JMenuItem("Save");
        JMenuItem jmi_2 = new JMenuItem("Save As");
        JMenuItem jmi_3 = new JMenuItem("Exit");
        jmb.add(jm);
        jm.add(jmi_1);
        jm.add(jmi_2);
        jm.add(jmi_3);
	getContentPane().setLayout(new BorderLayout());
	JPanel checkPanel = new JPanel();
	ButtonPanel buttons = new ButtonPanel();
	Border b = BorderFactory.createEtchedBorder();
	checkPanel.setBorder(BorderFactory.createTitledBorder(b, "Search options",
							      TitledBorder.TOP,
							      TitledBorder.CENTER));
	JCheckBox subDirs = new JCheckBox("Search subdirectories");
	subDirs.setMnemonic('S');
	JCheckBox ignoreCase = new JCheckBox("Ignore case");
	ignoreCase.setMnemonic('I');
	JCheckBox matchWords = new JCheckBox("Match whole words only");
	matchWords.setMnemonic('M');
	checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.Y_AXIS));
	checkPanel.add(subDirs);
	checkPanel.add(ignoreCase);
	checkPanel.add(matchWords);
	getContentPane().add(checkPanel, "West");
	
	JPanel radioPanel = new JPanel();
	radioPanel.setBorder(BorderFactory.createTitledBorder(b, "Save options", 
							      TitledBorder.TOP,
							      TitledBorder.CENTER));
	ButtonGroup grp = new ButtonGroup();
	JRadioButton autoSave = new JRadioButton("Save automatically");
	autoSave.setMnemonic('A');
	JRadioButton promptSave = new JRadioButton("Prompt before saving");
	promptSave.setMnemonic('P');
	JRadioButton requestSave = new JRadioButton("Save only when requested");
	requestSave.setMnemonic('R');
	radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
	radioPanel.add(autoSave);
	radioPanel.add(promptSave);
	radioPanel.add(requestSave);
	
	// Add the radio buttons to the button group
	grp.add(autoSave);
	grp.add(promptSave);
	grp.add(requestSave);
	
	autoSave.setSelected(true);
	getContentPane().add(radioPanel, "East");
	
	getContentPane().add(buttons, BorderLayout.SOUTH);
	winBtn.addActionListener(this);
	javaBtn.addActionListener(this);
	motifBtn.addActionListener(this);
	nativeBtn.addActionListener(this);
	
	addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent evt) {
		System.exit(0);
	    }
	});
	setTitle("Native Look and Feel");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	try {
	    if (o == nativeBtn) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setTitle("Native Look and Feel");
	    } else if (o == motifBtn) {
		UIManager.setLookAndFeel (
		"com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		setTitle("Motif Look and Feel");
	    } else if (o == winBtn) {
		UIManager.setLookAndFeel (
		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setTitle("Windows Look and Feel");
	    } else if (o == javaBtn) {
		UIManager.setLookAndFeel (
		"javax.swing.plaf.metal.MetalLookAndFeel");
		setTitle("Java Look and Feel");
            }
	    SwingUtilities.updateComponentTreeUI(this);
    	    pack();
	}catch (Exception ex) {
	    System.out.println("Ooops..." + ex.getMessage());
	}
    }


    public class ButtonPanel extends JPanel {
	public ButtonPanel() {
	setLayout(new GridLayout(1,0,4,4));
	add(motifBtn);
	add(winBtn);
	add(javaBtn);
	add(nativeBtn);
	}
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
        } catch (Exception e) {
	    System.out.println("Error setting native look and feel: " + e) ;
	}
	final Main f = new Main();
	Runnable showFrame = new Runnable() {
		public void run() {
		    f.pack();
		    f.setVisible(true);
	    }
	    };
	SwingUtilities.invokeLater(showFrame);
	
    }
}
