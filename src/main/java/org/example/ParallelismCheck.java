package org.example;

public class ParallelismCheck {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors (logical cores): " + cores);
    }
}
