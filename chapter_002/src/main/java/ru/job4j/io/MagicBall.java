package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

/**
 * Класс описывает магический мяч.
 *
 * @author Sergey Morozov(morozov.java.job@gmail.com)
 * @version 1.0
 */
public class MagicBall {

    /**
     * Метод слушает вопрос пользователя и дает рандомный ответ.
     * @param args - аргументы командной строки.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String ques = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("Да.");
        } else if (answer == -1) {
            System.out.println("Нет.");
        } else {
            System.out.println("Может быть");
        }
    }
}
