package jbs.Entity;

import java.util.Date;

/**
 * 租金历史变更
 */
public class ChangeMoney {
    private int cid;
    private String autocard;
    private String cdate;  //变更日期
    private Double brent;//变更前日租金
    private Double arent;//变更后日租金


    public String getAutocard() {
        return autocard;
    }

    public void setAutocard(String autocard) {
        this.autocard = autocard;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public Double getBrent() {
        return brent;
    }

    public void setBrent(Double brent) {
        this.brent = brent;
    }

    public Double getArent() {
        return arent;
    }

    public void setArent(Double arent) {
        this.arent = arent;
    }
}
