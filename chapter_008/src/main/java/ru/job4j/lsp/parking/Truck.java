package ru.job4j.lsp.parking;

public class Truck implements Car {
    private static int size = 2;
    private String number;

    public Truck(String number) {
        this.number = number;
    }

    @Override
    public String number() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
