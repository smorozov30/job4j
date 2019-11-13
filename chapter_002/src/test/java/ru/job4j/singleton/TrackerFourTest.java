package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerFourTest {
    @Test
    public void when() {
        TrackerFour t1 = TrackerFour.getInstance();
        TrackerFour t2 = TrackerFour.getInstance();
        boolean result = (t1 == t2);
        assertThat(result, is(true));
    }
}
