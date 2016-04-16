/*
 * GraphicsPanel.java
 *
 * Created on September 23, 2007, 3:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package awtgraphics;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author evansrb1
 */
public class GraphicsPanel extends JPanel {
    // the font which we will use
    Font font = new Font("Sans Serif", Font.BOLD, 24);
    // holder for the url of the image
    URL url = null;
    // holder for the image itself
    BufferedImage bi = null;
    
    /** Creates a new instance of GraphicsPanel */
    public GraphicsPanel() {
        // call superclass constructor, use null as a layout manager 
        // (we don't need it for this example)'
        super(null);
        // set the preferred size of the JPanel, so pack() in JFrame will work!
        setPreferredSize(new Dimension(500, 300));
        // get the image url 
        url = getClass().getResource("duke.gif");
        // load the image
        try {
            bi = ImageIO.read(url);
        } catch (IOException ioe) {
            System.err.println("Couldn't open duke.gif " + ioe.getMessage());
        }
    }

    // this is the actuall method you should override to have painting occur
    // in the JPanel
    public void paintComponent(Graphics g) {
        // set the font
        g.setFont(font);
        // set the painting color to white
        g.setColor(Color.WHITE);
        // paint the inside of the rectangle
        g.fillRect(50, 50, 400, 200);
        // set the painting color to red
        g.setColor(Color.RED);
        // paint the outline of the rectangle
        g.drawRect(50, 50, 400, 200);
        // set the painting color to blue
        g.setColor(Color.BLUE);
        // draw the string to the panel
        g.drawString("Duke Says Hi!", 100, 150);
        // now draw the image to the panel
        g.drawImage(bi, 280, 75, this);
    }
}
