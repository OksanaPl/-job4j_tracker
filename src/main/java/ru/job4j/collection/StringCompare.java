package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int size = Math.min(s1.length(), s2.length());
        for (int i = 0; i < size; i++) {
            int rsl = Character.compare(s1.charAt(i), s2.charAt(i));
            if (rsl != 0) {
                return rsl;
            }
        }
        return Integer.compare(s1.length(), s2.length());
    }
}
