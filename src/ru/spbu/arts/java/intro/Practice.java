package ru.spbu.arts.java.intro;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws Exception {
        int[] numbers = readIntFromFile();
        int length = findLength(numbers);
        writeIntInFile(numbers, length);
    }

    private static int[] readIntFromFile() throws Exception {
        Path txt = Path.of("text_files", "numbers.txt");
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            int n = in.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }
            return numbers;
        }
    }

    private static int findLength(int[] a) {
        int maxLength = 0;
        for (int x : a) {
            String xStr = String.valueOf(x);
            if (xStr.length() > maxLength)
                maxLength = xStr.length();
        }
        return maxLength;
    }

    private static void writeIntInFile(int[] numbers, int length) throws Exception {
        try (PrintStream outFile = new PrintStream("text_files/numbersOut.txt", StandardCharsets.UTF_8)) {
            for (int x : numbers) {
                int spaces = length - String.valueOf(x).length();
                for (int i = 0; i < spaces; i++) {
                    outFile.print(" ");
                }
                outFile.println(x);
            }
        }
    }
}
