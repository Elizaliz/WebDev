/*
 * GraphicsPanel.java
 *
 * Created on September 23, 2007, 3:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package awtgraphics_2;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.net.*;
import java.awt.geom.*;
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
    Rectangle2D.Double rect = null;
    TexturePaint imagePaint = null;
    Ellipse2D.Double circle = new Ellipse2D.Double(40, 40, 200, 200);
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
            rect = new Rectangle2D.Double(0, 0, bi.getWidth()/2, bi.getHeight()/2);
            imagePaint = new TexturePaint(bi, rect);
        } catch (IOException ioe) {
            System.err.println("Couldn't open duke.gif " + ioe.getMessage());
        }
    }

    // this is the actuall method you should override to have painting occur
    // in the JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(imagePaint);
        g2d.fill(circle);
        g2d.setPaint(Color.BLACK);
        g2d.draw(circle);
    }
}
