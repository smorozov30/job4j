package ru.job4j.lsp.parking;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тест на класс CarParking.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class CarParkingTest {

    /**
     * Тестируем возможность парковать всего две легковых машины.
     */
    @Test
    public void whenCanParkTwoPassengerCars() {
        Parking parking = new ParkingControl(2, 0);
        Car passengerCar1 = new PassengerCar("o111oo30");
        Car passengerCar2 = new PassengerCar("o222oo30");
        Car passengerCar3 = new PassengerCar("o333oo30");
        assertTrue(parking.park(passengerCar1));
        assertTrue(parking.canPark(passengerCar2));
        assertTrue(parking.park(passengerCar2));
        assertFalse(parking.canPark(passengerCar3));
        assertFalse(parking.park(passengerCar3));
    }

    /**
     * Тестируем возможность парковать один грузовик на два места для легковых машин.
     */
    @Test
    public void whenCanParkOneTruckOnPlaceForCars() {
        Parking parking = new ParkingControl(2, 0);
        Car truck = new Truck("o111oo30");
        assertTrue(parking.canPark(truck));
        assertTrue(parking.park(truck));
    }

    /**
     * Тестируем возможность парковать один грузовик на одно место для грузовиков.
     */
    @Test
    public void whenCanParkOneTruckOnPlaceForTrack() {
        Parking parking = new ParkingControl(0, 1);
        Car truck = new Truck("o111oo30");
        assertTrue(parking.canPark(truck));
        assertTrue(parking.park(truck));
    }

    /**
     * Тестируем невозможность парковать легковую машину на место для грузовиков.
     */
    @Test
    public void whenCanNotParkOneCarOnPlaceForTrack() {
        Parking parking = new ParkingControl(0, 1);
        Car passengerCar1 = new PassengerCar("o111oo30");
        assertFalse(parking.canPark(passengerCar1));
        assertFalse(parking.park(passengerCar1));
    }

    /**
     * Тестируем возможность совместной парковки легковых и грузовых.
     */
    @Test
    public void whenCanParkOnePassengerCarsAndOneTruck() {
        ParkingControl pc = new ParkingControl(1, 1);
        Car passengerCar1 = new PassengerCar("o111oo30");
        Car truck1 = new Truck("x222xx30");
        assertTrue(pc.park(passengerCar1));
        assertTrue(pc.park(truck1));
    }

    /**
     * Тестируем возможность совместной парковки легковых и грузовых на место легковых.
     */
    @Test
    public void whenCanParkOnePassengerCarsAndOneTruckOnCarPlaces() {
        ParkingControl pc = new ParkingControl(3, 0);
        Car passengerCar1 = new PassengerCar("o111oo30");
        Car truck1 = new Truck("x222xx30");
        assertTrue(pc.park(passengerCar1));
        assertTrue(pc.park(truck1));
    }

    /**
     * Тестируем возможность покидать парковку.
     */
    @Test
    public void whenCarLeaveParkThanReturnCanParkTrue() {
        Parking parking = new ParkingControl(1, 0);
        Car passengerCar1 = new PassengerCar("o111oo30");
        assertTrue(parking.park(passengerCar1));
        Car passengerCar2 = new PassengerCar("o222oo30");
        assertFalse(parking.canPark(passengerCar2));
        assertTrue(parking.leave(passengerCar1.number()));
        assertTrue(parking.canPark(passengerCar2));
        assertTrue(parking.park(passengerCar2));
    }
}
