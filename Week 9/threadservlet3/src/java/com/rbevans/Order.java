/*
 * Order.java
 * 
 * Created on Nov 4, 2007, 7:01:04 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.util.ArrayList;

/**
 *
 * @author evansrb1
 */
public class Order {
    private final int orderNumber;
    private final ArrayList<String> items = new ArrayList<String>();
    
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void add(String item) {
        items.add(item);
    }
    
    public int size() {
        return items.size();
    }
    
    public String getItem(int index) {
        return items.get(index);
    }
    
    public boolean hasOrderNum(int orderNum) {
        return orderNumber == orderNum;
    }
}
