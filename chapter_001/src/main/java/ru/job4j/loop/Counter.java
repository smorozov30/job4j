package ru.job4j.loop;

/**
 * Класс вычисляющий сумму всех четных числес в диапазоне.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Counter {

    /**
     * Метод вычисляет сумму всех четных чисел в диапазоне.
     * @param start - начало диапазона.
     * @param finish - конец диапазона.
     * @return - возвращает сумму чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
