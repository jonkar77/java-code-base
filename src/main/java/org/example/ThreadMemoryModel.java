package org.example;

import static java.lang.Thread.currentThread;

public class ThreadMemoryModel {

    public static class MyObject{
            Object o;
    }

    public static class MyRunnable implements Runnable{
        private int count =0;
        @Override
        public void run() {
                for (int i = 0; i < 1000000; i++) {
                    this.count++;
                }
                System.out.println("Thread " + currentThread().getName() + " has count: " + this.count);
            }
    }

//demonstrates if different object ref in memory is used for each thread it behaves appropriately
    public static class SeperateObjects{

        public static void main(String[] args) {
        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
            t1.start();
            t2.start();
        }
    }

//demonstrates if same object ref in memory is used for all threads it can have duplicate updates
    public static class SharedObjects{
        public static void main(String[] args) {
            Runnable runnable = new MyRunnable();

            Thread t1 = new Thread(runnable);
            Thread t2 = new Thread(runnable);
            t1.start();
            t2.start();
        }
    }
}
