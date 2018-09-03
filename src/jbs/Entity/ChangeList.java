package jbs.Entity;

import java.util.Date;

/**
 * 租赁明细变更
 */
public class ChangeList {
    private String rno;//租单号
    private String pAutocard;//变更前车牌号
    private String nAutocard;//变更后车牌号
    private String person;//操作人
    private Date time;//变更时间

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getpAutocard() {
        return pAutocard;
    }

    public void setpAutocard(String pAutocard) {
        this.pAutocard = pAutocard;
    }

    public String getnAutocard() {
        return nAutocard;
    }

    public void setnAutocard(String nAutocard) {
        this.nAutocard = nAutocard;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
