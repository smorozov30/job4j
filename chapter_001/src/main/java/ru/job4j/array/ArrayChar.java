package ru.job4j.array;

/**
 * Класс определяет начинается ли слово с префикса.
 *  @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class ArrayChar {

    /**
     * Метод принимает два масиива символов Слово и Префикс, определяет начинается ли слово с префикса.
     * @param word - массив символов слова.
     * @param pref - массив символов префикса.
     * @return результат проверки true/false.
     */
    public static boolean startsWith(char[] word, char[] pref) {
        boolean result = true;
        for (int i = 0; i < pref.length; i++) {
            if (pref[i] != word[i]) {
               result = false;
               break;
            }
        }
        return result;
    }
}
