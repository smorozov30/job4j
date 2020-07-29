package ru.job4j.loop;

/**
 * Класс считает количество простых числе от 0 до заданного числа.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class PrimeNumber {

    /**
     * Метод считает количество простых числе в диапазоне от 0 до заданного числа.
     * @param finish - конец диапазона.
     * @return - количество простых чисел.
     */
    public int calc(int finish) {
        int count = 1;
        CheckPrimeNumber checkPrimeNumber = new CheckPrimeNumber();
        for (int i = 3; i <= finish; i++) {
            if (checkPrimeNumber.check(i)) {
                count++;
            }
        }
        return count;
    }
}
