package ru.job4j.ocp;

import ru.job4j.srp.CalculateAction;
import ru.job4j.srp.Input;
import ru.job4j.srp.Output;

public class SinAction implements CalculateAction {
    private String name;

    public SinAction(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double execute(Input input, Output output) {
        int first = Integer.parseInt(input.input(output, "Введите градусы 0-360."));
        return this.execute(input, output, first);
    }

    @Override
    public double execute(Input input, Output output, double last) {
        double result = Math.sin(Math.toRadians(last));
        output.output(Double.toString(result));
        return result;
    }
}
