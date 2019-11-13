package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerThreeTest {
    @Test
    public void when() {
        TrackerThree t1 = TrackerThree.getInstance();
        TrackerThree t2 = TrackerThree.getInstance();
        boolean result = (t1 == t2);
        assertThat(result, is(true));
    }
}
