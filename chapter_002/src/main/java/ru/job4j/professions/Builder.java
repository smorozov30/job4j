package ru.job4j.professions;

public class Builder extends Engineer {
    private String build;

    public Builder(String name, String surname, String education, String birthday, Project project) {
        super(name, surname, education, birthday, project);
    }

    public void setBuild() {

    }
}
