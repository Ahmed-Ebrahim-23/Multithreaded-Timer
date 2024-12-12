package Services;

import Model.Timer;
import java.time.Duration;
import java.time.LocalTime;


public class TimerSrevices {
    
    public void addTimer(String label,Duration duration){
        // file
    }
    
    public void deleteTimer(Timer t){
        // file
    }
    
    public void restartTimer(Timer timer){
        timer.setRemainingDuration(timer.getActualDuration());
    }
    
//    public void pauseTimer(Timer t){
//        
//    }
    
    public void startTimer(Timer timer){
        timer.setStartTime(LocalTime.now());
        timer.setEndTime(timer.getStartTime().plus(timer.getRemainingDuration()));
    }
}
