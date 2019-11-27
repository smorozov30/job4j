package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(2, 5, x -> 2 * pow(x, 2) + x + 1);
        List<Double> expected = List.of(11D, 22D, 37D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(2, 5, x -> log10(x));
        List<Double> expected = List.of(0.3010299956639812, 0.47712125471966244, 0.6020599913279624);
        assertThat(result, is(expected));
    }
}
