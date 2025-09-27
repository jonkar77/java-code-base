package org.example;

public class RunvsStart extends Thread {

    // Java code to see that all threads are
// pushed on same stack if we use run()
// instead of start().

        public void run()
        {
            try
            {
                // Displaying the thread that is running
                System.out.println ("Thread " +
                        Thread.currentThread().getId() +
                        " is running");

            }
            catch (Exception e)
            {
                // Throwing an exception
                System.out.println ("Exception is caught");
            }
        }

    // Main Class

        public static void main(String[] args)
        {
            int n = 8;
            for (int i=0; i<n; i++)
            {
                RunvsStart object = new RunvsStart();

                // start() is replaced with run() for
                // seeing the purpose of start
                object.start();
            }
        }
}
