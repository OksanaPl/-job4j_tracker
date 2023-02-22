package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать?");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        String value = switch (answer) {
            case 1 -> "Да!";
            case 2 -> "Нет!";
            default -> "Может быть";
        };
        System.out.println(value);
    }
}
