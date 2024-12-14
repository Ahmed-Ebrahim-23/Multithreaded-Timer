/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import Model.Timer;
import Services.TimerServices;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class TimerThread extends Thread{
    private Timer timer;
    private int ID;
    private TimerServices service;
    private Boolean running;
    
    public TimerThread(int ID, Timer timer) {
        this.timer = timer;
        this.ID = ID;
        this.running = true;
        this.service = new TimerServices();
    }

    public Timer getTimer() {
        return timer;
    }
    
    @Override
    public void run(){
        while(running && !timer.getRemainingDuration().equals(Duration.ZERO)){
            timer.setRemainingDuration(timer.getRemainingDuration().minusSeconds(1));
            service.startTimer(timer);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stopThread(){
        this.running = false;
    }
}
