package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(2, "Impl task"),
                new Item(1, "Reboot server")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Reboot server"),
                new Item(2, "Impl task"),
                new Item(4, "Fix bugs")
        );
        Collections.sort(items);
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "Impl task"),
                new Item(1, "Reboot server"),
                new Item(4, "Fix bugs")
        );
        List<Item> expected = Arrays.asList(
                new Item(4, "Fix bugs"),
                new Item(2, "Impl task"),
                new Item(1, "Reboot server")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}