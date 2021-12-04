import java.util.Arrays;

public class Matrix22Tester {
    public static void main(String[] args) {
        Matrix22 m1 = new Matrix22(1, 2, 3, 4);
        Matrix22 m2 = new Matrix22(new double[][]{{1, 2}, {3, 4}});
        Matrix22 m3 = new Matrix22(8.4, 0.5, -3, -7893.3);

        System.out.println(m1.getTrace());
        System.out.println(m2.getTrace());
        System.out.println(m3.getTrace());

        System.out.println(m1.getDiscriminant());
        System.out.println(m2.getDiscriminant());
        System.out.println(m3.getDiscriminant());

        double[][] m1Arr = m1.getMatrix();
        System.out.println(Arrays.deepEquals(m1Arr, new double[][]{{1, 2}, {3, 4}}));
        m1Arr[0][0] = 0;
        System.out.println(m1);

        System.out.println(m2);
        System.out.println(m3);

        m1.print();
        m2.print();
        m3.print();

        m1.add(m2).print();
        m1.add(m3).print();

        Matrix22 m4 = m1.mul(m2);
        m4.print();
        m4.mul(m1).print();

        m1.pow(1).print();
        m1.pow(2).print();
        m1.pow(3).print();

        for (int i = 1; i < 31; i++) {
            System.out.println(calcFib(i));
        }

        Rotation r1 = new Rotation(0);
        System.out.println(r1.getAngle());
        r1.print();

        Rotation r2= new Rotation(270);
        System.out.println(r2.getAngle());
        r2.print();

        Rotation r3= new Rotation(45);
        System.out.println(r3.getAngle());
        r3.print();
    }

    public static long calcFib(int n) {
        Matrix22 m = new Matrix22(1, 1, 1, 0);
        return (long) m.pow(n).getMatrix()[0][1];
    }

}
