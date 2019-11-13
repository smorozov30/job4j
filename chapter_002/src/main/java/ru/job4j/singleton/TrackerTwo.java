package ru.job4j.singleton;

public class TrackerTwo {

    private static TrackerTwo trackerTwo;

    private TrackerTwo() {
    }

    public static TrackerTwo getInstance() {
        if (trackerTwo == null) {
            trackerTwo = new TrackerTwo();
        }
        return trackerTwo;
    }
}
