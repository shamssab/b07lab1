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
        double[] total = new double[maxDegree];

        for (int i = 0; i < this.coefficients.length; i++) {
            total[i] += this.coefficients[i];
        }

        for (int i = 0; i < poly.coefficients.length; i++) {
            total[i] += poly.coefficients[i];
        }

        return new Polynomial(total);
    }

    public double evaluate(double x) {
        double total = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            total += this.coefficients[i] * Math.pow(x, i);
        }
        return total;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
}
