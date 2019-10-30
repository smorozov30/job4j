package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CheckPrimeNumberTest {
    @Test
    public void when5() {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        boolean result = checkPrimeNumber.check(5);
        assertThat(result, is(true));
    }

    @Test
    public void when4() {
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        boolean result = checkPrimeNumber.check(4);
        assertThat(result, is(false));
    }
}
