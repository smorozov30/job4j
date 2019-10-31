package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport tr = car;
        Object obj = tr;
        Object ocar = new Car();
        Car carFromObject = (Car) ocar;
    }
}
