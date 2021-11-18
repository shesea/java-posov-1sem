import java.util.ArrayList;
import java.util.Arrays;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(5)));
        System.out.println(Arrays.toString(sieveOfEratosthenes(6)));
        System.out.println(Arrays.toString(sieveOfEratosthenes(8)));
        System.out.println(Arrays.toString(sieveOfEratosthenes(22)));

        System.out.println(Arrays.toString(primes(5)));
        System.out.println(Arrays.toString(primes(6)));
        System.out.println(Arrays.toString(primes(8)));
        System.out.println(Arrays.toString(primes(22)));
        System.out.println(Arrays.toString(primes(114)));

        printFactor(600);
        printFactor(56);
        printFactor(1);
        printFactor(113);
        printFactor(2);
        printFactor(1024);

        int[] a = {1, 4, 5, 10, 20, 100};
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);
        System.out.println("Все тесты выполнены!");

    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n + 1, true);
        int p = 2;
        while (p < n) {
            int del = p * 2;
            while (del <= n) {
                prime[del] = false;
                del += p;
            }
            p++;
            while (!prime[p] && p < n) {
                p++;
            }
        }
        return prime;
    }

    private static int[] primes(int n) {
        boolean[] a = sieveOfEratosthenes(n);
        int countPrimes = 0;
        for (boolean x: a) {
            if (x)
                countPrimes++;
        }
        int[] primes = new int[countPrimes];
        for (int i = 0, j = 0; i < n + 1; i++) {
            if (a[i]) {
                primes[j] = i;
                j++;
            }
        }
        return primes;
    }

    private static ArrayList<int[]> factor(int n) {
        int[] primes = primes(n);
        ArrayList<int[]> factors = new ArrayList<>();
        if (n == 1) {
            factors.add(new int[]{1, 1});
            return factors;
        }
        int d = primes[0];
        int count = 0;
        while (d * d <= n) {
            int remains = n % d;
            int dividedCount = 0;
            while (remains == 0) {  //dividing while it's possible
                n /= d;
                dividedCount++;
                remains = n % d;
            }
            if (dividedCount != 0){
                factors.add(new int[] {d, dividedCount});
            }
            count++;
            d = primes[count];
        }
        if (n != 1) {
            factors.add(new int[] {n, 1});
        }
        return factors;
    }

    private static void printFactor(int n) {
        ArrayList<int[]> a = factor(n);
        for (int[] x: a) {
            System.out.print(Arrays.toString(x));
        }
        System.out.print("\n");
    }

    private static int binarySearch(int[] a, int value) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == value)
                return m;
            else if (a[m] > value)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    public static void test(int[] a, int value, int correctAnswer) {
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("ok");
        else
            System.out.println(
                    "Got " + actualAnswer + " instead of " + correctAnswer
            );
    }

}
