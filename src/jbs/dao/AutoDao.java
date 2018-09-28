package jbs.dao;

import jbs.Entity.*;
import jbs.dto.AutoInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutoDao extends BaseDao{
    /**
     * 车辆查询
     * @param atype
     * @param bname
     * @param tname
     * @param tubo
     * @param tp
     * @return
     * @throws Exception
     */
    public List<AutoInfo> getAutoInfo(String atype, String bname, String tname, String tubo,TurnPage tp) throws Exception{
        List<AutoInfo> alist;
        String sql = "select a.autocard,c.atype,b.bname,a.tname,a.color,a.seat,a.gear,a.tubo,a.dayrent,a.extra "
                + "from auto a,brand b,autotype c "
                + "where a.bno = b.bno and a.tno = c.tno";
        if(atype!=null&&!atype.equals("")){
            sql = sql+"and c.atype ="+atype;
        }
        if(bname!=null&&!bname.equals("")){
            sql = sql +"and b.bname ="+bname;
        }
        if(tname!=null&&!tname.equals("")){
            sql = sql +"and a.tname ="+tname;
        }
        if(tubo!=null&&!tubo.equals("")){
            sql = sql +"and a.tubo ="+tubo;
        }
        this.openConnection();
        tp.allRows = this.getSqlAllRows(sql);                          //总记录数
        tp.allPages = (tp.allRows-1)/tp.rows + 1;                      //总页数
        if(tp.page>tp.allPages){
            tp.page = tp.allPages;
        }
        int iStart = (tp.page-1) * tp.rows + 1;
        int iEnd = iStart + tp.rows;
        String newSql = this.getOracleTurnPageSql(sql, iStart, iEnd);
        PreparedStatement ps = this.conn.prepareStatement(newSql);
        ResultSet rs = ps.executeQuery();
        alist = new ArrayList<AutoInfo>();
        while(rs.next()){
            AutoInfo auto = new AutoInfo();
            auto.setAutocard(rs.getString("autocard"));
            auto.setAtype(rs.getString("atype"));
            auto.setBname(rs.getString("bname"));
            auto.setTname(rs.getString("tname"));
            auto.setColor(rs.getString("color"));
            auto.setSeat(rs.getInt("seat"));
            auto.setGear(rs.getString("gear"));
            auto.setTubo(rs.getString("tubo"));
            auto.setDayrent(rs.getDouble("dayrent"));
            auto.setExtra(rs.getDouble("extra"));
            alist.add(auto);
        }
        rs.close();
        ps.close();
        return alist;
    }

    /**
     * 添加车辆
     * @param auto
     * @throws Exception
     */
    public void addAuto(Auto auto) throws Exception {
        String sql = "insert into auto values(?,?,?,?,?,?,?,?,?,?,?)";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,auto.getAutocard());
        ps.setString(2,auto.getBno());
        ps.setString(3,auto.getTno());
        ps.setString(4,auto.getColor());
        ps.setInt(5,auto.getSeat());
        ps.setString(6,auto.getGear());
        ps.setString(7,auto.getTubo());
        ps.setDouble(8,auto.getDayrent());
        ps.setString(9,auto.getPicurl());
        ps.setString(10,auto.getTname());
        ps.setDouble(11,auto.getExtra());
        ps.executeUpdate();
        ps.close();
    }

    /**
     * 汽车类型查询（下拉框使用）
     * @return
     * @throws Exception
     */
    public List<AutoType> getAutoType() throws Exception {
        List<AutoType> atlist;
        String sql = "select tno,atype from autotype";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        atlist = new ArrayList<AutoType>();
        while(rs.next()){
            AutoType autoType = new AutoType();
            autoType.setTno(rs.getString("tno"));
            autoType.setAtype(rs.getString("atype"));
            atlist.add(autoType);
        }
        rs.close();
        ps.close();
        return atlist;
    }

    /**
     * 汽车品牌查询（下拉框使用）
     * @return
     * @throws Exception
     */
    public List<Brand> getBrand() throws Exception {
        List<Brand> blist;
        String sql = "select bno,bname from brand";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        blist = new ArrayList<Brand>();
        while(rs.next()){
            Brand brand = new Brand();
            brand.setBno(rs.getString("bno"));
            brand.setBname(rs.getString("bname"));
            blist.add(brand);
        }
        rs.close();
        ps.close();
        return blist;
    }

    /**
     * 查看某车辆细节
     * @param autocard
     * @return
     * @throws Exception
     */
    public Auto getAutoDetail(String autocard) throws Exception {
        Auto auto = null;
        this.openConnection();
        String sql = "select a.autocard,c.atype,b.bname,a.tname,a.color,a.seat,a.gear,a.tubo,a.dayrent,a.extra,a.pic "
                + "from auto a,brand b,autotype c "
                + "where a.bno = b.bno and a.tno = c.tno and a.autocard=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,autocard);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            auto = new Auto();
            auto.setAutocard(rs.getString("autocard"));
            auto.setAtype(rs.getString("atype"));
            auto.setBname(rs.getString("bname"));
            auto.setTname(rs.getString("tname"));
            auto.setColor(rs.getString("color"));
            auto.setSeat(rs.getInt("seat"));
            auto.setGear(rs.getString("gear"));
            auto.setTubo(rs.getString("tubo"));
            auto.setDayrent(rs.getDouble("dayrent"));
            auto.setExtra(rs.getDouble("extra"));
            auto.setPicurl(rs.getString("pic"));
            break;
        }
        rs.close();
        ps.close();
        return auto;
    }

    /**
     * 修改汽车信息
     * @param auto
     * @return
     * @throws Exception
     */
    public int AutoUpdate(Auto auto) throws Exception {
        int iRet;
        this.openConnection();
        String sql = "update auto set autocard=?,bno=?,tno=?,color=?,seat=?,gear=?,tubo=?,dayrent=?,extra=? where autocard=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,auto.getAutocard());
        ps.setString(2,auto.getBno());
        ps.setString(3,auto.getTno());
        ps.setString(4,auto.getColor());
        ps.setInt(5,auto.getSeat());
        ps.setString(6,auto.getGear());
        ps.setString(7,auto.getTubo());
        ps.setDouble(8,auto.getDayrent());
        ps.setDouble(9,auto.getExtra());
        ps.setString(10,auto.getAutocard());
        iRet = ps.executeUpdate();
        ps.close();
        return iRet;
    }

    /**
     * 删除指定汽车信息
     * @param auto
     * @return
     * @throws Exception
     */
    public boolean AutoDelete(Auto auto) throws Exception {
        boolean b;
        this.openConnection();
        String sql = "delete from auto where autocard=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,auto.getAutocard());
        int count = ps.executeUpdate();
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }

    /**
     * 批量删除（存在bug）
     * @param autocards
     * @return
     * @throws Exception
     */
    public boolean AutoDeleteAll(String[] autocards) throws Exception {
        boolean b;
        int count = 0;
        PreparedStatement ps = null;
        this.openConnection();
        for(int i = 0;i<autocards.length;i++) {
            String sql = "delete from auto where autocard='"+autocards[i]+"'";
            ps = this.conn.prepareStatement(sql);
            count = ps.executeUpdate();
        }
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }

    /**
     * 租金变更（插入到changemoney表中）
     * @param changeMoney
     * @throws Exception
     */
    public void addChangeMoney(ChangeMoney changeMoney) throws Exception {
        String sql = "insert into changemoney(autocard,cdate,brent,arent) values(?,?,?,?)";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        //ps.setInt(1,changeMoney.getCid());
        ps.setString(1,changeMoney.getAutocard());
        ps.setString(2,changeMoney.getCdate());
        ps.setDouble(3,changeMoney.getBrent());
        ps.setDouble(4,changeMoney.getArent());
        ps.executeUpdate();
        ps.close();
    }

    /**
     * 租金变更查询
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<ChangeMoney> ChangeMoneyQuery(String autocard,TurnPage tp) throws Exception {
        List<ChangeMoney> changeMoneyList;
        String sql = "select cid,autocard,cdate,brent,arent from changemoney order by cid asc";
        if(autocard!=null&&!autocard.equals("")){
            sql = "select cid,autocard,cdate,brent,arent from changemoney where autocard like %"+autocard+"% order by cid asc";
        }
        this.openConnection();
        tp.allRows = this.getSqlAllRows(sql);                          //总记录数
        tp.allPages = (tp.allRows-1)/tp.rows + 1;                      //总页数
        if(tp.page>tp.allPages){
            tp.page = tp.allPages;
        }
        int iStart = (tp.page-1) * tp.rows + 1;
        int iEnd = iStart + tp.rows;
        String newSql = this.getOracleTurnPageSql(sql, iStart, iEnd);
        PreparedStatement ps = this.conn.prepareStatement(newSql);
        ResultSet rs = ps.executeQuery();
        changeMoneyList = new ArrayList<ChangeMoney>();
        while(rs.next()){
            ChangeMoney changeMoney = new ChangeMoney();
            changeMoney.setCid(rs.getInt("cid"));
            changeMoney.setAutocard(rs.getString("autocard"));
            changeMoney.setCdate(rs.getString("cdate"));
            changeMoney.setBrent(rs.getDouble("brent"));
            changeMoney.setArent(rs.getDouble("arent"));
            changeMoneyList.add(changeMoney);
        }
        rs.close();
        ps.close();
        return changeMoneyList;
    }

    /**
     * 租金变更查看
     * @param cid
     * @return
     * @throws Exception
     */
    public ChangeMoney getChangeMoneyDetail(String cid) throws Exception {
        ChangeMoney changeMoney = null;
        this.openConnection();
        String sql = "select cid,autocard,cdate,brent,arent from changemoney where cid = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,cid);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            changeMoney = new ChangeMoney();
            changeMoney.setCid(rs.getInt("cid"));
            changeMoney.setAutocard(rs.getString("autocard"));
            changeMoney.setCdate(rs.getString("cdate"));
            changeMoney.setBrent(rs.getDouble("brent"));
            changeMoney.setArent(rs.getDouble("arent"));
            break;
        }
        rs.close();
        ps.close();
        return changeMoney;
    }

    /**
     * 删除租金变更表中的数据
     * @param changeMoney
     * @return
     * @throws Exception
     */
    public boolean ChangeMoneyDelete(ChangeMoney changeMoney) throws Exception {
        boolean b;
        this.openConnection();
        String sql = "delete from changemoney where cid=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1,changeMoney.getCid());
        int count =  ps.executeUpdate();
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }

    /**
     * chanlyang添加。
     * 添加状态
     * @param autocard
     * @param date
     * @throws Exception
     */
    public void insertAutoState(String autocard,Date date) throws Exception{
        String sql = "insert into qstate(autocard,currentdate,state) values(?,?,?)";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,autocard);
        ps.setDate(2,new java.sql.Date(date.getTime()));
        ps.setInt(3,1);
        ps.executeUpdate();
        ps.close();
    }
}
