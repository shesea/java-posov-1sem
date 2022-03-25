package ru.spbu.arts.java.oop.rational;

public class Rational {
    private int n;
    private int d;

    public final static Rational ONE = new Rational(1);
    public final static Rational ZERO = new Rational(0);

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private void setMembers(int n, int d) {
        int currentGcd = gcd(n, d);
        this.n = n / currentGcd;
        this.d = d / currentGcd;
    }

    public Rational(int n, int d) {
        if (d < 0) {
            n *= -1;
            d *= -1;
        }
        setMembers(n, d);
    }

    public Rational(int n) {
        this.n = n;
        this.d = 1;
    }

    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }

    public String toString() {
        if (n == 0)
            return "0";
        if (d == 1)
            return String.valueOf(n);
        return String.format("%d/%d", n, d);
    }

    public double toDouble() {
        return (double)(n) / d;
    }

    public Rational add(Rational other) {
        int currentLcm = lcm(this.d, other.d);
        int newNumerator = (currentLcm / this.d * this.n) + (currentLcm / other.d * other.n);
        return new Rational(newNumerator, currentLcm);
    }

//    public void addInPlace(Rational other) {
//        int currentLcm = lcm(this.d, other.d);
//        int newNumerator = (currentLcm / this.d * this.n) + (currentLcm / other.d * other.n);
//        setMembers(newNumerator, currentLcm);
//    }

    public static Rational add(Rational r1, Rational r2) {
        return r1.add(r2);
    }

    public Rational sub(Rational other) {
        return add(new Rational(other.n * (-1), other.d));
    }

//    public void subInPlace(Rational other) {
//        addInPlace(new Rational(other.n * (-1), other.d));
//    }

    public static Rational sub(Rational r1, Rational r2) {
        return r1.sub(r2);
    }

    public Rational mul(Rational other) {
        return new Rational(this.n * other.n, this.d * other.d);
    }

//    public void mulInPlace(Rational other) {
//        int newN = this.n * other.n;
//        int newD = this.d * other.d;
//        setMembers(newN, newD);
//    }

    public static Rational mul(Rational r1, Rational r2) {
        return r1.mul(r2);
    }

    public Rational div(Rational other) {
        return mul(new Rational(other.d, other.n));
    }

//    public void divInPlace(Rational other) {
//        int newN = this.n * other.d;
//        int newD = this.d * other.n;
//        setMembers(newN, newD);
//    }

    public static Rational div(Rational r1, Rational r2) {
        return r1.div(r2);
    }
}
