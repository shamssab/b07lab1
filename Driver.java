import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));

        double[] c1 = {6, 4, 5};
        int[] e1 = {0, 1, 3};
        Polynomial p1 = new Polynomial(c1, e1);

        double[] c2 = {-8, -2, 4};
        int[] e2 = {0, 1, 2};
        Polynomial p2 = new Polynomial(c2, e2);

        Polynomial s = p1.add(p2);
        System.out.println("s(0.1) = " + s.evaluate(0.1));

        if (s.hasRoot(1))
            System.out.println("1 is a root of s");
        else
            System.out.println("1 is not a root of s");

        Polynomial product = p1.multiply(p2);
        System.out.println("Product: " + product.evaluate(2));

        try {
            Polynomial polynomialFromFile = new Polynomial(new File("polynomial.txt"));
            System.out.println("Polynomial from file: " + polynomialFromFile.evaluate(2));
            polynomialFromFile.saveToFile("saved_polynomial.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
