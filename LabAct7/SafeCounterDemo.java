package com.mycompany.m7a1_adiova;

class ProgressCounter {

    private int total = 0;

    public synchronized void increment() {
        total++;
    }

    public synchronized int getTotal() {
        return total;
    }
}

class TaskWorker implements Runnable {

    private String workerName;
    private ProgressCounter counter;

    public TaskWorker(String workerName, ProgressCounter counter) {
        this.workerName = workerName;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            counter.increment();

            System.out.println(workerName + " - Current total: "
                    + counter.getTotal());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class SafeCounterDemo {

    public static void main(String[] args) {

        ProgressCounter counter = new ProgressCounter();

        TaskWorker worker1 = new TaskWorker("Worker 1", counter);
        TaskWorker worker2 = new TaskWorker("Worker 2", counter);

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        System.out.println("=== Safe Shared Counter ===");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println("Final total: " + counter.getTotal());
    }
}
