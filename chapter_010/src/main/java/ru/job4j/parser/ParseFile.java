package ru.job4j.parser;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.*;

@ThreadSafe
public class ParseFile {
    @GuardedBy("this")
    private File file;
    private Reader reader;
    private Writer writer;

    public ParseFile(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        return this.reader.getContent(this.file, i -> true);
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        return this.reader.getContent(this.file, i -> i >= 0x80);
    }

    public synchronized void saveContent(String content) throws IOException {
        this.writer.saveContent(this.file, content);
    }
}