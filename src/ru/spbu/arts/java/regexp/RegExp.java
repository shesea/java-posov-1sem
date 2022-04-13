package ru.spbu.arts.java.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        System.out.println(isEmailCorrect1("abba"));
        System.out.println(isEmailCorrect1("abhfds@mail.ru"));
        System.out.println(isEmailCorrect1("a@gmail.com"));
        System.out.println(isEmailCorrect1("agfk@gmail.comco"));

        System.out.println(isEmailCorrect2("agfk@gmail.com"));
        System.out.println(isEmailCorrect2("agfk2@gmail.com"));
        System.out.println(isEmailCorrect2("a__-o@gmail.com"));
        System.out.println(isEmailCorrect2("111--2@gmail.com"));
        System.out.println(isEmailCorrect2("a@g-mail2.com"));
        System.out.println(isEmailCorrect2("a@2.com"));

        System.out.println(isEmailCorrect3("ujfd@mail.ru"));
        System.out.println(isEmailCorrect3("uj-@mai4l.ru"));
        System.out.println(isEmailCorrect3("**@mail.ru"));
        System.out.println(isEmailCorrect3("mail.ru"));
        System.out.println(isEmailCorrect3("LMAO@gmail.com"));

        printTime("Ехал Грека в 10:40, видит рака Грека в 15:06, рак за руку Греку цап в 16:58");
        printTime("В 25:04 я ел кашу, а в 13:95 делал зарядку.");
        printTime("Новый день начинается не в 00:00, а когда я спать ложусь");
        printTime("09:00 - лучшее время для пробуждения, а для прогулок - 15:30.");
        printTime("В 14:50 Зенит победил Спартака со счётом 100:57.");

        fixSpaces("Кошки   , собаки , утки, шутки.");
        fixSpaces("1 , 2      , 3  ,...");

        swapWords("Какая-то сине-зеленая трава");
        swapWords("Жили-были и ели-пили сладкий-пресладкий мёд.");
        swapWords("-Тире, а не дефис.");

        System.out.println(findKotChar("Кот, который бежал от других котов на чукотке, слышал рокот и клокот"));
        System.out.println(findKotWord("Кот, который бежал от других котов на чукотке, слышал рокот и клокот"));
        System.out.println(findKotInWords("Кот, который бежал от других котов на чукотке, слышал рокот и клокот"));

        System.out.println(findKotChar("КОТ породы скоттиш-фолд лижет локоть, славный кот."));
        System.out.println(findKotWord("КОТ породы скоттиш-фолд лижет локоть, славный кот."));
        System.out.println(findKotInWords("КОТ породы скоттиш-фолд лижет локоть, славный кот."));

        increaseIntegers("У меня 2 яблока и -4 банана");
        increaseIntegers("Дел 100, а сил 0");
        increaseIntegers("-200 баллов за ошибку");

    }

    private static boolean isMatching(String email, String re) {
        Pattern emailPattern = Pattern.compile(re);
        Matcher m = emailPattern.matcher(email);
        return m.matches();
    }

    private static boolean isEmailCorrect1(String email) {
        return isMatching(email,"[a-z]+@[a-z]+\\.[a-z]{2,4}");
    }

    private static boolean isEmailCorrect2(String email) {
        // allowing to use digits and -,_ but email should contain at least 1 letter
        return isMatching(email, "([a-z]+[\\d_-]*)+@([a-z]+[\\d_-]*)+\\.[a-z]{2,4}");
    }

    private static boolean isEmailCorrect3(String email) {
        String re = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c" +
                "\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9]" +
                "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]" +
                "[0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c" +
                "\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        return isMatching(email, re);
    }

    private static void printTime(String text) {
        Pattern timePattern = Pattern.compile("\\b(\\d\\d):(\\d\\d)\\b");
        Matcher timeMatcher = timePattern.matcher(text);
        while (timeMatcher.find()) {
            int hours = Integer.parseInt(timeMatcher.group(1));
            int minutes = Integer.parseInt(timeMatcher.group(2));
            if (hours < 24 && minutes < 60)
                System.out.printf("%s - хорошее время\n", timeMatcher.group(0));
            else
                System.out.printf("%s - плохое время\n", timeMatcher.group(0));
        }
    }

    private static void fixSpaces(String text) {
        System.out.println(text.replaceAll("(\s)+,", ","));
    }

    private static void swapWords(String text) {
        System.out.println(text.replaceAll("([А-Яа-я]+)-([А-Яа-я]+)", "$2-$1"));
    }

    private static int findKot(String text, Pattern kotPattern) {
        int counter = 0;
        Matcher kotMatcher = kotPattern.matcher(text);
        while (kotMatcher.find()) {
            counter++;
        }
        return counter;
    }

    //searching for every entry of symbols "kot"
    private static int findKotChar(String text) {
        Pattern kotPattern = Pattern.compile("кот", Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        return findKot(text, kotPattern);
    }

    //searching only for cat words
    private static int findKotWord(String text) {
        Pattern kotPattern = Pattern.compile("\\bкот\\b",
                                            Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        return findKot(text, kotPattern);
    }

    //searching only for "kot" in parts of other words
    private static int findKotInWords(String text) {
        Pattern kotPattern = Pattern.compile("([а-я]+кот)|(кот[а-я]+)",
                                            Pattern.CASE_INSENSITIVE + Pattern.UNICODE_CASE);
        return findKot(text, kotPattern);
    }

    private static void increaseIntegers(String text) {
        Pattern intPattern = Pattern.compile("-?\\d+");
        Matcher intMatcher = intPattern.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (intMatcher.find()){
            int newInt = Integer.parseInt(intMatcher.group(0));
            newInt++;
            intMatcher.appendReplacement(sb, Integer.toString(newInt));
        }
        intMatcher.appendTail(sb);
        System.out.println(sb);
    }
}
