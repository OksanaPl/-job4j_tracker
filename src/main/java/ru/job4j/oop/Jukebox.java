package ru.job4j.oop;

public class Jukebox {
    public String music(int position) {
        return switch (position) {
           case 1 -> "Пусть бегут неуклюже";
           case 2 -> "Спокойной ночи";
           default -> "Песня не найдена";
        };
    }

    public static void main(String[] args) {
        Jukebox number = new Jukebox();
        System.out.println(number.music(1));
        System.out.println(number.music(2));
        System.out.println(number.music(3));
        }
    }

