import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Driver {
    public class Driver {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        double[] c1 = { 6, 0, 0, 5 };
        int[] e1 = { 0, 1, 2, 3 };
        Polynomial p1 = new Polynomial(c1, e1);
        double[] c2 = { 0, -2, 0, 0, -9 };
        int[] e2 = { 0, 1, 2, 3, 4 };
        Polynomial p2 = new Polynomial(c2, e2);
        Polynomial s = p1.add(p2);
        System.out.println("s(0.1) = " + s.evaluate(0.1));
        if (s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");
        
        //Lab2 tests:
        double[] c3 = {5, -2, -3, 0};
        in[] e3 = {0, 1, 2, 4};
        Polynomial p3 = new Polynomial(c3, e3);
       
        double[] c4 = { 99, 1 };
        int[] e4 = { 0, 2 };
        Polynomial p4 = new Polynomial(c4, e4);
        
        System.out.println("/////// LAB 2 TESTS //////////");
        System.out.println("Recieved: " + Arrays.toString(p1.coef) + "  " + Arrays.toString(p1.exp));
        System.out.println("Expected: [6.0, 5.0]  [0, 3]");
        System.out.println();
        System.out.println("Recieved: " + Arrays.toString(p3.coef) + "  " + Arrays.toString(p3.exp));
        System.out.println("Expected: [5.0, -2.0, -3.0]  [0, 1, 2, 4]");
        System.out.println();
        
        System.out.println("ADD TEST:");
        Polynomial sum = p4.add(p3);
        System.out.println("Received: " + Arrays.toString(sum.coef) + "  " + Arrays.toString(sum.exp));
        System.out.println("Expected: [104.0, -2.0, -2.0]  [0, 1, 2]");
        System.out.println();
        
        Polynomial sum = p3.add(p4);
        System.out.println("Received: " + Arrays.toString(sum.coef) + "  " + Arrays.toString(sum.exp));
        System.out.println("Expected: [104.0, -2.0, -2.0]  [0, 1, 2]");
        System.out.println();
        
        System.out.println("MULTIPLY TEST:");
        Polynomial product1 = p3.multiply(p4);
        System.out.println("Received: " + Arrays.toString(product1.coef) + "  " + Arrays.toString(product1.exp));
        System.out.println("Expected: [495.0, -198.0, -292.0, -2.0, -3.0]  [0, 1, 2, 3, 4]");
        System.out.println();
        
        Polynomial product2 = p4.multiply(p3);
        System.out.println("Received: " + Arrays.toString(product1.coef) + "  " + Arrays.toString(product1.exp));
        System.out.println("Expected: [495.0, -198.0, -292.0, -2.0, -3.0]  [0, 1, 2, 3, 4]");
        System.out.println();
    }
}
