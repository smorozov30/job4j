package ru.job4j.lsp.parking;

public class PassengerCar implements Car {
    private static int size = 1;
    private String number;

    public PassengerCar(String number) {
        this.number = number;
    }

    @Override
    public String number() {
        return this.number;
    }

    @Override
    public int getSize() {
        return size;
    }
}
