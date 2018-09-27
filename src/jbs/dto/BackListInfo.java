package jbs.dto;

import java.util.Date;

public class BackListInfo {
    private String rno;//租单号
    private String cno;//客户编号
    private String sno;//员工号
    private String autocard;//车牌号
    private Date rdate;//租赁日期
    private int rdays;//租赁天数
    private Date bdate;//还车时间
    private double realmoney;//实际价格

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

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public double getRealmoney() {
        return realmoney;
    }

    public void setRealmoney(double realmoney) {
        this.realmoney = realmoney;
    }
}
