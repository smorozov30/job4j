package ru.job4j.array;

/**
 * EndsWith Класс определяет оканчивается ли слово на постфикс
 * @author morozsergey30 (karandash.zapiskin@gmail.com)
 */
public class EndsWith {
    /**
     * Метод принимает слово и постфикс, определяет оканчивается слово на постфикс, возвращает результат спроверки
     * @param word - массив символов, содержит слово для проверки
     * @param post - массив символов, содержит постфикс для поиска в слове
     * @return - результат поиска постфикса в слове true/false
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
