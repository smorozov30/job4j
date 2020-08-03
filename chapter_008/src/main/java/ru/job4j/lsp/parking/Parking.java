package ru.job4j.lsp.parking;

public interface Parking {
    boolean park(Car car);
    boolean canPark(Car car);
    boolean leave(String number);
}
