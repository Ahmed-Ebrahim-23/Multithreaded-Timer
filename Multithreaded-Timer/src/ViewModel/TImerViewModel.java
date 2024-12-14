
package ViewModel;

// TODO : change file name later

import Model.Timer;
import ViewModel.TimerThread;
import Services.TimerServices;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TImerViewModel {
    private TimerServices service;
    private Map<Integer, TimerThread> threads = new HashMap<>();
    private Map<Integer, Timer> timers = new HashMap<>();

    public TImerViewModel() {
        this.service = new TimerServices();
    }

    public void addTimer(int ID, String label, Duration duration) {
        Timer timer = service.addTimer(ID, label, duration);
        TimerThread thread = new TimerThread(timer);
        threads.put(ID, thread);
        timers.put(ID, timer);
        thread.start();
        // update gui??
    }

    public void pauseTimer(int ID) {
        TimerThread thread = threads.get(ID);
        Timer timer = timers.get(ID);
        timer.setRemainingDuration(thread.getTimer().getRemainingDuration());
        timers.put(ID, timer);
        thread.stopThread();
    }

    public void resumeTimer(int ID) {
        Timer timer = timers.get(ID);
        TimerThread thread = new TimerThread(timer);
        threads.put(ID, thread);
        thread.start();
    }

    public void resetTimer(int ID) {
        Timer timer = timers.get(ID);
        timer.setRemainingDuration(timer.getActualDuration());
        TimerThread thread = new TimerThread(timer);
        threads.put(ID, thread);
        thread.start();
    }

    public void deleteTimer(int ID) {
        TimerThread thread = threads.get(ID);
        thread.stopThread();
        threads.remove(ID);
        timers.remove(ID);
    }
}
