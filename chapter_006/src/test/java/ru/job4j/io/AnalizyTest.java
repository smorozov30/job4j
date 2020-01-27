package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    private int cursor = 0;

    @Test
    public void whenTwoDiapasones() {
        String source = "./server.log";
        String target = "./unavailable.csv";
        String[] results = {"10:57:01;10:59:01;", "11:01:02;11:02:02;"};

        new Analizy().unavailable(source, target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().filter(line -> line.matches("[0-9].+")).
                    forEach(line -> {
                        assertThat(line, is(results[cursor++]));
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
