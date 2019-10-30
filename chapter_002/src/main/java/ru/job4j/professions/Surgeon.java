package ru.job4j.professions;

public class Surgeon extends Doctor {
    private String remove;

    public Surgeon(String name, String surname, String education, String birthday, Diagnose diagnose) {
        super(name, surname, education, birthday, diagnose);
    }

    public void cut() {

    }
}