package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {
    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                  new Fact().calc(-2);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
        }

    @Test
    public void whenCorrectCalc() {
        int n = 4;
        int expected = 24;
        int result = new Fact().calc(n);
        assertThat(result).isEqualTo(expected);
    }
}