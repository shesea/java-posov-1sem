public class IntroTaskCat {
    public static void main(String[] args) {
        System.out.println(catify(1));
        System.out.println(catify(0));
        System.out.println(catify(4));
        System.out.println(catify(5));
        System.out.println(catify(99));
        System.out.println(catify(104));
        System.out.println(catify(322));
        System.out.println(catify(12));
        System.out.println(catify(11));
        System.out.println(catify(19));
        System.out.println(catify(1013));
        System.out.println(catify(1001));
    }

    private static String catify(int x) {
        String cats;
        int lastDigit = x % 10;
        int secondLast = x / 10 % 10;
        if (lastDigit == 1 && secondLast != 1) {
            cats = "кот";
        }
        else if (lastDigit > 1 && lastDigit < 5 && secondLast != 1) {
            cats = "кота";
        }
        else {
            cats = "котов";
        }
        return x + " " + cats;
    }
}
