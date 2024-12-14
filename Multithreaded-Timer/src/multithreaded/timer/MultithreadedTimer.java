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
        Timer timer = new Timer();
        timer.setActualDuration(Duration.ofSeconds(5));
        timer.setRemainingDuration(Duration.ofSeconds(5));
        Timer timer1 = new Timer();
        timer1.setActualDuration(Duration.ofSeconds(10));
        timer1.setRemainingDuration(Duration.ofSeconds(10));
        
        TimerThread t = new TimerThread(0,timer);
        TimerThread t1 = new TimerThread(1,timer1);
        
        t.start();
        t1.start();
    }
    
}
