/*
 * Main.java
 * 
 * Created on Nov 2, 2007, 11:15:07 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author evansrb1
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Thread T1, every second
        Thread t1 = new TestThread("T1:", 1000, 5);
        // Thread T2, every 2 seconds
        Thread t2 = new TestThread("T2:", 2000, 5);
        // Thead T3, every 5 seconds
        Thread t3 = new TestThread("T3:", 5000, 5);
        // start the threads
        t1.start();
        t2.start();
        t3.start();
        try {
            // wait for t2 to finisih
            t2.join();
            // then interrupt t3 to watch what happens
            t3.interrupt();
        } catch (InterruptedException ie) {
            System.out.println("main: couldn't join and interrupt");
        }
    }
}
