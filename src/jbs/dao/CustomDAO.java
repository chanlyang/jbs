package jbs.dao;

import jbs.Entity.Auto;
import jbs.Entity.TurnPage;
import jbs.dto.AutoInfo;
import jbs.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomDAO extends BaseDao {

    /**
     * 查出所有车显示在主页
     *
     * @return
     * @throws Exception
     */
    public List<Auto> queryAllCars() throws Exception {
        this.openConnection();
        List<Auto> autos;
        String sql = "select * from auto c,autotype a,brand b where c.bno=b.bno and c.tno=a.tno and autocard=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        Statement a = this.conn.createStatement();
        ps.setString(1, "甘F-88888");
        ResultSet rs = ps.executeQuery();
        autos = new ArrayList<>();
        while (rs.next()) {
            Auto auto = new Auto();
            auto.setAutocard(rs.getString("autocard"));
            auto.setBname(rs.getString("bno"));
            auto.setColor(rs.getString("color"));
            auto.setDayrent(rs.getDouble("dayrent"));
            auto.setGear(rs.getString("gear"));
            auto.setSeat(rs.getInt("seat"));
            auto.setTname(rs.getString("tname"));
            auto.setTubo(rs.getString("tubo"));
            auto.setTubo(rs.getString("tubo"));
            auto.setPic(rs.getString("pic"));
            autos.add(auto);
        }
        ps.close();
        rs.close();
        return autos;
    }

    public List<AutoInfo> quaryCarsByType(TurnPage tp,String type) throws Exception {
        List<AutoInfo> autos;
        String sql = "select c.autocard,c.color,c.seat,c.gear,c.tubo,c.dayrent,c.pic,c.tname,a.atype,b.bname" +
                " from auto c,autotype a,brand b where c.bno=b.bno and c.tno=a.tno and c.tno="+"'"+type+"'";
        this.openConnection();
        tp.allRows = this.getSqlAllRows(sql);    //单页记录
        tp.allPages = (tp.allRows - 1) / tp.rows + 1;  //单页数
        if (tp.page > tp.allPages) {
            tp.page = tp.allPages;
        }
        int iStart = (tp.page - 1) * tp.rows + 1;
        int iEnd = iStart + tp.rows;
        String newSql = this.getOracleTurnPageSql(sql,iStart,iEnd);
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

 /*   public List<Auto> quaryCarsByType2(TurnPage tp) throws Exception {
        List<Auto> autos;
        String sql = "select * from auto where tno="+"'t001'";
        this.openConnection();
        tp.allRows = this.getSqlAllRows(sql);    //单页记录
        tp.allPages = (tp.allRows - 1) / tp.rows + 1;  //单页数
        if (tp.page > tp.allPages) {
            tp.page = tp.allPages;
        }
        int iStart = (tp.page - 1) * tp.rows + 1;
        int iEnd = iStart + tp.rows;
        String newSql = this.getOracleTurnPageSql(sql,iStart,iEnd);
        PreparedStatement ps = this.conn.prepareStatement(newSql);
        ResultSet rs = ps.executeQuery();
        autos = new ArrayList<>();
        while (rs.next()) {
            Auto auto = new Auto();
            auto.setAtype(rs.getString("tno"));
            auto.setAutocard(rs.getString("autocard"));
            auto.setBname(rs.getString("bno"));
            auto.setColor(rs.getString("color"));
            auto.setDayrent(rs.getDouble("dayrent"));
            auto.setGear(rs.getString("gear"));
            auto.setSeat(rs.getInt("seat"));
            auto.setTname(rs.getString("tname"));
            auto.setTubo(rs.getString("tubo"));
            auto.setPic(rs.getString("pic"));
            autos.add(auto);
        }
        ps.close();
        rs.close();
        return autos;

    }

    public List<Auto> quaryCarsByType3(TurnPage tp) throws Exception {
        List<Auto> autos;
        String sql = "select * from auto where tno="+"'t004'";
        this.openConnection();
        tp.allRows = this.getSqlAllRows(sql);    //单页记录
        tp.allPages = (tp.allRows - 1) / tp.rows + 1;  //单页数
        if (tp.page > tp.allPages) {
            tp.page = tp.allPages;
        }
        int iStart = (tp.page - 1) * tp.rows + 1;
        int iEnd = iStart + tp.rows;
        String newSql = this.getOracleTurnPageSql(sql,iStart,iEnd);
        PreparedStatement ps = this.conn.prepareStatement(newSql);
        ResultSet rs = ps.executeQuery();
        autos = new ArrayList<>();
        while (rs.next()) {
            Auto auto = new Auto();
            auto.setAtype(rs.getString("tno"));
            auto.setAutocard(rs.getString("autocard"));
            auto.setBname(rs.getString("bno"));
            auto.setColor(rs.getString("color"));
            auto.setDayrent(rs.getDouble("dayrent"));
            auto.setGear(rs.getString("gear"));
            auto.setSeat(rs.getInt("seat"));
            auto.setTname(rs.getString("tname"));
            auto.setTubo(rs.getString("tubo"));
            auto.setPic(rs.getString("pic"));
            autos.add(auto);
        }
        ps.close();
        rs.close();
        return autos;
    }*/
}
