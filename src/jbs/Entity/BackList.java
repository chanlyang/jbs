package jbs.Entity;

import java.util.Date;

public class BackList {
    private String rno;//租单号
    private Date bDate;//还车时间
    private double realmoney;//实际价格
    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public double getRealmoney() {
        return realmoney;
    }

    public void setRealmoney(double realmoney) {
        this.realmoney = realmoney;
    }
}
