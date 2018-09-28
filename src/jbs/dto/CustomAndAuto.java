package jbs.dto;

import java.util.Date;
import java.util.List;

public class CustomAndAuto {
    private String rno;
    private String cno;
    private Date begindate;
    private int daynum;
    private String autocard;
    private List<String> ldate;

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public int getDaynum() {
        return daynum;
    }

    public void setDaynum(int daynum) {
        this.daynum = daynum;
    }

    public String getAutocard() {
        return autocard;
    }

    public void setAutocard(String autocard) {
        this.autocard = autocard;
    }

    public List<String> getLdate() {
        return ldate;
    }

    public void setLdate(List<String> ldate) {
        this.ldate = ldate;
    }
}
