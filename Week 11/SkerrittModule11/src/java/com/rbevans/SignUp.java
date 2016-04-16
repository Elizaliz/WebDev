    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rbevans;

import java.util.GregorianCalendar;

/**
 *
 * @author evansrb1
 */
public class SignUp {
    private String trail = null;
    private String details = null;
    private double cost = 0.0;
    private double normalDayRate = 0;
    private double premiumDayRate = 0;
    private int normalDays = 0;
    private int premiumDays = 0;
    private GregorianCalendar beginDate = null;
    private GregorianCalendar endDate = null;
    private int duration = 0;
    private int day = 0;
    private int month = 0;
    private int year = 0;
    private boolean success = false;
    
    public String getTrail() {
        return this.trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public GregorianCalendar getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(GregorianCalendar date) {
        this.beginDate = date;
    }
    
    public GregorianCalendar getEndDate() {
        return this.endDate;
    }

    public void setEndDate(GregorianCalendar date) {
        this.endDate = date;
    }   
 
    public int getNormalDays() {
        return this.normalDays;
    }

    public void setNormalDays(int days) {
        this.normalDays = days;
    } 
    
    public double getNormalDayRate() {
        return this.normalDayRate;
    }

    public void setNormalDayRate(double rate) {
        this.normalDayRate = rate;
    }

    public int getPremiumDays() {
        return this.premiumDays;
    }

    public void setPremiumDays(int days) {
        this.premiumDays = days;
    }
    
    public double getPremiumDayRate() {
        return this.premiumDayRate;
    }

    public void setPremiumDayRate(double rate) {
        this.premiumDayRate = rate;
    }
    
    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
    
    public void setDate(int month, int day, int year) {
        
        this.day = day;
        this.month = month;
        this.year = year;        
    }
    
    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean sucess) {
        this.success = success;
    }
}
