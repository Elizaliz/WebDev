/*
 * Main.java
 *
 * Created on September 25, 2007, 9:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package events;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author evansrb1
 */

// The Main class is a JFrame, and it implements the ActionListener interface,
// this means it has to implement the actionPerformed() method somewhere below...
// This is an example of the container of the component being the listener
public class Main extends JFrame implements ActionListener {
    
    // as a means of showing a seperate class being a container, I've included
    // MyMouseListener.  Note this is not a static class, nor is it in a 
    // different file.  Why not? (Hint: statusLbl)
    //
    // Since this class implements MouseListener, we'll need to implement all of 
    // of the MouseListener methods (see below)
    public class MyMouseListener implements MouseListener {
        
        // a mouse click is a mouse press AND a mouse release
        public void mouseClicked(MouseEvent e) {
            Object src = e.getSource();
            if (src == Main.this) {
                statusLbl.setText("Mouse clicked at " + e.getPoint());
            } else if (src == helloBtn ) {
                statusLbl.setText("Mouse clicked in Hello World Button");
            } else if (src == exitBtn ) {
                statusLbl.setText("Mouse clicked in Exit Button");                
            }
        }

        public void mouseEntered(MouseEvent e) {
            Object src = e.getSource();
            if (src == Main.this) {
                statusLbl.setText("Mouse Entered Main Window ");
            } else if (src == helloBtn ) {
                statusLbl.setText("Mouse Entered Hello World Button");
            } else if (src == exitBtn ) {
                statusLbl.setText("Mouse Entered Exit Button");                
            }
        }

        public void mouseExited(MouseEvent e){
            Object src = e.getSource();
            if (src == Main.this) {
                statusLbl.setText("Mouse Exited Main Window ");
            } else if (src == helloBtn ) {
                statusLbl.setText("Mouse Exited Hello World Button");
            } else if (src == exitBtn ) {
                statusLbl.setText("Mouse Exited Exit Button");                
            }
        }

        public void mousePressed(MouseEvent e) {
            Object src = e.getSource();
            if (src == Main.this) {
                statusLbl.setText("Mouse Press in Main Window at " + e.getPoint());
            } else if (src == helloBtn ) {
                statusLbl.setText("Mouse Press in Hello World Button at " + e.getPoint());
            } else if (src == exitBtn ) {
                statusLbl.setText("Mouse Press in Exit Window at " + e.getPoint());
            }
        }

        public void mouseReleased(MouseEvent e)  {
            Object src = e.getSource();
            if (src == Main.this) {
                statusLbl.setText("Mouse Release in Main Window at " + e.getPoint());
            } else if (src == helloBtn ) {
                statusLbl.setText("Mouse Release in Hello World Button at " + e.getPoint());
            } else if (src == exitBtn ) {
                statusLbl.setText("Mouse Release in Exit Window at " + e.getPoint());
            }
        }
    }

    // Here is were we define some of our Swing components
    private final JButton helloBtn = new JButton("Say Hello");
    private final JButton exitBtn = new JButton("Exit");
    private final JLabel statusLbl = new JLabel("Mouse has not been in window", JLabel.CENTER);
    private final JLabel helloLbl = new JLabel("", JLabel.CENTER);
    
    // and lastly, we'll keep a reference to the myMouseListener
    private final MyMouseListener myMouseListener;

    /** Creates a new instance of Main */
    public Main() {
        super("Event Window");
        // add the statusLbl to the top of the window
        getContentPane().add(statusLbl, BorderLayout.NORTH);
        
        // set the size of the JFrame
        setSize(500, 200);
        
        // make a mouse listener
        myMouseListener = new MyMouseListener();
        
        // turn off default behavior, we'll handle this ourselves
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // add a mouse listener.  We'll use an instance of the class above.'
        addMouseListener(myMouseListener);
        
        // use an anonymous class, extend WindowAdapter which implements WindowListener. 
        // The only method we are interested in here is the closing event.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                // if you need to access a method in the enclosing class, preface the method with the classname.this.
                Main.this.exit();
            }
        });

        // register the listeners we have with the components we want to watch.
        // Note that a single component can have multiple listeners.
        helloBtn.addActionListener(this);
        helloBtn.addMouseListener(myMouseListener);
        exitBtn.addActionListener(this);
        exitBtn.addMouseListener(myMouseListener);

        // This is just to put the buttons in a "pleasing layout"
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(helloBtn);
        buttonPanel.add(exitBtn);
        // add the buttons to the bottom of the panel
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // finally take care of the font of the hello label and put it in the
        // middle of the window
        helloLbl.setFont(new Font("Sans Serif", Font.PLAIN, 64));
        getContentPane().add(helloLbl, BorderLayout.CENTER);        
        
        // show the window
        setVisible(true);
    }
    
    // exit the application
    private void exit() {
        System.exit(0);
    }
    
    // the actionPerformed method that we are required to implement, since
    // we said that Main implements ActionListener
    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == helloBtn) {
            helloLbl.setText("Hello World!");
        } else if (src == exitBtn) {
            exit();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
    }
}
