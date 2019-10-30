package ru.job4j.calculator;

/**
 * Calculator Класс для вычисления арифметических операций + - * /
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class Calculator {
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }
    public static void multiple(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }
    public static void substract(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * main С этого метода начинется выполнение программы
     * @param args
     */
    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiple(2, 1);
        substract(10, 5);
    }
}