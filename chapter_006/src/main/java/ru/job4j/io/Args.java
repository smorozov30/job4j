package ru.job4j.io;

public class Args {
    private String[] args;
    private String directory;
    private String exceptions;
    private String output;

    public Args(String[] args) {
        this.args = args;
    }

    /**
     * Метод разбивает переданые пользователем параметры запуска в командной строке
     * на части Директория(что нужно архивировать), Исключения(какие файлы не нужно архивировать),
     * Выход(название файла на выходе).
     */
    private void split() {
        for (int index = 0; index < args.length; index++) {
            String code = args[index];
            if (code.matches("-\\w")) {
                if (code.equals("-d")) {
                    this.directory = args[++index];
                }
                if (code.equals("-e")) {
                    this.exceptions = args[++index];
                }
                if (code.equals("-o")) {
                    this.output = args[++index];
                }
            }
        }
    }

    /**
     * Возвращает путь к директории которую нужно архивировать.
     * @return - путь.
     */
    public String directory() {
        if (this.directory == null) {
            this.split();
        }
        return this.directory;
    }

    /**
     * Возвращает расширение файлов которые не нужно архивировать.
     * @return - расширение файлов.
     */
    public String exclude() {
        return this.exceptions;
    }

    /**
     * Возвращает название архива на выходе.
     * @return название архива.
     */
    public String output() {
        return this.output;
    }
}
