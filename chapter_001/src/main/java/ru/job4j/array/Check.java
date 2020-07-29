package ru.job4j.array;

/**
 * Класс определяет заполнен масиив только true/false.
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 */
public class Check {

    /**
     * Метод принимает массив логических переменных и определяет все элементы одного типа.
     * @param data - массив для проверки.
     * @return - результат проверки.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
