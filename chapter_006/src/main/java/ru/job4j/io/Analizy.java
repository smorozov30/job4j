package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Analizy {
    private boolean worked = true;

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            read.lines().filter(line -> line.matches("[0-9].+")).
                    forEach(line -> {
                        List<String> pair = new ArrayList<>(Arrays.asList(line.split(" ")));
                        int code = Integer.parseInt(pair.get(0));
                        if (worked && (code == 400 || code == 500)) {
                            out.print(pair.get(1) + ";");
                            worked = false;
                        }
                        if (!worked && (code == 200 || code == 300)) {
                            out.println(pair.get(1) + ";");
                            worked = true;
                        }
                    });
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
