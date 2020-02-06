package ru.job4j.io;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;

public class Search {

    public List<File> files(String parent, List<String> exts) {
        return this.getFiles(parent, this.getPredicate(exts));
    }

    private List<File> getFiles(String parent, Predicate<String> predicate) {
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

    private Predicate<String> getPredicate(List<String> exts) {
        return s -> {
            boolean result = false;
            for (String ext : exts) {
                if (s.endsWith(ext)) {
                    result = true;
                    break;
                }
            }
            return result;
        };
    }
}
