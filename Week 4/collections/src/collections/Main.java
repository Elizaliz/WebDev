/*
 * Main.java
 *
 * Created on September 23, 2007, 10:38 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package collections;

import java.util.*;
/**
 *
 * @author evansrb1
 */
public class Main {
  
    // this is a test class that is effectively still just a String
    public static class Test {
        
        private final String name;
        
        public Test(String name) {
            if (name != null) {
                this.name=name;
            } else {
                this.name="Undefined";
            }
        }
        
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else {
                if (obj instanceof Test) {
                    return name==((Test)obj).name;
                } else {
                    return false;
                }
            }
        }

        public int hashCode() {
            return name.hashCode();
        }
        
        public String toString() {
            return name;
        }
        
        public String getName() {
            return name;
        }
    }
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Let's look at an example for each of the main type of collections
        // First let's look at a Set, in particular a HashSet
        HashSet hashSet = new HashSet();
        hashSet.add(new Test("One"));
        hashSet.add(new Test("Two"));
        hashSet.add(new Test("Three"));
        hashSet.add(new Test("Two"));
        
        // print out the contents, note the order and the fact that we only have one "Two"
        System.out.println("=============== HashSet ================");
        for (Object foo: hashSet) {
            System.out.println(foo.toString());
        }

        // ===============================================================
        // Same example as above except with using generics
        HashSet<Test> hashSet2 = new HashSet<Test>();
        hashSet2.add(new Test("One"));
        hashSet2.add(new Test("Two"));
        hashSet2.add(new Test("Three"));
        hashSet2.add(new Test("Two"));
        
        // print out the contents, note the order and the fact that we only have one "Two"
        System.out.println("=============== HashSet(Generics) ================");
        for (Test foo: hashSet2) {
            System.out.println(foo.toString());
        }

        // ===============================================================
        // Now let's look at an ArrayList, we'll use generics w/ this one'
        ArrayList<Test> arrayList = new ArrayList<Test>();
        arrayList.add(new Test("One"));
        arrayList.add(new Test("Two"));
        arrayList.add(new Test("Three"));
        arrayList.add(new Test("Two"));

        System.out.println("=============== ArrayList ================");
        for (Test foo: arrayList) {
            System.out.println(foo.toString());
        }

        // ===============================================================
        // Ah, the good old Vector class
        Vector<Test> vector = new Vector<Test>();
        vector.add(new Test("One"));
        vector.add(new Test("Two"));
        vector.add(new Test("Three"));
        vector.add(new Test("Two"));

        System.out.println("=============== Vector ================");
        for (Test foo: vector) {
            System.out.println(foo.toString());
        }
        
        // ===============================================================
        // Lastly, we'll look at an ArrayDeque
        ArrayDeque<Test> arrayDeque = new ArrayDeque<Test>();
        arrayDeque.addFirst(new Test("One"));
        arrayDeque.addFirst(new Test("Two"));        
        arrayDeque.addLast(new Test("Three"));
        arrayDeque.addLast(new Test("Two"));        
        
        System.out.println("=============== ArrayDeque ================");
        for (Test foo: arrayDeque) {
            System.out.println(foo.toString());
        }
        
    }
    
}
