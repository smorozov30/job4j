package ru.job4j.io;

import java.util.Scanner;

/**
 * Класс знакомство.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class Greeting {

    /**
     * Метод запуска программы.
     * @param args - параметры командной строки.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Добро пожаловать. Как Вас зовут? ");
        String name = input.nextLine();
        System.out.println(name + ", рад Вас видеть!");
    }
}
