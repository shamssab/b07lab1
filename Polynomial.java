import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Polynomial {
    private double[] coefficients;
    private int[] exponents;

    public Polynomial() {
        this.coefficients = new double[]{0};
        this.exponents = new int[]{0};
    }

    public Polynomial(double[] coefficients, int[] exponents) {
        this.coefficients = coefficients;
        this.exponents = exponents;
    }

    public Polynomial add(Polynomial poly) {
        int maxDegree = Math.max(this.exponents[this.exponents.length - 1], poly.exponents[poly.exponents.length - 1]);
        int size = maxDegree  + 1;
        double[] totalCo = new double[size];
        int[] totalEx = new int[size];

        for (int i = 0; i < this.coefficients.length; i++) {
            totalCo[this.exponents[i]] += this.coefficients[i];
            totalEx[this.exponents[i]] = this.exponents[i];
        }

        for (int i = 0; i < poly.coefficients.length; i++) {
            totalCo[poly.exponents[i]] += poly.coefficients[i];
            totalEx[poly.exponents[i]] = poly.exponents[i];
        }
        
        int counter = 0;
        for(int i = 0; i < size; i++){
            if(totalCo[i]!= 0){
                counter++;   
            }
        }
        
        double[] lastCo = new double[counter];
        int[] lastEx = new int[counter];
        int index = 0;
        for(int i = 0; i < size; i++){
            if(totalCo[i] != 0){
                   lastCo[index] = totalCo[i];
                    lastEx[index] = totalEx[i];
                    index++;
            }
        }

        return new Polynomial(lastCo, lastEx);
    }

    public double evaluate(double x) {
        double total = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            total += this.coefficients[i] * Math.pow(x, this.exponents[i]);
        }
        return total;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
    
    //new method
    public Polynomial multiply(Polynomial poly){
        int multSize = this.coefficients.length + poly.coefficients.length;
        double[] multiplyCo = new double[multSize];
        int[] multiplyEx = new int[multSize];
        
        for(int i = 0; i<this.coefficients.length; i++){
            for(int j = 0; j<poly.coefficients.length; j++){
                int newEx = this.exponents[i] + poly.exponents[j];
                double newCo = this.coefficients[i] * poly.coefficients[j];
                
                int checker = 0;
                for(int k = 0; k <multSize; k++){
                    if(multiplyEx[k] == newEx){
                        multiplyCo[k] += newCo;
                        checker = 1;
                        break;
                    }
                }
                if(checker == 0){
                    for(int k = 0; k< multSize; k++){
                        if(multiplyCo[k] == 0){
                            multiplyEx[k] = newEx;
                            multiplyCo[k] = newCo;
                            break;
                        }
                    }
                }
            }
        }
        return new Polynomial(multiplyCo, multiplyEx);
    } 
    /////////////////////////////////
    public Polynomial(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String polynomialString = scanner.nextLine();
        scanner.close();

        String[] terms = polynomialString.split("(?=[+-])"); // Split at + or -
        int numTerms = terms.length;

        double[] fileCoefficients = new double[numTerms];
        int[] fileExponents = new int[numTerms];

        for (int i = 0; i < numTerms; i++) {
            String term = terms[i].trim();

            if (term.startsWith("+")) {
                term = term.substring(1); // Remove the leading +
            }

            int xIndex = term.indexOf("x");
            String coefficientString = term.substring(0, xIndex).trim();
            String exponentString = term.substring(xIndex + 1).trim();

            double coefficient = Double.parseDouble(coefficientString);
            int exponent = exponentString.isEmpty() ? 0 : Integer.parseInt(exponentString);

            fileCoefficients[i] = coefficient;
            fileExponents[i] = exponent;
        }

        this.coefficients = fileCoefficients;
        this.exponents = fileExponents;
    }

    public void saveToFile(String fileName) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);

        StringBuilder polynomialString = new StringBuilder();

        for (int i = 0; i < coefficients.length; i++) {
            double coefficient = coefficients[i];
            int exponent = exponents[i];

            if (coefficient != 0) {
                polynomialString.append(coefficient);

                if (exponent != 0) {
                    polynomialString.append("x").append(exponent);
                }

                if (i < coefficients.length - 1) {
                    polynomialString.append(" + ");
                }
            }
        }

        writer.println(polynomialString.toString());
        writer.close();
    }
}
