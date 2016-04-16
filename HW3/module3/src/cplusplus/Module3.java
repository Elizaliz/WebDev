/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cplusplus;

/**
 *
 * @author lizskerritt
 */
public class Module3 {
    
    public static int Multiply(int firstInteger, int secondInteger){
        return firstInteger * secondInteger;
    }
    
    public static void main(String[] args) {
        System.out.println("Assuming you have typed two integers you would like to multiply after the command");
        int firstInt = Integer.parseInt(args[0]);
        int secondInt = Integer.parseInt(args[1]);
        int multNumber = Multiply(firstInt, secondInt);
        
        System.out.print( firstInt + " multiplied by " + secondInt + " is: ");
        if (multNumber >= 0) {
            System.out.println(multNumber);
        
        }
        else if (multNumber < 0) {
            multNumber = Math.abs(multNumber);
            System.out.println("(" + multNumber + ")");
        }
    }
}
