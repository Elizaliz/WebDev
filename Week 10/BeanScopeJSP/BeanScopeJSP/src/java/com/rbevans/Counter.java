/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

/**
 *
 * @author evansrb1
 */
public class Counter {
    private int numTimesVisited = 0;

    public int getNumTimesVisited() {
        return numTimesVisited;
    }

    public void setNumTimesVisited(int numTimesVisited) {
        this.numTimesVisited = numTimesVisited;
    }
    
    public void setIncrementNumTimesVisited(int num) {
        numTimesVisited = numTimesVisited + num;
    }

}
