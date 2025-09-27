package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        int num = 100_000; // try increasing this number
        List<Thread> threads = new ArrayList<>(num);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for Virtual Threads, 2 for Platform Threads:");
        int choice = sc.nextInt();

        long start = System.currentTimeMillis();

        if (choice == 1) {
            // Virtual threads
            for (int i = 0; i < num; i++) {
                Thread t = Thread.startVirtualThread(() -> {
                    try {
                        Thread.sleep(1000); // simulate blocking work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                threads.add(t);
            }
        } else {
            // Platform threads
            for (int i = 0; i < num; i++) {
                Thread t = new Thread(() -> {
                    try {
                        Thread.sleep(1000); // simulate blocking work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
                t.start();
                threads.add(t);
            }
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.printf("Created and executed %d threads in %d ms%n", num, (end - start));
    }
}
