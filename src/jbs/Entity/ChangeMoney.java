package jbs.Entity;

import java.util.Date;

/**
 * 租金历史变更
 */
public class ChangeMoney {
    private Date cDate;  //变更日期
    private String cType;//变更型号
    private String tubo;
    private Double bRent;//变更前日租金
    private Double aRent;//变更后日租金

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getTubo() {
        return tubo;
    }

    public void setTubo(String tubo) {
        this.tubo = tubo;
    }

    public Double getbRent() {
        return bRent;
    }

    public void setbRent(Double bRent) {
        this.bRent = bRent;
    }

    public Double getaRent() {
        return aRent;
    }

    public void setaRent(Double aRent) {
        this.aRent = aRent;
    }
}
