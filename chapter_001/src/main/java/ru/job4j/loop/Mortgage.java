package ru.job4j.loop;

/**
 * Класс считает количество лет для погашения ипотеки.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Mortgage {

    /**
     * Метод считает количество лет для погашения ипотеки.
     * @param amount - размер ипотеки.
     * @param salary - зарплата человека.
     * @param percent - процент ипотеки.
     * @return - количество лет.
     */
    public int year(int amount, int salary, double percent) {
        int year = 0;
        while (amount > 0) {
            amount = amount + (int) (amount * (percent / 100));
            amount = amount - salary;
            year++;
        }
        return year;
    }
}
