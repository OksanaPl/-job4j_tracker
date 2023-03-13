package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "4", "0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int select = input.askInt("Enter menu:");
        assertThat(select).isEqualTo(1);
        int select2 = input.askInt("Enter menu:");
        assertThat(select2).isEqualTo(4);
        int select3 = input.askInt("Enter menu:");
        assertThat(select3).isEqualTo(0);
    }

}