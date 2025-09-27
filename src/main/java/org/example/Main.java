package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Thread {
    public static void main(String[] args) throws Exception {
        new Thread(new Main()).start();
        throw new RuntimeException("Exception from main thread");
    }
    public void run() {
        throw new RuntimeException("Exception from child thread");
    }
}