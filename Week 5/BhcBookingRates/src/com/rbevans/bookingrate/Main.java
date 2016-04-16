/*
 * Main.java
 *
 * Created on September 23, 2007, 3:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.rbevans.bookingrate;
import com.rbevans.bookingrate.Rates.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.text.*;
import javax.swing.plaf.synth.*;
        

/**
 *
 * @author evansrb1
 */
public class Main extends JFrame implements ActionListener {
    
    public class MyMouseListener implements MouseListener {
        
        // a mouse click is a mouse press AND a mouse release
        public void mouseClicked(MouseEvent e) {
//            Object src = e.getSource();
//            if (src == Main.this) {
//                statusLbl.setText("Mouse clicked at " + e.getPoint());
//            } else if (src == SubmitButton ) {
//                //statusLbl.setText("Submit Button Mouse Click");
//            }
        }

        public void mouseEntered(MouseEvent e) {
//            Object src = e.getSource();
//            if (src == Main.this) {
//                statusLbl.setText("Mouse Entered Main Window ");
//            } else if (src == helloBtn ) {
//                statusLbl.setText("Mouse Entered Hello World Button");
//            } else if (src == exitBtn ) {
//                statusLbl.setText("Mouse Entered Exit Button");                
//            }
        }

        public void mouseExited(MouseEvent e){
//            Object src = e.getSource();
//            if (src == Main.this) {
//                statusLbl.setText("Mouse Exited Main Window ");
//            } else if (src == helloBtn ) {
//                statusLbl.setText("Mouse Exited Hello World Button");
//            } else if (src == exitBtn ) {
//                statusLbl.setText("Mouse Exited Exit Button");                
//            }
        }

        public void mousePressed(MouseEvent e) {
//            Object src = e.getSource();
//            if (src == Main.this) {
//                statusLbl.setText("Mouse Press in Main Window at " + e.getPoint());
//            } else if (src == helloBtn ) {
//                statusLbl.setText("Mouse Press in Hello World Button at " + e.getPoint());
//            } else if (src == exitBtn ) {
//                statusLbl.setText("Mouse Press in Exit Window at " + e.getPoint());
//            }
        }

        public void mouseReleased(MouseEvent e)  {
//            Object src = e.getSource();
//            if (src == Main.this) {
//                statusLbl.setText("Mouse Release in Main Window at " + e.getPoint());
//            } else if (src == helloBtn ) {
//                statusLbl.setText("Mouse Release in Hello World Button at " + e.getPoint());
//            } else if (src == exitBtn ) {
//                statusLbl.setText("Mouse Release in Exit Window at " + e.getPoint());
//            }
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
    
//    JRadioButton durationButton1;
//    JRadioButton durationButton2;
//    JRadioButton durationButton3;
//    ButtonGroup dbg = new ButtonGroup(); 
    
    private final JButton SubmitButton = new JButton("Submit");
    private final JLabel date = new JLabel("Date (YYYY/MM/DD): ");
    private JFormattedTextField formattedField;
    private MaskFormatter mask;
    private MaskFormatter mask2;
    private final JLabel duration = new JLabel("Duration (days): ");
    private JFormattedTextField formattedFieldDuration;
    private final JLabel statusLbl = new JLabel("Welcome! Please enter start date and duration of your trip!", JLabel.CENTER);
      
    private HIKE hike = HIKE.GARDINER;
    /** Creates a new instance of Main */
    public Main() {
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

        //pack();
        setVisible(true);
    }
    
    
    // the actionPerformed method that we are required to implement, since
    // we said that Main implements ActionListener
    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == trailButton1) {
            hike = HIKE.GARDINER;
        }
        if (src == trailButton2) {
            hike = HIKE.HELLROARING;
        }
        if (src == trailButton3) {
            hike = HIKE.BEATEN;
        }
        if (src == SubmitButton) {
            String dateInput = formattedField.getText();
            String[] tokens = dateInput.split("/");
            int dateYear = Integer.parseInt(tokens[0]);
            int dateMonth = Integer.parseInt(tokens[1]);
            int dateDay = Integer.parseInt(tokens[2]);
            BookingDay today = new BookingDay(2016, 02, 26); //today's date
            BookingDay bookStartDay = new BookingDay(dateYear, dateMonth, dateDay);
            
            String durationInput = formattedFieldDuration.getText();
            int durationDays = Integer.parseInt(durationInput);
            
            Rates rates = new Rates(hike);
            rates.setBeginDate(bookStartDay);
            boolean success = rates.setDuration(durationDays);
            
            if (rates.isValidDates()) {
                System.out.println("Cost of trip = " + rates.getCost());
                System.out.println("Weekdays: " + rates.getNormalDays());
                System.out.println("Weekends: " + rates.getPremiumDays());  
                statusLbl.setText("Total cost of trip = " + rates.getCost()); 
            } else {
                System.out.println("Sorry, but " + rates.getDetails());
            }           
            
            if (bookStartDay.isValidDate() && bookStartDay.after(today) && rates.isValidDates()){
                //statusLbl.setText("Valid Date:)");     
                statusLbl.setText("Total cost of trip, with " + rates.getNormalDays()+ " weekday(s) and " + rates.getPremiumDays() + " weekend day(s), is $" + rates.getCost());
            }
            else if (!bookStartDay.isValidDate() || !bookStartDay.after(today)){
                statusLbl.setText("Invalid Date, please enter again.");      
            }
            else if (!rates.isValidDates()){
                statusLbl.setText("Invalid Date: " + rates.getDetails());      
            }
            
            
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
