package ru.spbu.arts.java.oop.ascigraphics;

public class DrawingTest {
    public static void main(String[] args) {
        Drawing drawing1 = new Drawing(5, 5, '9');

        drawing1.print();

        drawing1.setPoint(0, 0, ',');
        drawing1.setPoint(4, 4, '-');
        drawing1.setPoint(1, 3, 'p');

        drawing1.print();

        drawing1.drawVerticalLine(0, 1, 2, 'F');
        drawing1.drawVerticalLine(3, 0, 4, 'V');
        drawing1.print();

        drawing1.drawHorizontalLine(4, 0, 3, 'U');
        drawing1.drawHorizontalLine(2, 1, 4, '*');
        drawing1.print();

        drawing1.drawRectangle(0,0, 4, 1, '%');
        drawing1.print();
        drawing1.drawRectangle(1,2, 3, 3, '=');
        drawing1.print();

        Drawing drawing2 = new Drawing(20, 50, ',');
        drawing2.drawCircle(40, 9, 9, '=');
        drawing2.print();

        drawing2.draw(0, 0, drawing1);
        drawing2.print();
        drawing2.draw(48, 17, drawing1);
        drawing2.print();

        Drawing house = new Drawing(20, 80, '-');
        house.drawRectangle(0, 0, 79, 5, '/');
        house.drawRectangle(30, 5, 60, 11, '#');
        for (int i = 12, j = 27, h = 63; i < 19; i++, j += 3, h -= 3) {
            house.drawHorizontalLine(i, j, h, '*');
        }
        house.drawRectangle(45, 5, 50, 10, '~');
        house.drawCircle(37, 8, 1, '+' );




        house.print();
    }
}
