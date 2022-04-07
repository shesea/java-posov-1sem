package ru.spbu.arts.java.lambda;

import ru.spbu.arts.java.oop.ascigraphics.Drawing;

public class Lambda {
    public static void main(String[] args) {
        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print();

        PrintableString ps = new PrintableString("asdf");
        ps.print();

        Drawing d = new Drawing(3,3, '+');

        Printable p = new Printable() {
            @Override
            public void print() {
                System.out.println("I'm anonymous. You don't know my name.");
            }
        };

        Printable lambda = () -> System.out.println("I'm lambda.");

        Printable[] arr = {d, pl, ps, p, lambda};
        for (var elem : arr)
            elem.print();
    }
}
