package jbs.dao;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.Entity.TurnPage;
import jbs.dto.AutoInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "select a.autocard,c.atype,b.bname,a.tname,a.color,a.seat,a.gear,a.tubo,a.dayrent "
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
        String sql = "insert into auto values(?,?,?,?,?,?,?,?,?,?)";
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
        String sql = "select a.autocard,c.atype,b.bname,a.tname,a.color,a.seat,a.gear,a.tubo,a.dayrent,a.pic "
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
        String sql = "update auto set autocard=?,bno=?,tno=?,color=?,seat=?,gear=?,tubo=?,dayrent=? where autocard=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,auto.getAutocard());
        ps.setString(2,auto.getBno());
        ps.setString(3,auto.getTno());
        ps.setString(4,auto.getColor());
        ps.setInt(5,auto.getSeat());
        ps.setString(6,auto.getGear());
        ps.setString(7,auto.getTubo());
        ps.setDouble(8,auto.getDayrent());
        ps.setString(9,auto.getAutocard());
        iRet = ps.executeUpdate();
        ps.close();
        return iRet;
    }
}
