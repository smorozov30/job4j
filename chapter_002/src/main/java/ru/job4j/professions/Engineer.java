package ru.job4j.professions;

public class Engineer extends Profession {
    private Project project;

    public Engineer(String name, String surname, String education, String birthday, Project project) {
        super(name, surname, education, birthday);
        this.project = project;
    }

    public Project getProject() {
        return this.project;
    }
}
