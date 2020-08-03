package ru.job4j.lsp.parking;

public class CarParking implements Parking {
    private Place[] places;

    public CarParking(int numberCars, int numberTrucks) {
        this.places = new Place[numberCars + numberTrucks];
    }

    @Override
    public boolean park(Car car) {
        return false;
    }

    @Override
    public boolean canPark(Car car) {
        return false;
    }

    @Override
    public boolean leave(String number) {
        return false;
    }

    private void fillPlaces(int numberCars, int numberTrucks) {
        for (int i = 0; i < numberCars; i++) {
            this.places[i] = new CarPlace();
        }
        for (int j = numberCars; j < this.places.length; j++) {
            this.places[j] = new TruckPlace();
        }
    }
}
