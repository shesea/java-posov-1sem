package ru.spbu.arts.java.collections;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class MyCollections {
    private static List<Integer> count(int n) {
        List<Integer> countList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            countList.add(i);
        }
        return countList;
    }

    private static void printList(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (var elem : list) {
            System.out.println(elem);
        }
    }

    private static void printListWithIndices(List<String> list) {
        System.out.println("Элементов в списке: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ": " + list.get(i));
        }
    }

    private static List<String> concatenateLists(List<String> l1, List<String> l2) {
        List<String> newList = new ArrayList<>();
        newList.addAll(l1);
        newList.addAll(l2);
        return newList;
    }

    private static List<String> reverseList(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = list.size(); i > 0; i--) {
            newList.add(list.get(i - 1));
        }
        return newList;
    }

    private static void reverseListInPlace(List<String> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Collections.swap(list, i, list.size() - 1 - i);
        }
    }

    private static List<Integer> filterEvenIndices(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            newList.add(list.get(i));
        }
        return newList;
    }

    private static List<Integer> filterEven(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for (var elem : list) {
            if (elem % 2 == 1)
                newList.add(elem);
        }
        return newList;
    }

    private static void mutableFilterEvenIndices(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            list.remove(i);
    }

    private static void mutableFilterEven(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    private static void doReadWordsInFile(String filepath, Set<String> set) throws Exception {
        Path txt = Path.of(filepath);
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            while (in.hasNext()) {
                String word = in.next();
                set.add(word.toLowerCase());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(count(10));
        System.out.println(count(1));

        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);
        printListWithIndices(list1);

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);

        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        List<String> list5rev = reverseList(list5);
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);

        List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
        System.out.println("ints = " + ints);
        System.out.println("ints no even indices = " + filterEvenIndices(ints));
        System.out.println("ints without even = " + filterEven(ints));

        System.out.println(" ============= mutable lists =================== ");

        List<Integer> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts);

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts); //[11, 33, 55, 3]

        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        doReadWordsInFile("text_files/book.txt", hashSet);
        doReadWordsInFile("text_files/book.txt", linkedHashSet);
        doReadWordsInFile("text_files/book.txt", treeSet);
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }
}
