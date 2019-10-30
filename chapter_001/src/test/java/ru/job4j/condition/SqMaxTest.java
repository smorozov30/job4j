package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenFirstMax() {
        int result = SqMax.max(5, 2, 1, 1);
        assertThat(result, is(5));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(5, 7, 1, 2);
        assertThat(result, is(7));
    }

    @Test
    public void whenThridMax() {
        int result = SqMax.max(10, 7, 12, 2);
        assertThat(result, is(12));
    }

    @Test
    public void whenFouthMax() {
        int result = SqMax.max(10, 7, 12, 33);
        assertThat(result, is(33));
    }
}
