package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int arraySize = items.length;
        Item[] names = new Item[arraySize];
        int itemsSize = 0;
        for (int i = 0; i < arraySize; i++) {
            Item name = items[i];
            if (name != null) {
                names[itemsSize] = name;
                itemsSize++;
            }
        }

        Item[] newNames = Arrays.copyOf(names, itemsSize);
        for (int i = 0; i < itemsSize; i++) {
            System.out.println(newNames[i].getName());
        }

        return newNames;
    }

    public Item[] findByName(String key) {
        int arraySize = items.length;
        Item[] names = new Item[arraySize];
        int itemsSize = 0;
        for (int i = 0; i < arraySize; i++) {
            Item name = items[i];
            if (name != null && name.getName().equals(key)) {
                names[itemsSize] = name;
                itemsSize++;
            }
        }

        Item[] newNames = Arrays.copyOf(names, itemsSize);
        for (int i = 0; i < itemsSize; i++) {
            System.out.println(newNames[i].getName());
        }

        return newNames;

    }
}
