package ru.job4j.singleton;

public class TrackerThree {

    private static final TrackerThree INSTANCE = new TrackerThree();

    private TrackerThree() {
    }

    public static TrackerThree getInstance() {
        return INSTANCE;
    }
}
