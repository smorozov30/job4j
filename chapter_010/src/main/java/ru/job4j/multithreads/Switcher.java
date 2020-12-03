package ru.job4j.multithreads;

public class Switcher {
    public static void main(String[] args) throws InterruptedException {
        MasterSlaveBarrier msb = new MasterSlaveBarrier();
        Thread first = new Thread(msb::tryMaster);
        Thread second = new Thread(msb::trySlave);
        first.start();
        second.start();
        first.join();
        second.join();
    }
}
