package jbs.dto;

import java.util.Date;

public class RentListInfo {
    private String rno;//租单号
    private String cno;//客户编号
    private String sno;//员工号
    private Date rdate;//租赁日期
    private int rdays;//租赁天数
    private Double allmoney;//总金额
    private Double extra;//押金
    private String autocard;//车牌号

    public String getAutocard() {
        return autocard;
    }

    public void setAutocard(String autocard) {
        this.autocard = autocard;
    }

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

    public Double getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(Double allmoney) {
        this.allmoney = allmoney;
    }

    public Double getExtra() {
        return extra;
    }

    public void setExtra(Double extra) {
        this.extra = extra;
    }
}
