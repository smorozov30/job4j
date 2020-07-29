package ru.job4j.sort;

import java.util.Arrays;

/**
 * Класс выдает сдачу с покупки.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Machine {

    /**
     * Массив номиналов денег для сдачи.
     */
    private final int[] coins = {10, 5, 2, 1};

    /**
     * Метод высчитывает и выдет сдачу.
     * @param money - принятые в автомат деньги.
     * @param price - цена покупки.
     * @return - сдачу.
     */
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int chan = money - price;
        for (int coin : coins) {
            while (chan >= coin) {
                chan -= coin;
                rsl[size++] = coin;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
