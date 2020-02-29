package ru.job4j.srp;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String input(Output output, String ask) {
        output.output(ask);
        return this.scanner.next();
    }
}
