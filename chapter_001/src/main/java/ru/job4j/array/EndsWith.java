package ru.job4j.array;

/**
 * Класс определяет оканчивается ли слово на постфикс.
 * @author Sergey Morozov (morozov.java.job@gmail.com)
 * @version 1.0
 */
public class EndsWith {

    /**
     * Метод принимает слово и постфикс, определяет оканчивается ли слово на постфикс
     * @param word - массив символов, содержит слово для проверки.
     * @param post - массив символов, содержит постфикс для поиска в слове.
     * @return - результат поиска постфикса в слове true/false.
     */
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for (int i = 0; i < post.length; i++) {
            if (post[post.length - 1 - i] != word[word.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
