package ru.spbu.arts.java.lambda;

public class PrintableLetter implements Printable {
    private String letter;
    private int count;

    public PrintableLetter(String letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    @Override
    public void print() {
        System.out.println(letter.repeat(count));
    }
}
