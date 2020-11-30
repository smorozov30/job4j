package ru.job4j.concurrent;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ParseFile {
    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        InputStreamReader i = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        StringBuilder output = new StringBuilder();
        int data;
        while ((data = i.read()) > 0) {
            output.append((char) data);
        }
        i.close();
        return output.toString();
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        FileReader i = new FileReader(file);
        StringBuilder output = new StringBuilder();
        int data;
        while ((data = i.read()) > 0) {
            if (data >= 0x80) {
                output.append((char) data);
            }
        }
        i.close();
        return output.toString();
    }

    public synchronized void saveContent(String content) throws IOException {
        FileWriter o = new FileWriter(file);
        for (int i = 0; i < content.length(); i += 1) {
            o.write(content.charAt(i));
        }
        o.close();
    }
}