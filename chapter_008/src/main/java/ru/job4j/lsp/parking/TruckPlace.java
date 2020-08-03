package ru.job4j.lsp.parking;

public class TruckPlace implements Place {
    private static int size = 2;
    private Car car;

    @Override
    public void placeCar(Car car) {
        this.car = car;
    }

    @Override
    public Car car() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
