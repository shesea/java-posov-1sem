package ru.spbu.arts.java.oop.time;

public class ExperimentsWithTime {
    public static void main(String[] args) {
        Time time1 = new Time(12, 0);
        Time time2 = new Time(5, 46);
        Time time3 = new Time(16, 8);
        Time time4 = new Time(0, 56);

        System.out.println(time1.show());
        System.out.println(time2.show());
        System.out.println(time3.show());
        System.out.println(time4.show());

        System.out.println(time1.isDay());     //true
        System.out.println(time1.isMorning()); //false
        System.out.println(time2.isMorning()); //true
        System.out.println(time2.isEvening()); //false
        System.out.println(time3.isEvening()); //true
        System.out.println(time3.isNight());   //false
        System.out.println(time4.isNight());   //true
        System.out.println(time4.isMorning()); //false

        System.out.println(time1.sayHello()); //day
        System.out.println(time2.sayHello()); //morning
        System.out.println(time3.sayHello()); //evening
        System.out.println(time4.sayHello()); //night

        time1.add(20);
        System.out.println(time1.show());
        time1.add(50);
        System.out.println(time1.show());
        time1.add(150);
        System.out.println(time1.show());
        time1.add(148);
        System.out.println(time1.show());
        time1.add(352);
        System.out.println(time1.show());
    }
}
