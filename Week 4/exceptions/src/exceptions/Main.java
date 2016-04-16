/*
 * Main.java
 *
 * Created on September 20, 2007, 8:22 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package exceptions;

/**
 *
 * @author evansrb1
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String string1 = "5";
        String string2 = "Five";
        String string3 = "5.5";
        
        // first way to handle exception.  Since this is a runtime exception, 
        // you don't have to use a try-catch, so you can just assume it works.  In *some*
        // cases, this is okay if you can be positive all inputs are valid
        System.out.println("case 1");
        int x = Integer.parseInt(string1);
        System.out.println("Parsing the String " + "\"" + string1 + "\", it's value is " + x);
        System.out.println();
        
        // second way to handle exception, surround it in try-catch
        System.out.println("case 2");
        try {
            int y = Integer.parseInt(string1);
            System.out.println("Parsing the String " + "\"" + string1 + "\", it's value is " + y);
        } catch (NumberFormatException nfe) {
            System.err.println("Unable to parse the String " + "\"" + string1 + "\"");
        }
        System.out.println();

        // now that we are using a try-catch, let's give it some bad input'
        System.out.println("case 3");
        try {
            int z = Integer.parseInt(string2);
            System.out.println("Parsing the String " + "\"" + string2 + "\", it's value is " + z);
        } catch (NumberFormatException nfe) {
            System.out.println("Unable to parse the String " + "\"" + string2 + "\"");
        }
        System.out.println();        
        
        // now that we are using a try-catch, let's give it some bad input'
        System.out.println("case 4");
        try {
            int zz = Integer.parseInt(string3);
            System.out.println("Parsing the String " + "\"" + string3 + "\", it's value is " + zz);
        } catch (NumberFormatException nfe) {
            // maybe the user passed a double, try that instead and then convert it to an int
            try {
                double tmp1 = Double.parseDouble(string3);
                System.out.println("The input " + "\"" + string3 + "\" is a double, converting the String " + "\"" + string3 + "\" to an int");
                int tmp2 = (int)tmp1;
                System.out.println("The value of the string is now " + tmp2);
            } catch (NumberFormatException mfe) {
                System.err.println("Unable to parse the String " + "\"" + string3 + "\"");
            }
        }
        System.out.println();        
    }
}
