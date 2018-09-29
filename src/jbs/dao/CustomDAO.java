package jbs.dao;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Custom;
import jbs.Entity.TurnPage;
import jbs.dto.AutoInfo;
import jbs.dto.AutoRentInfo;
import jbs.dto.CustomAndAuto;
import jbs.dto.CustomRentInfo;
import jbs.util.Log;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomDAO extends BaseDao {
    /**
     * 按类型查所有车并分页
     *
     * @param tp
     * @param type
     * @return
     * @throws Exception
     */
    public List<AutoInfo> quaryCarsByType(TurnPage tp, String type) throws Exception {
        List<AutoInfo> autos;
        String sql = "select c.autocard,c.color,c.seat,c.gear,c.tubo,c.dayrent,c.pic,c.tname,a.atype,b.bname" +
                " from auto c,autotype a,brand b where c.bno=b.bno and c.tno=a.tno and c.tno=" + "'" + type + "'";
        this.openConnection();
        tp.allRows = this.getSqlAllRows(sql);    //单页记录
        tp.allPages = (tp.allRows - 1) / tp.rows + 1;  //单页数
        if (tp.page > tp.allPages) {
            tp.page = tp.allPages;
        }
        int iStart = (tp.page - 1) * tp.rows + 1;
        int iEnd = iStart + tp.rows;
        String newSql = this.getOracleTurnPageSql(sql, iStart, iEnd);
        PreparedStatement ps = this.conn.prepareStatement(newSql);
        ResultSet rs = ps.executeQuery();
        autos = new ArrayList<>();
        while (rs.next()) {
            AutoInfo ai = new AutoInfo();
            ai.setAtype(rs.getString("atype"));
            ai.setAutocard(rs.getString("autocard"));
            ai.setBname(rs.getString("bname"));
            ai.setColor(rs.getString("color"));
            ai.setDayrent(rs.getDouble("dayrent"));
            ai.setGear(rs.getString("gear"));
            ai.setSeat(rs.getInt("seat"));
            ai.setTname(rs.getString("tname"));
            ai.setTubo(rs.getString("tubo"));
            ai.setPic(rs.getString("pic"));
            autos.add(ai);
        }
        ps.close();
        rs.close();
        return autos;

    }

    /**
     * 查出所有的类型
     *
     * @return
     * @throws Exception
     */
    public List<AutoType> queryAutoType() throws Exception {
        String sql = "select tno,atype,pic from autotype where tno<>?";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, "t005");
        ResultSet rs = ps.executeQuery();
        List<AutoType> list = new ArrayList<>();
        while (rs.next()) {
            AutoType at = new AutoType();
            at.setTno(rs.getString("tno"));
            at.setAtype(rs.getString("atype"));
            at.setPic(rs.getString("pic"));
            list.add(at);
        }
        ps.close();
        rs.close();
        return list;
    }

    /**
     * 取出热门车辆
     * @return
     * @throws Exception
     */
    public List<Auto> queryHotAuto() throws Exception {
        String sql = "select autocard,pic from auto where tno=?";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, "t005");
        ResultSet rs = ps.executeQuery();
        List<Auto> list = new ArrayList<>();
        while (rs.next()) {
            Auto auto = new Auto();
            auto.setAutocard(rs.getString("autocard"));
            auto.setPic(rs.getString("pic"));
            list.add(auto);
        }
        ps.close();
        rs.close();
        return list;
    }

    /**
     * @param custom
     * @throws Exception
     */
    public void insertCustomInfo(Custom custom) throws Exception {
        String sql = "insert into constom values(?,?,?,?,?)";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, custom.getUname());
        ps.setString(2, custom.getCname());
        ps.setString(3, custom.getCidcard());
        ps.setString(4, custom.getPhonenum());
        ps.setDate(5, new java.sql.Date(custom.getBirthday().getTime()));
        ps.executeUpdate();
        ps.close();
    }

    /**
     * @param autocard
     * @param cno
     * @return
     * @throws Exception
     */
    public CustomRentInfo queryAutoAndCustom(String autocard, String cno) throws Exception {
        String sql = "select a.autocard,a.color,a.seat,a.gear,a.tubo,a.dayrent," +
                "a.pic,a.tname,t.atype,b.bname,c.uname,c.cname, c.cidcard,c.phonenum " +
                "from auto a,autotype t,brand b,constom c where a.bno=b.bno and a.tno=t.tno " +
                "and a.autocard= ? and c.uname= ?";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, autocard);
        ps.setString(2, cno);
        ResultSet rs = ps.executeQuery();
        CustomRentInfo cri = null;
        while (rs.next()) {
            cri = new CustomRentInfo();
            cri.setAutocard(rs.getString("autocard"));
            cri.setAtype(rs.getString("atype"));
            cri.setBname(rs.getString("bname"));
            cri.setCid(rs.getString("cidcard"));
            cri.setCno(rs.getString("uname"));
            cri.setColor(rs.getString("color"));
            cri.setDayrent(rs.getDouble("dayrent"));
            cri.setGear(rs.getString("gear"));
            cri.setPhone(rs.getString("phonenum"));
            cri.setPic(rs.getString("pic"));
            cri.setSeat(rs.getInt("seat"));
            cri.setTubo(rs.getString("tubo"));
            cri.setUname(rs.getString("cname"));
            cri.setCname(rs.getString("tname"));
        }
        ps.close();
        rs.close();
        return cri;
    }

    /**
     * @param ca
     * @throws Exception
     */
    public void insertRentInfo(CustomAndAuto ca) throws Exception {
        String sql = "insert into rentdetail(rno,uname,rdate,rdays,autocard,state) values(?,?,?,?,?,?)";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, ca.getRno());
        ps.setString(2, ca.getCno());
        ps.setDate(3, new java.sql.Date(ca.getBegindate().getTime()));
        ps.setInt(4, ca.getDaynum());
        ps.setString(5, ca.getAutocard());
        ps.setInt(6,1);
        ps.executeUpdate();
        ps.close();
    }

    /**
     * 客户查自己信息
     *
     * @param cno
     * @return
     * @throws Exception
     */
    public Custom queryCustom(String cno) throws Exception {
        String sql = "select uname,cname,cidcard,phonenum from constom where uname=?";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cno);
        ResultSet rs = ps.executeQuery();
        Custom custom = null;
        while (rs.next()) {
            custom = new Custom();
            custom.setUname(rs.getString("uname"));
            custom.setCname(rs.getString("cname"));
            custom.setCidcard(rs.getString("cidcard"));
            custom.setPhonenum(rs.getString("phonenum"));
        }
        ps.close();
        rs.close();
        return custom;
    }

    /**
     * 客户看自己的预约
     *
     * @param cno
     * @return
     * @throws Exception
     */
    public AutoRentInfo queryRentedAuto(String cno) throws Exception {
        String sql = "select a.autocard,b.bname,t.atype,a.tname,a.color,a.seat," +
                "a.gear,a.tubo,a.dayrent,a.pic,r.rno,r.rdate,r.rdays" +
                " from rentdetail r,auto a,brand b,autotype t " +
                "where r.autocard=a.autocard and a.bno=b.bno and a.tno=t.tno and r.uname=?";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cno);
        ResultSet rs = ps.executeQuery();
        AutoRentInfo ai = null;
        while (rs.next()) {
            ai = new AutoRentInfo();
            ai.setAutocard(rs.getString("autocard"));
            ai.setBegindate(rs.getTimestamp("rdate"));
            ai.setColor(rs.getString("color"));
            ai.setDays(rs.getInt("rdays"));
            ai.setGear(rs.getString("gear"));
            ai.setPic(rs.getString("pic"));
            ai.setRno(rs.getString("rno"));
            ai.setSeat(rs.getShort("seat"));
            ai.setTubo(rs.getString("tubo"));
            ai.setTname(rs.getString("atype"));
            ai.setBname(rs.getString("bname"));
            ai.setCname(rs.getString("tname"));
            ai.setDayrent(rs.getDouble("dayrent"));
        }
        ps.close();
        rs.close();
        return ai;
    }
}
