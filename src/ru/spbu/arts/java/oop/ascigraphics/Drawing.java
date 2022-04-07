package ru.spbu.arts.java.oop.ascigraphics;

import ru.spbu.arts.java.lambda.Printable;

public class Drawing implements Printable {
    private char[][] image;

    public Drawing(int lines, int columns, char symbol) {
        image = new char[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                image[i][j] = symbol;
            }
        }
    }

    @Override
    public void print() {
        for (char[] chars : image) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.print('\n');
        }
        System.out.println();
    }

    public void setPoint(int x, int y, char symbol) {
        image[image.length - y - 1][x] = symbol;
    }

    public void drawVerticalLine(int column, int y0, int y1, char symbol) {
        for (int i = y1; i >= y0; i--) {
            setPoint(column, i, symbol);
        }
    }

    public void drawHorizontalLine(int line, int x0, int x1, char symbol) {
        for (int j = x0; j <= x1; j++) {
            setPoint(j, line, symbol);
        }
    }

    public void drawRectangle(int x0, int y0, int x1, int y1, char symbol) {
        for (int i = x0; i <= x1; i++) {
            drawVerticalLine(i, y0, y1, symbol);
        }
    }

    public void drawCircle(int x0, int y0, int r, char symbol) {
        for (int i = image.length - 1; i >= 0; i--) {
            for (int j = 0; j < image[i].length; j++) {
                if (((j - x0) * (j - x0) + (i - y0) * (i - y0)) <= r * r) {
                    setPoint(j, i, symbol);
                }
            }
        }
    }

    public void draw(int x0, int y0, Drawing d) {
        for (int i = 0; i < d.image.length && y0 + i < image.length; i++) {
            for (int j = 0; j < d.image[i].length && x0 + j < image[i].length; j++) {
                char currentSymbol = d.image[d.image.length - i - 1][j];
                this.setPoint(x0 + j, y0 + i, currentSymbol);
            }
        }
    }
}
