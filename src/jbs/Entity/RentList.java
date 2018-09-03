package jbs.Entity;

import java.util.Date;

public class RentList {
    private String rno;//租单号
    private String cno;//客户编号
    private String sno;//员工号
    private Date rDate;//租赁日期
    private Date rDays;//租赁天数
    private Double allMoney;//总金额
    private Double extra;//押金

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

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public Date getrDays() {
        return rDays;
    }

    public void setrDays(Date rDays) {
        this.rDays = rDays;
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public Double getExtra() {
        return extra;
    }

    public void setExtra(Double extra) {
        this.extra = extra;
    }
}
