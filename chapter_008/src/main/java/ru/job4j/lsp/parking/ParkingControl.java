package ru.job4j.lsp.parking;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс размещает автомобили на парковке.
 *
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class ParkingControl implements Parking {

    /**
     * Количество свободных мест на парковке для легковых.
     */
    private int placesForCars;

    /**
     * Количество свободных мест на парковке для грузовых.
     */
    private int placesForTrucks;

    /**
     * Поле хранит места для разных авто.
     */
    private int[] parking;

    /**
     * Поле хранит связь: Номер места - Автомобиль.
     */
    private HashMap<Integer, Car> parkedCars = new HashMap<>();

    /**
     * Конструктор класса.
     * @param placesForCars - количество парковочных мест для легковых авто.
     * @param placesForTrucks - количество парковочных мест для грузовых авто.
     */
    public ParkingControl(int placesForCars, int placesForTrucks) {
        this.parking = new int[placesForCars + placesForTrucks];
        this.placesForCars = placesForCars;
        this.placesForTrucks = placesForTrucks;
    }

    /**
     * Метод размещает авто на парковке после проверки на возможность припарковаться.
     *
     * Если легковой и есть место placesForCars, паркует на место для легковой.
     * Если грузовик и есть место placesForTrucks, паркует на место для грузовика.
     * Если грузовик и нет мест placesForTrucks, но есть два места placesForCars,
     *      паркует на два места для легковых.
     *
     * @param car - машина.
     * @return - результат парковки.
     */
    @Override
    public boolean park(Car car) {
        boolean result = false;
        if (this.canPark(car)) {
            int size = car.getSize();
            int index = this.getIndexPlace(size);
            if (size == 1 && this.placesForCars > 0) {
                this.parking[index] = 1;
                this.placesForCars--;
                this.parkedCars.put(index, car);
            } else if (size == 2 && this.placesForTrucks > 0) {
                this.parking[index] = 1;
                this.placesForTrucks--;
                this.parkedCars.put(index, car);
            } else if (size == 2 && this.placesForCars >= 2) {
                this.parking[index] = 1;
                this.parking[index + 1] = 1;
                this.placesForTrucks = this.placesForCars - 2;
                this.parkedCars.put(index, car);
                this.parkedCars.put(index + 1, car);
            }
            result = true;
        }
        return result;
    }

    /**
     * Метод проверяет возможность парковки автомобиля по наличию места под авто.
     * @param car - машина.
     * @return - результат проверки.
     */
    @Override
    public boolean canPark(Car car) {
        return this.getIndexPlace(car.getSize()) != -1;
    }

    /**
     * Ищет метсто для машины в зависимости от ее размера, и свободных мест.
     *
     * Если есть место для легковой - возвращает номер места.
     * Если есть место для грузовой - возвращает номер места.
     * Если нет места для грузовой, но есть два места для легковой рядом
     *      - возвращает стартовый номер места.
     *
     * @param size - размер авто.
     * @return - номер места на парковке.
     */
    private int getIndexPlace(int size) {
        int result = -1;
        if (size == 1 && this.placesForCars > 0) {
            for (int index = 0; index < this.parking.length; index++) {
                if (this.parking[index] == 0) {
                    result = index;
                    break;
                }
            }
        } else if (size == 2 && this.placesForTrucks > 0) {
            for (int index = 0; index < this.parking.length; index++) {
                if (this.parking[index] == 0) {
                    result = index;
                    break;
                }
            }
        } else if (size == 2 && this.placesForCars >= 2) {
            for (int index = 0; index < this.parking.length; index++) {
                if (this.parking[index] == 0 && this.parking[index + 1] == 0) {
                    result = index;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * По номерному знаку находит место на котором стоит авто. Освобождает место и
     * добавляет к свободным местам количество освободившихся мест.
     * @param number - номер машины.
     * @return - результат удаления авто с парковки.
     */
    @Override
    public boolean leave(String number) {
        boolean result = false;
        int countPlaces = 0;
        Car leaveCar = null;
        for (Map.Entry<Integer, Car> pair : this.parkedCars.entrySet()) {
            int place = pair.getKey();
            Car car = pair.getValue();
            String numberCar = car.number();
            if (number.equals(numberCar)) {
                leaveCar = car;
                this.parking[place] = 0;
                countPlaces++;
                result = true;
            }
        }
        if (countPlaces == 1 && leaveCar.getSize() == 1) {
            this.placesForCars++;
        } else if (countPlaces == 1 && leaveCar.getSize() == 2) {
            this.placesForTrucks++;
        } else if (countPlaces == 2 && leaveCar.getSize() == 2) {
            this.placesForCars = this.placesForCars + 2;
        }
        return result;
    }
}
