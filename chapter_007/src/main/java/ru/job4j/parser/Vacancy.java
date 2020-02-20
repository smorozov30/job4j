package ru.job4j.parser;

public class Vacancy {
    private String name;
    private String link;
    private String text;

    public Vacancy(String name, String link, String text) {
        this.name = name;
        this.link = link;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
