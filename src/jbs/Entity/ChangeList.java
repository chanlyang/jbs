package jbs.Entity;

import java.util.Date;

/**
 * 租赁明细变更
 */
public class ChangeList {
    private String rno;//租单号
    private String pautocard;//变更前车牌号
    private String nautocard;//变更后车牌号
    private String person;//操作人
    private Date cdate;//变更时间

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
    }

    public String getPautocard() {
        return pautocard;
    }

    public void setPautocard(String pautocard) {
        this.pautocard = pautocard;
    }

    public String getNautocard() {
        return nautocard;
    }

    public void setNautocard(String nautocard) {
        this.nautocard = nautocard;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
