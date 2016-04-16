/*
 * Main.java
 *
 * Created on September 28, 2007, 11:10 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package jtextfields;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.text.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame{
    private final JLabel jl1 = new JLabel("JTextField: ");
    private final JLabel jl2 = new JLabel("JPasswordField: ");
    private final JLabel jl3 = new JLabel("JFormattedTextField: ");
    private final JTextField textField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private MaskFormatter mask;
    private JFormattedTextField formattedField;
    private final GridBagConstraints gbc = new GridBagConstraints();
    
    /** Creates a new instance of Main */
    public Main() {
        super("Text Field example");
        setLayout(new GridBagLayout());

        //first load the mask format
        try {
            mask = new MaskFormatter("(###)###-####");
            formattedField = new JFormattedTextField(mask);
            formattedField.setFont(new Font("monospaced", Font.PLAIN, 12));
        } catch (ParseException pe) {
            System.err.println("Couldn't parse MaskFormatter field");
            System.exit(0);
        }
        
        // now let's make the panel
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.weightx = 0.0;
        add(jl1, gbc);
        add(jl2, gbc);
        add(jl3, gbc);

        gbc.gridx = 1;        
        gbc.gridy = 0;
        add(textField, gbc);
        gbc.gridy = GridBagConstraints.RELATIVE;        
        add(passwordField, gbc);
        add(formattedField, gbc);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
     }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
