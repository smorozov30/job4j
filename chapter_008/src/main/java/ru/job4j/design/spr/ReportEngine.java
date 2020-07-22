package ru.job4j.design.spr;

import java.util.function.Predicate;

public abstract class ReportEngine {
    protected Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public abstract String generate(Predicate<Employer> filter);
}
