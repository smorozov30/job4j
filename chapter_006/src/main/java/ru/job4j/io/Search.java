package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {

    public List<File> getFiles(String parent, List<String> exts) {
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
                String extFile = (el.getName()).split("\\.")[1];
                for (String ext : exts) {
                    if (extFile.equals(ext)) {
                        files.add(el);
                        break;
                    }
                }
            }
        }
        return files;
    }
}
