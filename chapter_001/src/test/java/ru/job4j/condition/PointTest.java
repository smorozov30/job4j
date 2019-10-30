package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

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
