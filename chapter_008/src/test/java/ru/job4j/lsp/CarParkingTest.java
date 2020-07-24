package ru.job4j.lsp;

import org.junit.Test;
import static org.junit.Assert.*;

public class CarParkingTest {
    @Test
    public void whenCanParkTwoPassengerCars() {
        Parking parking = new CarParking(2);
        Car passengerCar1 = new PassengerCar("o111oo30");
        Car passengerCar2 = new PassengerCar("o222oo30");
        assertTrue(parking.canPark(passengerCar1));
        assertTrue(parking.park(passengerCar1));
        assertTrue(parking.canPark(passengerCar2));
        assertTrue(parking.park(passengerCar2));
    }

    @Test
    public void whenCanParkOneTruck() {
        Parking parking = new CarParking(2);
        Car truck = new Truck("o111oo30");
        assertTrue(parking.canPark(truck));
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenCanParkOnePassengerCarsAndOneTruck() {
        Parking parking = new CarParking(3);
        Car passengerCar1 = new PassengerCar("o111oo30");
        Car passengerCar2 = new PassengerCar("o222oo30");
        Car truck1 = new Truck("x222xx30");
        assertTrue(parking.canPark(passengerCar1));
        assertTrue(parking.park(passengerCar1));
        assertTrue(parking.canPark(passengerCar2));
        assertTrue(parking.park(passengerCar2));
        assertTrue(parking.canPark(truck1));
        assertTrue(parking.park(truck1));
    }

    @Test
    public void testLeavePark() {
        Parking parking = new CarParking(2);
        Car passengerCar1 = new PassengerCar("o111oo30");
        assertTrue(parking.park(passengerCar1));
        Car truck1 = new Truck("x222xx30");
        assertFalse(parking.canPark(truck1));
        assertTrue(parking.leave(passengerCar1.getNumber()));
        assertTrue(parking.canPark(truck1));
    }
}
