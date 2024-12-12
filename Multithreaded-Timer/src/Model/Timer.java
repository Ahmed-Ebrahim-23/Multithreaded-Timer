package Model;

import java.time.Duration;
import java.time.LocalTime;

public class Timer {
    int ID;
    String label;
    LocalTime startTime;
    LocalTime endTime;
    Duration actualDuration; 
    Duration remainingDuration; 

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Duration getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(Duration actualDuration) {
        this.actualDuration = actualDuration;
    }

    public Duration getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(Duration remainingDuration) {
        this.remainingDuration = remainingDuration;
    }
    
    
}
