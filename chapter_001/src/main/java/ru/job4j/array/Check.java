package ru.job4j.array;

/**
 * Check Класс определяет заполнен масиив только true/false
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class Check {
    /**
     * mono Метод принимает массив логических переменных и определяет все элементы одного типа или нет
     * @param data - массив для проверки
     * @return - логическая переменная, означающая однородный или не однородный массив
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
