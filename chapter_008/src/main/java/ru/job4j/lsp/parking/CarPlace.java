package ru.job4j.lsp.parking;

public class CarPlace implements Place {
    private static int size = 1;
    private Car car;

    @Override
    public void placeCar(Car car) {
        this.car = car;
    }

    @Override
    public Car car() {
        return this.car;
    }

    @Override
    public int getSize() {
        return size;
    }
}
