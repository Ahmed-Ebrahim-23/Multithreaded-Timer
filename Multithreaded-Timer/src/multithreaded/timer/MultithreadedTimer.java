/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multithreaded.timer;

import Model.Timer;
import ViewModel.TimerThread;
import java.time.Duration;

/**
 *
 * @author hp
 */
public class MultithreadedTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Timer 1 (10 seconds)
        Timer timer = new Timer(1, "Studying", null, null, Duration.ofSeconds(10), Duration.ofSeconds(10));
        TimerThread t1 = new TimerThread(timer);

        // Timer 2
        Timer timer2 = new Timer(2, "Exercising", null, null, Duration.ofSeconds(15), Duration.ofSeconds(15));
        TimerThread t2 = new TimerThread(timer2);

        // Timer 3
        Timer timer3 = new Timer(3, "Cooking", null, null, Duration.ofSeconds(10), Duration.ofSeconds(10));
        TimerThread t3 = new TimerThread(timer3);

        // Start timers
        t1.start();
        t2.start();
        t3.start();

        try { // Simulate GUI actions
              // Let all timers run for 3 seconds
            Thread.sleep(3000);

            // Pause Timer 1
            System.out.println("\nPausing Timer 1...");
            t1.pauseThread();

            // Let Timer 2 and Timer 3 continue for 3 more seconds
            Thread.sleep(3000);

            // Resume Timer 1
            System.out.println("\nResuming Timer 1...");
            t1.resumeThread();

            // Pause Timer 2
            System.out.println("\nPausing Timer 2...");
            t2.pauseThread();

            // Let Timer 1 and Timer 3 continue for 3 more seconds
            Thread.sleep(3000);

            // Stop Timer 3 completely
            System.out.println("\nStopping Timer 3...");
            t3.stopThread();

            // Resume Timer 2
            System.out.println("\nResuming Timer 2...");
            t2.resumeThread();

            // Wait for all threads to finish
            t1.join();
            t2.join();
            t3.join();

            // Print a finished statement
            System.out.println("\nAll timers have finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // try { // Simulating GUI actions
        // Thread.sleep(5000); // Wait for 5 seconds
        // System.out.println("Pausing Timer...");
        // t.pauseThread();

        // Thread.sleep(5000); // Simulate pause for 5 seconds
        // System.out.println("Resuming Timer...");
        // t.resumeThread();

        // Thread.sleep(5000); // Wait for 5 more seconds
        // System.out.println("Stopping Timer...");
        // t.stopThread();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
    }

}
