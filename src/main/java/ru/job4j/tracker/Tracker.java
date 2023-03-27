package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
     Item rsl = new Item();
     for (Item it : items) {
         if (it.getId() == id) {
             rsl = it;
         } else {
             rsl = null;
         }
     }
     return rsl;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

      public ArrayList<Item> findByName(String key) {
          ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
          return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = id;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.add(item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
         items.remove(index - 1);
        }
        return rsl;
    }
}
