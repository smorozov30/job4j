package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {

    @Override
    public void run() {
        System.out.print("Loading: ");
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.print("|");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
