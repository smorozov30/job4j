package ru.job4j.net;

import java.io.*;
import java.net.URL;

public class FileDownload {
    public static void main(String[] args) throws Exception {
        String file = args[0];
        int limitSpeed = Integer.parseInt(args[1]);
        double limitTime = 1000;
        double limitTime1kb = limitTime / limitSpeed;
        try (BufferedInputStream in = new BufferedInputStream(new URL(file).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            do {
                long start = System.currentTimeMillis();
                bytesRead = in.read(dataBuffer, 0, 1024);
                long end = System.currentTimeMillis();
                long timeDownload1kb = end - start;
                if (timeDownload1kb < limitTime1kb) {
                    Thread.sleep((long) (limitTime1kb - timeDownload1kb));
                }
                if (bytesRead != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } while (bytesRead != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}