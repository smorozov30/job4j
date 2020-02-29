package ru.job4j.srp;

public class ConsoleOutput implements Output {

    @Override
    public void output(String out) {
        System.out.println(out);
    }
}
