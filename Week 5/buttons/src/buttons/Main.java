/*
 * Main.java
 *
 * Created on September 27, 2007, 3:08 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package buttons;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame{
    JPanel buttonPanel = new JPanel();
    JPanel checkboxPanel = new JPanel();
    JPanel radioPanel = new JPanel();
    
    JButton btn1;
    JButton btn2;
    JButton btn3;    
    
    JCheckBox cbtn1;
    JCheckBox cbtn2;
    JCheckBox cbtn3;    
    
    JRadioButton rbtn1;
    JRadioButton rbtn2;
    JRadioButton rbtn3;
    JRadioButton rbtn4;    
    
    ButtonGroup bg = new ButtonGroup();
    
    /** Creates a new instance of Main */
    public Main() {
        super("Buttons");
        setLayout(new GridLayout(1, 0, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn1 = new JButton("Text");
        btn2 = new JButton("Duke", new ImageIcon(getClass().getResource("duke-standing.gif")));
        btn3 = new JButton("<html>HTML<br>button</html>");
        buttonPanel.setBorder(BorderFactory.createTitledBorder("JButtons"));
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.anchor = GridBagConstraints.WEST;
        gbc1.gridx = 0;
        gbc1.gridy = GridBagConstraints.RELATIVE;
        gbc1.insets = new Insets(5, 5, 5, 5);
        gbc1.weightx = 1.0;                
        buttonPanel.add(btn1, gbc1);
        buttonPanel.add(btn2, gbc1);
        buttonPanel.add(btn3, gbc1);        
    
        cbtn1 = new JCheckBox("Text");
        cbtn2 = new JCheckBox("Duke", new ImageIcon(getClass().getResource("duke-standing.gif")));
        cbtn2.setSelectedIcon(new ImageIcon(getClass().getResource("duke_wave.gif")));
        checkboxPanel.setBorder(BorderFactory.createTitledBorder("JCheckBox Buttons"));
        checkboxPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = GridBagConstraints.RELATIVE;
        gbc2.insets = new Insets(5, 5, 5, 5);
        gbc2.anchor = GridBagConstraints.WEST;
        gbc2.weightx = 1.0;
        checkboxPanel.add(cbtn1, gbc2);
        checkboxPanel.add(cbtn2, gbc2);        
        
        rbtn1 = new JRadioButton("Eenie", true);
        rbtn2 = new JRadioButton("Meenie");        
        rbtn3 = new JRadioButton("Miney");                
        rbtn4 = new JRadioButton("Moe");                        
        bg.add(rbtn1);
        bg.add(rbtn2);
        bg.add(rbtn3);
        bg.add(rbtn4);        
        radioPanel.setBorder(BorderFactory.createTitledBorder("JRadioButtons"));

        radioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = GridBagConstraints.RELATIVE;
        gbc3.insets = new Insets(5, 5, 5, 5);
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.weightx = 1.0;
        radioPanel.add(rbtn1, gbc3);
        radioPanel.add(rbtn2, gbc3);
        radioPanel.add(rbtn3, gbc3);
        radioPanel.add(rbtn4, gbc3);
        add(buttonPanel);
        add(checkboxPanel);
        add(radioPanel);
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
