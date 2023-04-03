package ru.job4j.collection;

import java.util.HashMap;

public class UserMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ok965@yandex.ru", "Plavinskaya");
        for (String s : map.keySet()) {
            String value = map.get(s);
            System.out.println(s + " - " + value);
        }
    }
}
