package ru.job4j.srp;

public interface CalculateAction {
    String getName();
    double execute(Input input, Output output);
    double execute(Input input, Output output, double last);
}
