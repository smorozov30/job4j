package ru.job4j.loop;

/**
 * Класс для расчета прогресса в фитнес зале.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Fitness {

    /**
     * Метод для расчета прогресса в фитнес зале.
     * @param ivan - стартовый вес для первого человека.
     * @param nik - стартовый вес для второго человека.
     * @return - количество месяцев через которые первый обгонит второго.
     */
    public int calc(int ivan, int nik) {
        int month = 0;
        while (ivan < nik) {
            ivan *= 3;
            nik *= 2;
            month++;
        }
        return month;
    }
}
