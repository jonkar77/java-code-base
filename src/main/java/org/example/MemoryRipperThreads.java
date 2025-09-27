package org.example;

public class MemoryRipperThreads {
    public static void main(String[] args){
        int count=0;
        try {
            for(;;){
                Thread thread =  new Thread (()->{
                    try {
                        Thread.sleep(1000000);
                    }
                    catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
                count++;
                thread.start();
                if (count % 1000 == 0) {
                    System.out.println("Created threads: " + count);
                }
            }
        }  catch (OutOfMemoryError e){
            System.out.println("Reached thread limit at: " + count);
        }

    }

}
