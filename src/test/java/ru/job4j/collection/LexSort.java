package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splL = left.split("\\.");
        String[] splR = right.split("\\.");
        int leFt = Integer.parseInt(splL[0]);
        int riGht = Integer.parseInt(splR[0]);
        return Integer.compare(leFt, riGht);
    }
}
