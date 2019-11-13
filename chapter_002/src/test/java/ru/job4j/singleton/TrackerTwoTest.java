package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerTwoTest {
    @Test
    public void when() {
        TrackerTwo trackerFirst = TrackerTwo.getInstance();
        TrackerTwo trackerSecond = TrackerTwo.getInstance();
        boolean result = (trackerFirst == trackerSecond);
        assertThat(result, is(true));
    }
}
