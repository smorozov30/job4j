package ru.job4j.parser;

import java.io.File;

public interface Writer {
    void saveContent(File file, String content);
}
