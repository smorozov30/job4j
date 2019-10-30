package ru.job4j.professions;

public class Dentist extends Doctor {
    private String pullOut;

    public Dentist(String name, String surname, String education, String birthday, Diagnose diagnose) {
        super(name, surname, education, birthday, diagnose);
    }

    public void pull() {

    }
}
