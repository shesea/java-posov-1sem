package ru.spbu.arts.java.matrix;

public class Matrix22 {
    private final double a, b, c, d;

    public Matrix22(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Matrix22(double[][] arr) {
        this.a = arr[0][0];
        this.b = arr[0][1];
        this.c = arr[1][0];
        this.d = arr[1][1];
    }

    public double getTrace() {
        return a + d;
    }

    public double getDiscriminant() {
        return (a * d) - (b * c);
    }

    public double[][] getMatrix() {
        double[][] arr = new double[2][2];
        arr[0][0] = a;
        arr[0][1] = b;
        arr[1][0] = c;
        arr[1][1] = d;
        return arr;
    }

    @Override
    public String toString() {
        String s = "";
        s += a + "; " + b + "; " + c + "; " + d;
        return s;
    }

    private String addToString(String s, double x, int columnLength, boolean isLast) {
        s += " ".repeat(columnLength - String.valueOf(x).length());
        s += String.valueOf(x);
        if (isLast)
            s += "\n";
        else
            s += " ";
        return s;
    }

    public void print() {
        String toPrint = "";
        int firstColumn = Math.max(String.valueOf(a).length(), String.valueOf(c).length());
        int secondColumn = Math.max(String.valueOf(b).length(), String.valueOf(d).length());
        toPrint = addToString(toPrint, a, firstColumn, false);
        toPrint = addToString(toPrint, b, secondColumn, true);
        toPrint = addToString(toPrint, c, firstColumn, false);
        toPrint = addToString(toPrint, d, secondColumn, true);
        System.out.println(toPrint);
    }

    public Matrix22 add(Matrix22 other) {
        double[][] m2 = other.getMatrix();
        return new Matrix22(a + m2[0][0], b + m2[0][1], c + m2[1][0], d + m2[1][1]);
    }

    public Matrix22 mul(Matrix22 other) {
        double[][] m2 = other.getMatrix();
        double[] newNums = new double[4];
        newNums[0] = (a * m2[0][0]) + (b * m2[1][0]);
        newNums[1] = (a * m2[0][1]) + (b * m2[1][1]);
        newNums[2] = (c * m2[0][0]) + (d * m2[1][0]);
        newNums[3] = (c * m2[0][1]) + (d * m2[1][1]);
        return new Matrix22(newNums[0], newNums[1], newNums[2], newNums[3]);
    }

    public Matrix22 pow(int n) {
        Matrix22 m = this;
        for (int i = 1; i < n; i++) {
            m = this.mul(m);
        }
        return m;
    }
}
