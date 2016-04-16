/*
 * Main.java
 *
 * Created on September 23, 2007, 3:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.rbevans.bookingrate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.text.*;
import javax.swing.plaf.synth.*;
import java.io.*;
import java.net.*;
        

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame implements ActionListener {
    
    public class MyMouseListener implements MouseListener {
        
        // a mouse click is a mouse press AND a mouse release
        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e){

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e)  {

        }
    }

    // Here is were we define some of our Swing components
    
    // and lastly, we'll keep a reference to the myMouseListener
    private final MyMouseListener myMouseListener;
    
    // the GraphicsPanel is the object where the drawing is going on,
    // the JFrame will just contain this panel
    //private final JPanel panel = new GraphicsPanel();
    JPanel TrailPanel;
    JPanel SubmitPanel;
    JPanel StartDatePanel;
    JPanel DurationPanel;
    
    JRadioButton trailButton1;
    JRadioButton trailButton2;
    JRadioButton trailButton3;
    ButtonGroup bg = new ButtonGroup();
    
    private final JButton SubmitButton = new JButton("Submit");
    private final JLabel date = new JLabel("Date (YYYY/MM/DD): ");
    private JFormattedTextField formattedField;
    private MaskFormatter mask;
    private MaskFormatter mask2;
    private final JLabel duration = new JLabel("Duration (days): ");
    private JFormattedTextField formattedFieldDuration;
    private final JLabel statusLbl = new JLabel("Welcome! Please enter start date and duration of your trip!", JLabel.CENTER);
      
    //private HIKE hike = HIKE.GARDINER;
    String trail = "0";
    
    /** Creates a new instance of Main */
    public Main() throws IOException{
       // make a mouse listener
        super("Plan Your Trip with Beartooth Hiking Company!");
        myMouseListener = new MyMouseListener();
        addMouseListener(myMouseListener);
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel") ;
        } catch (Exception e) {
	    System.out.println("Error setting native look and feel: " + e) ;
	}
        
        SwingUtilities.updateComponentTreeUI(this);
        
        //first load the mask format
        try {
            mask = new MaskFormatter("####/##/##");
            //mask.setPlaceholder("YYYY/MM/DD");
            formattedField = new JFormattedTextField(mask);
            formattedField.setFont(new Font("monospaced", Font.PLAIN, 12));
        } catch (ParseException pe) {
            System.err.println("Couldn't parse MaskFormatter field");
            System.exit(0);
        }
        
        //first load the mask format
        try {
            mask2 = new MaskFormatter("#");
            //mask.setPlaceholder("YYYY/MM/DD");
            formattedFieldDuration = new JFormattedTextField(mask2);
            formattedFieldDuration.setFont(new Font("monospaced", Font.PLAIN, 12));
        } catch (ParseException pe) {
            System.err.println("Couldn't parse MaskFormatter field");
            System.exit(0);
        }
                
        TrailPanel = new JPanel();
        SubmitPanel = new JPanel();
        StartDatePanel = new JPanel();
        DurationPanel = new JPanel();
    
        setSize(750, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //do I want to have something else handle that?
        
        trailButton1 = new JRadioButton("Gardiner Lake Trail", true);
        trailButton2 = new JRadioButton("Hellroaring Plateau Lake");        
        trailButton3 = new JRadioButton("Beaten Path"); 
        bg.add(trailButton1);
        bg.add(trailButton2);
        bg.add(trailButton3);
        
        TrailPanel.add(trailButton1);
        TrailPanel.add(trailButton2);
        TrailPanel.add(trailButton3);
        StartDatePanel.add(date);
        StartDatePanel.add(formattedField);
        DurationPanel.add(duration);
        DurationPanel.add(formattedFieldDuration);
        SubmitPanel.add(SubmitButton);    
        
        trailButton1.addActionListener(this);
        trailButton2.addActionListener(this);
        trailButton3.addActionListener(this);
        SubmitButton.addActionListener(this);
        SubmitButton.addMouseListener(myMouseListener);
        
        getContentPane().add(TrailPanel, BorderLayout.NORTH);             
        getContentPane().add(StartDatePanel, BorderLayout.WEST);
        getContentPane().add(DurationPanel, BorderLayout.CENTER);  
        getContentPane().add(statusLbl, BorderLayout.EAST);
        getContentPane().add(SubmitPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    // the actionPerformed method that we are required to implement, since
    // we said that Main implements ActionListener
    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == trailButton1) {
            trail = "0";
        }
        if (src == trailButton2) {
            trail = "1";
        }
        if (src == trailButton3) {
            trail = "2";
        }
        if (src == SubmitButton) {
            
            String dateInput = formattedField.getText();
            String[] tokens = dateInput.split("/");
            String dateYear = tokens[0];
            String dateMonth = tokens[1];
            if (dateMonth.startsWith("0"))
            {
                dateMonth = dateMonth.substring(1);
            }
            String dateDay = tokens[2];
            if (dateDay.startsWith("0"))
            {
                dateDay = dateDay.substring(1);
            }
            String durationInput = formattedFieldDuration.getText();
            String output = trail + ":" + dateYear + ":" + dateMonth + ":" + dateDay + ":" + durationInput;
            connect("128.220.101.240", 20025, output);//"1:2008:7:1:4"
        }              
    }
    
    public void connect(String host, int port, String output) {
        try {
            Socket client = new Socket(host, port);
            handleConnection(client, output);
            close(client);
        } catch (UnknownHostException uhe) {
            System.out.println("Unknown host: " + host);
            uhe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IOException on: " + host);
            ioe.printStackTrace();
        }
    }
    
    public void close(Socket client) throws IOException {
        if (client != null) client.close();
    }
    
    protected void handleConnection(Socket classSocket, String output) throws IOException {
        String line;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(classSocket.getInputStream()));
            out = new PrintWriter(classSocket.getOutputStream(), true);
            out.println(output);
            while ((line=in.readLine()) != null && line.length() != 0) {
                if (line.startsWith("-0.01"))
                {
                    //System.out.println("Error! " + line.substring(6));
                    statusLbl.setText("Error! " + line.substring(6));
                }
                else
                {
                    //System.out.println("Success! " + line);
                    statusLbl.setText("Success! " + line);
                }
            }
        } catch (IOException ioe) {
            System.err.println("Problem in communicating with socket: " + ioe.getMessage());
            statusLbl.setText("Error! " + ioe.getMessage());
        } finally {
            if (out != null) out.close();
            if (in != null) in.close();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        new Main();
    }
}
