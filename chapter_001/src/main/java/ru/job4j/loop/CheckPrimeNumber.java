package ru.job4j.loop;

/**
 * Класс проверят является ли число простым.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class CheckPrimeNumber {

    /**
     * Метод проверяет является ли число простым.
     * @param finish - число для проверки, оно же конец диапазона для проверки.
     * @return - результат проверки.
     */
    public boolean check(int finish) {
        boolean prime = true;
        if (finish < 2) {
            prime = false;
        } else {
            for (int i = 2; i < finish; i++) {
                if (finish % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }
}
