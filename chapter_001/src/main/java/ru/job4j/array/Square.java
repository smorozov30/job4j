package ru.job4j.array;

/**
 * Square Класс заполняет массив числами возведенными в квадрат
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class Square {
    /**
     * calculate Метод принимает размер массива, создает и заполняет массив квадратами числа, возвращает заполненный массив
     * @param bound - размер массива
     * @return - массив заполненый числами
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= rst.length; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}
