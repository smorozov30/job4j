package ru.job4j.srp;

import ru.job4j.calculator.Calculator;

import java.util.Scanner;

public class InteractCalc {
    private double first;
    private double second;
    private double result;
    private String operation;
    private Scanner scanner;

    public void start() {
        this.scanner = new Scanner(System.in);
        while (true) {
            this.showMenu();
            int in = Integer.parseInt(this.input("Выберите пункт меню."));
            if (in == 1) {
                this.useLastResult();
            }
            if (in == 2) {
                this.repeatOperation();
            }
            if (in == 3) {
                this.calc();
            }
            if (in == 4) {
                break;
            }
        }
        this.scanner.close();
    }

    public void calc() {
        this.first = Double.parseDouble(this.input("Введите первое число:"));
        this.operation = this.input("Введите операцию:");
        this.second = Double.parseDouble(this.input("Введите второе число:"));
        this.calculate();
        this.output();
    }

    public void useLastResult() {
        this.first = this.result;
        this.operation = this.input("Введите операцию:");
        this.second = Double.parseDouble(this.input("Введите второе число:"));
        this.calculate();
        this.output();
    }

    public void repeatOperation() {
        this.first = Double.parseDouble(this.input("Введите первое число:"));
        this.second = Double.parseDouble(this.input("Введите второе число:"));
        this.calculate();
        this.output();
    }

    public void showMenu() {
        System.out.println("1. Использовать последнее вычисление.");
        System.out.println("2. Использовать предыдущую операцию.");
        System.out.println("3. Считать.");
        System.out.println("4. Выход.");
    }

    public String input(String text) {
        System.out.println(text);
        return this.scanner.next();
    }

    public void output() {
        System.out.println(this.result);
    }

    public void calculate() {
        if (operation.equals("+")) {
            this.result = Calculator.add(this.first, this.second);
        }
        if (operation.equals("-")) {
            this.result = Calculator.substract(this.first, this.second);
        }
        if (operation.equals("*")) {
            this.result = Calculator.multiple(this.first, this.second);
        }
        if (operation.equals("/")) {
            this.result = Calculator.div(this.first, this.second);
        }
    }

    public static void main(String[] args) {
        new InteractCalc().start();
    }
}


