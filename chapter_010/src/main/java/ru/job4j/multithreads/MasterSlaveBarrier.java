package ru.job4j.multithreads;

public class MasterSlaveBarrier {
    private boolean master = true;

    public synchronized void tryMaster() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (master) {
                    doneMaster();
                    notifyAll();
                }
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void trySlave() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (!master) {
                    doneSlave();
                    notifyAll();
                }
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doneMaster() {
        System.out.println("Thread A");
        master = !master;
    }

    public synchronized void doneSlave() {
        System.out.println("Thread B");
        master = !master;
    }
}
