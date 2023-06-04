public class Polynomial {
    private double[] coefficients;

    public Polynomial() {
        this.coefficients = new double[]{0};
    }

    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial add(Polynomial poly) {
        int maxDegree = Math.max(this.coefficients.length, poly.coefficients.length);
        double[] result = new double[maxDegree];

        for (int i = 0; i < this.coefficients.length; i++) {
            result[i] += this.coefficients[i];
        }

        for (int i = 0; i < poly.coefficients.length; i++) {
            result[i] += poly.coefficients[i];
        }

        return new Polynomial(result);
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            result += this.coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
}