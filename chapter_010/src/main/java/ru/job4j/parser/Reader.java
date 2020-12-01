package ru.job4j.parser;

import java.io.File;
import java.util.function.Predicate;

public interface Reader {
    String getContent(File file, Predicate<Integer> conditions);
}