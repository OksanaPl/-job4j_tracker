package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = false;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> checkOrigin = new HashSet<>();
        HashSet<String> checkText = new HashSet<>();
        for (String s : origin) {
            checkOrigin.add(s);
        }
        for (String s : text) {
            checkText.add(s);
        }
        return  checkOrigin.containsAll(checkText);
    }
}