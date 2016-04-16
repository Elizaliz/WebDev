/*
 * Main.java
 *
 * Created on September 27, 2007, 11:33 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package borderlayout;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame{
    
    /** Creates a new instance of Main */
    public Main() {
        super("BorderLayout");
        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("West"), BorderLayout.WEST);
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("Center"), BorderLayout.CENTER);
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
