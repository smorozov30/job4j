package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

public class MultipleAction implements CalculateAction {
    private String name;

    public MultipleAction(String name) {
        this.name = name;
    }

    @Override
    public double execute(Input input, Output output) {
        int first = Integer.parseInt(input.input(output, "Введите первое число."));
        return this.execute(input, output, first);
    }

    @Override
    public double execute(Input input, Output output, double last) {
        int second = Integer.parseInt(input.input(output, "Введите второе число."));
        double result = Calculator.multiple(last, second);
        output.output(Double.toString(result));
        return result;
    }

    @Override
    public String getName() {
        return name;
    }
}
