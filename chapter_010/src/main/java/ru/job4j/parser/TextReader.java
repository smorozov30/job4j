package ru.job4j.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Predicate;

public class TextReader implements Reader {

    @Override
    public String getContent(File file, Predicate<Integer> condition) {
        StringBuilder output = new StringBuilder();
        try (FileReader i = new FileReader(file)) {
            int data;
            while ((data = i.read()) > 0) {
                if (condition.test(data)) {
                    output.append((char) data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}