package BaiTap;

import java.util.Calendar;
import java.util.Date;

public class StopWatch {
    private Calendar startTime;
//    private Date endTime;
    private Calendar endTime;

    StopWatch(){
        this.startTime = Calendar.getInstance();
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void start(){
        this.startTime = Calendar.getInstance();
    }

    public void stop(){
        this.endTime = Calendar.getInstance();
    }

    public long getElapsedTime(){
        return this.endTime.get(Calendar.SECOND) - this.startTime.get(Calendar.SECOND);
    }
}
