package ru.spbu.arts.java.oop.time;

public class Time {
    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public String show() {
        return String.format("%02d:%02d", hours, minutes);
    }

    public boolean isDay() {
        return hours < 16 && hours >= 12;
    }

    public boolean isMorning() {
        return hours >= 4 && hours < 12;
    }

    public boolean isEvening() {
        return hours >= 16 && hours < 22;
    }

    public boolean isNight() {
        return hours >= 22 || hours < 4;
    }

    public String sayHello() {
        if (this.isDay())
            return "Добрый день!";
        if (this.isMorning())
            return "Доброе утро!";
        if (this.isEvening())
            return "Добрый вечер!";
        return "Доброй ночи!";
    }

    public void add(int minutesToAdd) {
        int newMinutes = (this.minutes + minutesToAdd) % 60;
        int newHours = (((minutesToAdd + this.minutes) / 60) + this.hours) % 24;
        this.minutes = newMinutes;
        this.hours = newHours;
    }
}
