public class IntroTask3Digits {
    public static void main(String[] args) {
        System.out.println(is_3Digits(100));
        System.out.println(is_3Digits(200));
        System.out.println(is_3Digits(999));
        System.out.println(is_3Digits(99));
        System.out.println(is_3Digits(1000));
    }

    private static boolean is_3Digits(int x) {
        return x >= 100 && x <= 999;
    }
}
