package ru.job4j.condition;

/**
 * Класс сравнивает четыре числа и возвращает максимальное.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class SqMax {

    /**
     * Метод принимает четыре числа и возвращает максимальное из них.
     * @param first - первое число.
     * @param second - второе число.
     * @param third - третье число.
     * @param forth - четвертое число.
     * @return - возвращает самое большое число из четырех.
     */
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            if (first > third) {
                if (first > forth) {
                    result = first;
                }
            } else if (third > forth) {
                result = third;
            }
        } else if (second > third) {
            if (second > forth) {
                result = second;
            }
        } else if (third > forth) {
            result = third;
        }
        return result;
    }
}
