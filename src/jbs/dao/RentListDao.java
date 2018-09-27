package jbs.dao;

import jbs.Entity.Staff;
import jbs.Entity.TurnPage;
import jbs.dto.RentListInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RentListDao extends BaseDao{
    /**
     * 管理员租赁单查询
     * @param rno
     * @param sno
     * @param cno
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentListInfo(String rno,String sno,String cno,String autocard,TurnPage tp) throws Exception {
        List<RentListInfo> listInfo;
        String sql = "select rl.rno,rl.sno,rd.cno,rd.autocard,rl.rdate,rl.rdays,rl.allmoney,rl.extra " +
                "from rentlist rl,rentdetail rd " +
                "where rl.rno = rd.rno";
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
        listInfo = new ArrayList<RentListInfo>();
        while(rs.next()){
            RentListInfo rentListInfo = new RentListInfo();
            rentListInfo.setRno(rs.getString("rno"));
            rentListInfo.setSno(rs.getString("sno"));
            rentListInfo.setCno(rs.getString("cno"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
            rentListInfo.setExtra(rs.getDouble("extra"));
            listInfo.add(rentListInfo);
        }
        rs.close();
        ps.close();
        return listInfo;
    }

    /**
     * 管理员租赁单详细查询
     * @param rno
     * @return
     * @throws Exception
     */
    public RentListInfo getRentDetail(String rno) throws Exception {
        RentListInfo rentListInfo = null;
        this.openConnection();
        String sql = "select rl.rno,rl.sno,rd.cno,rd.autocard,rl.rdate,rl.rdays,rl.allmoney,rl.extra " +
                "from rentlist rl,rentdetail rd " +
                "where rl.rno = rd.rno and rd.rno = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            rentListInfo = new RentListInfo();
            rentListInfo.setRno(rs.getString("rno"));
            rentListInfo.setSno(rs.getString("sno"));
            rentListInfo.setCno(rs.getString("cno"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
            rentListInfo.setExtra(rs.getDouble("extra"));
            break;
        }
        rs.close();
        ps.close();
        return rentListInfo;
    }

    /**
     * 管理员租赁单删除
     * @param rentlist
     * @return
     * @throws Exception
     */
    public boolean RentDelete(RentListInfo rentlist) throws Exception {
        boolean b;
        this.openConnection();
        String sql = "delete from rentlist where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rentlist.getRno());
        int count = ps.executeUpdate();
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }

    /**
     * 获取员工登录对应的员工号
     * @param uname
     * @return
     * @throws Exception
     */
    public String getSno(String uname) throws Exception {
        String sno = null;
        this.openConnection();
        String sql = "select s.sno from ulogin u,staff s where u.uname = s.uname and u.uname = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Staff staff = new Staff();
            staff.setSno(rs.getString("sno"));
            break;
        }
        rs.close();
        ps.close();
        return sno;
    }

    /**
     * 员工租赁单查询
     * @param rno
     * @param sno
     * @param cno
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentList(String rno,String sno,String cno,String autocard,TurnPage tp) throws Exception{
        List<RentListInfo> listInfo;
        String sql = "select rl.rno,rl.sno,rd.cno,rd.autocard,rl.rdate,rl.rdays,rl.allmoney,rl.extra " +
                "from rentlist rl,rentdetail rd " +
                "where rl.rno = rd.rno and rl.sno = ?";
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
        ps.setString(1,sno);
        ResultSet rs = ps.executeQuery();
        listInfo = new ArrayList<RentListInfo>();
        while(rs.next()){
            RentListInfo rentListInfo = new RentListInfo();
            rentListInfo.setRno(rs.getString("rno"));
            rentListInfo.setCno(rs.getString("cno"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
            rentListInfo.setExtra(rs.getDouble("extra"));
            listInfo.add(rentListInfo);
        }
        rs.close();
        ps.close();
        return listInfo;
    }

    /**
     * 员工租赁单详细查询
     * @param rno
     * @return
     * @throws Exception
     */
    public RentListInfo getRentListDetail(String rno) throws Exception {
        RentListInfo rentListInfo = null;
        this.openConnection();
        String sql = "select rno,rdate,rdays,allmoney,extra from rentlist where rno = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            rentListInfo = new RentListInfo();
            rentListInfo.setRno(rs.getString("rno"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
            rentListInfo.setExtra(rs.getDouble("extra"));
            break;
        }
        rs.close();
        ps.close();
        return rentListInfo;
    }

    public int calAllmoney(String rno,double allmoney) throws Exception {
        int count;
        this.openConnection();
        String sql = "update rentlist set allmoney=? where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setDouble(1,allmoney);
        ps.setString(2,rno);
        count = ps.executeUpdate();
        ps.close();
        return count;
    }
}
