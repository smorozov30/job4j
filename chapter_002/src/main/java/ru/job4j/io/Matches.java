package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        System.out.println("На столе " + matches + " спичек.");
        int count = 0;
        while (matches > 0) {
            if (count % 2 == 0) {
                System.out.println("Первый игрок, возьмите спички от 1 до 3 штук.");
            } else {
                System.out.println("Второй игрок, возьмите спички от 1 до 3 штук.");
            }
            count++;
            int amount = Integer.valueOf(input.nextLine());
            if (amount < 1 || amount > 3) {
                System.out.println("ПРАВИЛО: Возьмите от 1 до 3 спичек.");
                continue;
            }
            matches = matches - amount;
            if (matches < 1) {
                System.out.println("Игра окончена. Спичек не осталось. Вы забрали последние спички!");
                break;
            }
            System.out.println("На столе осталось " + matches + " спички(ек)");

        }
    }
}
