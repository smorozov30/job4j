package ru.job4j.barrier;

public class MultiUser {
    public static void main(String[] args) {
        CountBarrier barrier = new CountBarrier(5);
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started!");
                    for (int i = 0; i < 5; i++) {
                        barrier.count();
                    }
                },
                "Master"
        );
        Thread slave = new Thread(
                () -> {
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " started!");
                },
                "Slave"
        );
        master.start();
        slave.start();
    }
}