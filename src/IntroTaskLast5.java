public class IntroTaskLast5 {
    public static void main(String[] args) {
        System.out.println(isLast5(105));
        System.out.println(isLast5(5));
        System.out.println(isLast5(150));
        System.out.println(isLast5(55557));
    }

    public static boolean isLast5(int x) {
        return x % 10 == 5;
    }
}
