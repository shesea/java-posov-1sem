package ru.spbu.arts.java.oop.rational;

public class RationalTest {

    private static double calculateHarmonic(int n) {
        Rational sum = new Rational(0);
        for (int i = 1; i <= n; i++) {
            sum = sum.add(new Rational(1, i));
        }
        return sum.toDouble();
    }

    public static void main(String[] args) {
        Rational rational1 = new Rational(1, 2);
        Rational rational2 = new Rational(0);
        Rational rational3 = new Rational (1);
        Rational rational4 = new Rational(16, 28);

        System.out.println(rational1);
        System.out.println(rational2);
        System.out.println(rational3);
        System.out.println(rational4);

        System.out.println(rational1.toDouble());
        System.out.println(rational4.toDouble());

        Rational sum = rational1.add(rational3);
        System.out.println(sum);
//        sum.addInPlace(rational4);
//        System.out.println(sum);

        Rational subtract = rational1.sub(rational3);
        System.out.println(subtract);
//        subtract.subInPlace(rational4);
//        System.out.println(subtract);

        Rational multiplied = rational1.mul(rational4);
        System.out.println(multiplied);
//        multiplied.mulInPlace(rational2);
//        System.out.println(multiplied);

        Rational divided = rational1.div(rational4);
        System.out.println(divided);
//        divided.divInPlace(rational1);
//        System.out.println(divided);

        System.out.println(calculateHarmonic(1));
        System.out.println(calculateHarmonic(2));
        System.out.println(calculateHarmonic(3));
        System.out.println(calculateHarmonic(20));

        System.out.println(rational4.getNumerator());
        System.out.println(rational4.getDenominator());

        System.out.println(Rational.add(rational1, rational4));
        System.out.println(Rational.sub(rational1, rational3));
        System.out.println(Rational.mul(rational1, rational4));
        System.out.println(Rational.div(rational1, rational4));

        System.out.println(Rational.ONE);
        System.out.println(Rational.ZERO);
    }
}
