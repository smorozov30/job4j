package ru.job4j.lsp.parking;

public interface Place {
    void placeCar(Car car);
    Car car();
    int getSize();
}
