package jbs.dao;

import jbs.Entity.TurnPage;
import jbs.dto.BackListInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BackListDao extends BaseDao{
    public List<BackListInfo> getBackListInfo(String rno, String sno, String cno, String autocard, TurnPage tp) throws Exception {
        List<BackListInfo> listInfo;
        String sql = "select rl.rno,rl.sno,rd.cno,rd.autocard,rl.rdate,rl.rdays,bl.bdate,bl.realmoney " +
                "from rentlist rl,rentdetail rd,backlist bl " +
                "where rl.rno = rd.rno and rl.rno = bl.rno";
        if(sno!=null&&!sno.equals("")){
            sql = sql + " and rl.sno like '%"+sno+"%'";
        }
        if(rno!=null&&!rno.equals("")){
            sql = sql + " and rl.rno like '%"+rno+"%'";
        }
        if(cno!=null&&!cno.equals("")){
            sql = sql + " and rl.cno like '%"+cno+"%'";
        }
        if(autocard!=null&&!autocard.equals("")){
            sql = sql + " and rd.autocard like '%"+autocard+"%'";
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
        listInfo = new ArrayList<BackListInfo>();
        while(rs.next()){
            BackListInfo backListInfo = new BackListInfo();
            backListInfo.setRno(rs.getString("rno"));
            backListInfo.setSno(rs.getString("sno"));
            backListInfo.setCno(rs.getString("cno"));
            backListInfo.setAutocard(rs.getString("autocard"));
            backListInfo.setRdate(rs.getTimestamp("rdate"));
            backListInfo.setRdays(rs.getInt("rdays"));
            backListInfo.setBdate(rs.getTimestamp("bdate"));
            backListInfo.setRealmoney(rs.getDouble("realmoney"));
            listInfo.add(backListInfo);
        }
        rs.close();
        ps.close();
        return listInfo;
    }

    public BackListInfo getBackDetail(String rno) throws Exception {
        BackListInfo backListInfo = null;
        this.openConnection();
        String sql = "select rl.rno,rl.sno,rd.cno,rd.autocard,rl.rdate,rl.rdays,bl.bdate,bl.realmoney " +
                "from rentlist rl,rentdetail rd,backlist bl " +
                "where rl.rno = rd.rno and rl.rno = bl.rno and bl.rno = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            backListInfo = new BackListInfo();
            backListInfo.setRno(rs.getString("rno"));
            backListInfo.setSno(rs.getString("sno"));
            backListInfo.setCno(rs.getString("cno"));
            backListInfo.setAutocard(rs.getString("autocard"));
            backListInfo.setRdate(rs.getTimestamp("rdate"));
            backListInfo.setRdays(rs.getInt("rdays"));
            backListInfo.setBdate(rs.getTimestamp("bdate"));
            backListInfo.setRealmoney(rs.getDouble("realmoney"));
            break;
        }
        rs.close();
        ps.close();
        return backListInfo;
    }

    public boolean BackDelete(BackListInfo backlist) throws Exception {
        boolean b;
        this.openConnection();
        String sql = "delete from backlist where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,backlist.getRno());
        int count = ps.executeUpdate();
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }
}
