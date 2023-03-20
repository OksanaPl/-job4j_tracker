package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("Petr");
        a.add("Ivan");
        a.add("Stepan");
        for (String str : a) {
            System.out.println(str);
        }

    }
}

