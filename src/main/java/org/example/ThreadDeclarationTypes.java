package org.example;

import static java.lang.Thread.currentThread;
import static org.example.ThreadDeclarationTypes.Anonymous.runnable;
import static org.example.ThreadDeclarationTypes.LambdaRunnable.runnably;



public class ThreadDeclarationTypes {

    //extending a class
    public static class ChildThread extends Thread{
        ChildThread(String name){
            super(name);
        }
        public void run(){
            System.out.println("This ChildThread Thread name is " + currentThread().getName());
        }


    }

    //implementing runnable interface
    public static class ImplementRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("This ImplementRunnable Thread name is " + currentThread().getName());
        }

    }


    //implementing Runnable as anonymous class
    public static class Anonymous {
            static Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("This Anonymous Thread name is " + currentThread().getName());
                }
            };

    }


    //Implement runnable with java runnable
    public static class LambdaRunnable {

            static Runnable runnably = ()->{
                System.out.println("This LambdaRunnable Thread name is " + currentThread().getName());
            };

    }


    public static void main(String[] args) {
        ChildThread thread1 = new ChildThread("thread1");
        Thread thread2 = new Thread(new ImplementRunnable(), "thread2");
        Thread thread3 = new Thread(runnable, "thread3");
        Thread thread4 = new Thread(runnably, "thread4");


        thread4.start();
        thread3.start();
        thread2.start();
        thread1.start();
    }




}
