package ru.job4j.poly;

/**
 * Класс автобус.
 *
 * @author Sergey Morozov(moroz.future@gmail.com)
 * @version 1.0
 */
public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus is going.");
    }

    @Override
    public void passengers(int number) {
        System.out.println(number + " passengers on the bus");
    }

    @Override
    public double fill(int gas) {
        return gas * 46.25;
    }
}
