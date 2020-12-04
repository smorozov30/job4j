package ru.job4j.email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    private ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());

    public void emailTo(User user) {
        this.pool.submit(() -> {
            String username = user.getUsername();
            String email = user.getEmail();
            String subject = String.format("Notification %s to email %s.", username, email);
            String body = String.format("Add a new event to %s.", username);
            send(subject, body, email);
        });

    }

    public void send(String subject, String body, String email) {

    }

    public void close() {
        this.pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
