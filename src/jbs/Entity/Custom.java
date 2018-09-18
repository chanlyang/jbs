package jbs.Entity;

import java.util.Date;

public class Custom {
    private String cno;
    private String cname;
    private String cidcard;
    private String phonenum;
    private Date birthday;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCidcard() {
        return cidcard;
    }

    public void setCidcard(String cidcard) {
        this.cidcard = cidcard;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
