package ru.job4j.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    /**
     * Метод находит по предикату все файлы в переденной директории(root), которые
     * будут добавлены в архив.
     * @param root - путь к директории, которую нужно архивировать.
     * @param exts - расширения для отбора файлов для архивации.
     * @return - коллекцию файлов для архивации.
     */
    public List<File> seekBy(String root, List<String> exts) {
        return new Search().files(root, exts);
    }

    /**
     * Метод упаковывает файлы из source, в архив zip с нахванием target.
     * @param source - файлы для упаковки.
     * @param target - название файли архива на выходе.
     */
    public void pack(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод с которого начинается выполнение jar файла.
     * @param args - аргументы введенные пользователем в командной строке, в которой указывается
     *             директория которую нужно архивировать, какие файлы исключить, и название файла
     *             архива на выходе.
     */
    public static void main(String[] args) {
        Args arguments = new Args(args);
        List<File> list = new Zip().seekBy(arguments.directory(), Arrays.asList(arguments.exclude()));
        new Zip().pack(list, new File("./" + arguments.output()));
    }
}
