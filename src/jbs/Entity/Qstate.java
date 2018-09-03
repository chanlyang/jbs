package jbs.Entity;

import java.util.Date;

public class Qstate {
    private String autocard;
    private Date currentDate;
    private int state;

    public String getAutocard() {
        return autocard;
    }

    public void setAutocard(String autocard) {
        this.autocard = autocard;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
