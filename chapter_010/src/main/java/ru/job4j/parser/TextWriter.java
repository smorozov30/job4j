package ru.job4j.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter implements Writer {

    @Override
    public void saveContent(File file, String content) {
        try (FileWriter o = new FileWriter(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}