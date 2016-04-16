/*
 * TestThread.java
 * 
 * Created on Nov 2, 2007, 11:15:42 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

/**
 *
 * @author evansrb1
 */
public class TestThread extends Thread {

    private final String label;
    private final long delay;
    private final int repetitions;

    public TestThread(String label, long delay, int repetitions) {
        super();
        this.label = label;
        this.delay = delay;
        this.repetitions = repetitions;
    }

    public void run() {
        int i = 0;
        while (i < repetitions) {
            System.out.println(label + " repetition " + i);
            i++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ie) {
                System.out.println(label + " interrupted");
                break;
            }
        }
        System.out.println(label + " Thread ended");
     }
}