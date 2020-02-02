package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

public class Search {

    public List<File> getFiles(String parent, Predicate<String> predicate) {
        File start = new File(parent);
        List<File> files = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(start);
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File child : el.listFiles()) {
                    data.offer(child);
                }
            } else {
                if (predicate.test(el.getName())) {
                    files.add(el);
                }
            }
        }
        return files;
    }
}
