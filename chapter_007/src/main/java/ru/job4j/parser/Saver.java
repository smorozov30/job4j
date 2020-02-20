package ru.job4j.parser;

public interface Saver {
    Vacancy add(Vacancy vacancy);
    boolean checkDuplicate(String name);
}
