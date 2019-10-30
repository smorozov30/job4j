package ru.job4j.professions;

public class Doctor extends Profession {
    private Diagnose diagnose;

    public Doctor(String name, String surname, String education, String birthday, Diagnose diagnose) {
        super(name, surname, education, birthday);
        this.diagnose = diagnose;
    }

    public Diagnose getDiagnose() {
        return this.diagnose;
    }
}
