package ru.job4j.poly;

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
