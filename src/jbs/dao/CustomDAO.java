package jbs.dao;

import jbs.Entity.Auto;
import jbs.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomDAO extends BaseDao {

    /**
     * 查出所有车显示在主页
     * @return
     * @throws Exception
     */
    public List<Auto> queryAllCars() throws Exception {
        this.openConnection();
        List<Auto> autos;
        String sql = "select * from auto where autocard=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        Statement a = this.conn.createStatement();
        ps.setString(1,"甘F-88888");
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
            auto.setPic(rs.getString("pic"));
            autos.add(auto);
        }
        ps.close();
        rs.close();
        return autos;
    }

    public List<Auto> quaryCarsByType1() throws Exception{
        this.openConnection();
        List<Auto> autos;
        String sql = "select * from auto where tno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,"t002");
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

    public List<Auto> quaryCarsByType2() throws Exception{
        this.openConnection();
        List<Auto> autos;
        String sql = "select * from auto where tno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,"t001");
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
            auto.setPic(rs.getString("pic"));
            autos.add(auto);
        }
        ps.close();
        rs.close();
        return autos;

    }

    public List<Auto> quaryCarsByType3() throws Exception{
        this.openConnection();
        List<Auto> autos;
        String sql = "select * from auto where tno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,"t004");
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
            auto.setPic(rs.getString("pic"));
            autos.add(auto);
        }
        ps.close();
        rs.close();
        return autos;

    }
}
