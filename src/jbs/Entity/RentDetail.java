package jbs.Entity;

import java.util.Date;

public class RentDetail {
    private String rno;
    private String autocard;
    private String uname;
    private Date rdate;//租赁日期
    private int rdays;//租赁天数


    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getAutocard() {
        return autocard;
    }

    public void setAutocard(String autocard) {
        this.autocard = autocard;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public int getRdays() {
        return rdays;
    }

    public void setRdays(int rdays) {
        this.rdays = rdays;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
