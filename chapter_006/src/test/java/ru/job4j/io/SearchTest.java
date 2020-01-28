package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest {

    @Test
    @Ignore
    public void when9FileOutOf12AreSelected() {
        int cursor = 0;
        List<String> exts = new ArrayList<>(Arrays.asList("java", "txt"));
        List<File> result = new Search().getFiles("./src/main/java/ru/job4j/io/tmpdir", exts);
        List<String> expected = new ArrayList<>(Arrays.asList("First.java", "Second.java", "Third.java",
                                                              "firstTXT.txt", "secondTXT.txt", "Fifth.java",
                                                              "Fourth.java",  "Seventh.java", "Sixth.java"
                                                ));
        for (File file : result) {
            assertThat(file.getName().equals(expected.get(cursor++)), is(true));
        }
    }
}
