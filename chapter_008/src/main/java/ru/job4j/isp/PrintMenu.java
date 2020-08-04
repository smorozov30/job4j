package ru.job4j.isp;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Класс выводит меню в консоль в виде дерева.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class PrintMenu {

    /**
     * Вывод меню в консоль в виде дерева.
     * @param root - главный пункт меню.
     * @param level - параметр для определения уровня вложенности подпунктов.
     */
    public void print(MenuItem root, int level) {
        String delimiter = IntStream.range(0, level + 1).mapToObj(i -> "--").collect(Collectors.joining(""));
        System.out.println(delimiter + " " + root.getName());
        if (root.getItems() != null) {
            for (MenuItem subItem : root.getItems()) {
                print(subItem, level + 1);
            }
        }
    }
}
