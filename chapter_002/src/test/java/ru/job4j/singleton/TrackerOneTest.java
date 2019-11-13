package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerOneTest {
    @Test
    public void whenItemNameTest1() {
        TrackerOne trackerFirst = TrackerOne.INSTANCE;
        TrackerOne trackerSecond = TrackerOne.INSTANCE;
        boolean result = (trackerFirst == trackerSecond);
        assertThat(result, is(true));
    }
}
