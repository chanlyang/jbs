package jbs.dao;

import jbs.Entity.Auto;
import jbs.Entity.TurnPage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutoDao extends BaseDao{
    public List<Auto> getAutoInfo(String atype, String bname, String tname, TurnPage tp) throws Exception{
        List<Auto> alist;
        String sql = "select a.autocard,c.atype,b.bname,a.tname,a.color,a.seat,a.gear,a.tubo,a.dayrent from auto a,brand b,autotype c where a.bno = b.bno and a.tno = c.tno";
        if(atype!=null&&!atype.equals("")){
            sql = sql+"and c.atype like '%"+atype+"%'";
        }
        if(bname!=null&&!bname.equals("")){
            sql = sql +"and b.bname like '%"+bname+"%'";
        }
        if(tname!=null&&!tname.equals("")){
            sql = sql +"and a.tname like '%" + tname+"%'";
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
        alist = new ArrayList<Auto>();
        while(rs.next()){
            Auto auto = new Auto();
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
}
