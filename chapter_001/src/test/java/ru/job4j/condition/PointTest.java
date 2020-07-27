package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тест для класса Point.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class PointTest {

    /**
     * Тестируем получение расстояния между двумя точками.
     */
    @Test
    public void distance() {
        int x1In = 5;
        int y1In = 3;
        int x2In = 2;
        int y2In = 1;
        double expected = 3.60555;
        double out = Point.distance(x1In, y1In, x2In, y2In);
        Assert.assertEquals(expected, out, 0.01);
    }
}
