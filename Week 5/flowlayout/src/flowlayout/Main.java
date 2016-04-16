/*
 * Main.java
 *
 * Created on September 27, 2007, 11:15 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package flowlayout;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame {
    
    /** Creates a new instance of Main */
    public Main() {
        super("Flow Layout");
        setLayout(new FlowLayout());
        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
        add(new JButton("Button 4"));
        add(new JButton("Button 5"));        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
