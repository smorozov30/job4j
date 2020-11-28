package ru.job4j.net;

import java.io.*;
import java.net.URL;

public class Wget implements Runnable {
    private final String url;
    private final int speed;

    public Wget(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        double periodOfTime = 1000.0;
        double limitTime1kb = periodOfTime / this.speed;
        try (BufferedInputStream in = new BufferedInputStream(new URL(this.url).openStream());
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
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread wget = new Thread(new Wget(url, speed));
        wget.start();
        wget.join();
    }
}