package jbs.dao;

import jbs.Entity.*;
import jbs.dto.RentListInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RentListDao extends BaseDao{
    /**
     * 管理员租赁单查询
     * @param rno
     * @param suname
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentListInfo(String rno,String suname,String cuname,String autocard,TurnPage tp) throws Exception {
        List<RentListInfo> listInfo;
        String sql = "select rl.rno,rl.uname s,rd.uname c,rd.autocard,rd.rdate,rd.rdays,rl.allmoney " +
                "from rentlist rl,rentdetail rd " +
                "where rl.rno = rd.rno";
        if(suname!=null&&!suname.equals("")){
            sql = sql + " and rl.uname like '%"+suname+"%'";
        }
        if(rno!=null&&!rno.equals("")){
            sql = sql + " and rl.rno like '%"+rno+"%'";
        }
        if(cuname!=null&&!cuname.equals("")){
            sql = sql + " and rl.uname like '%"+cuname+"%'";
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
            rentListInfo.setSuname(rs.getString("s"));
            rentListInfo.setCuname(rs.getString("c"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
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
        String sql = "select rl.rno,rl.uname s,rd.uname c,rd.autocard,rd.rdate,rd.rdays,rl.allmoney" +
                " from rentlist rl,rentdetail rd" +
                " where rl.rno = rd.rno and rd.rno = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            rentListInfo = new RentListInfo();
            rentListInfo.setRno(rs.getString("rno"));
            rentListInfo.setSuname(rs.getString("s"));
            rentListInfo.setCuname(rs.getString("c"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
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
    public String getUname(String uname) throws Exception {
        this.openConnection();
        String sql = "select s.uname from ulogin u,staff s where u.uname = s.uname and s.uname = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Staff staff = new Staff();
            staff.setUname(rs.getString("uname"));
            break;
        }
        rs.close();
        ps.close();
        return uname;
    }

    /**
     * 员工租赁单查询
     * @param rno
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentList(String rno,String cuname,String autocard,TurnPage tp) throws Exception{
        List<RentListInfo> listInfo;
        String sql = "select rno,autocard,uname,rdate,rdays from rentdetail where state=1";
        if(rno!=null&&!rno.equals("")){
            sql = sql + " and rd.rno like '%"+rno+"%'";
        }
        if(cuname!=null&&!cuname.equals("")){
            sql = sql + " and rl.uname like '%"+cuname+"%'";
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
            rentListInfo.setCuname(rs.getString("uname"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
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
        String sql = "select rd.rno,rd.rdate,rd.rdays,rl.allmoney,rl.uname from rentlist rl,rentdetail rd where rl.rno = rd.rno and rd.rno = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            rentListInfo = new RentListInfo();
            rentListInfo.setRno(rs.getString("rno"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
            rentListInfo.setSuname(rs.getString("uname"));
            break;
        }
        rs.close();
        ps.close();
        return rentListInfo;
    }

    public void makeRentList(String suname,String rno,double allmoney) throws Exception {
        this.openConnection();
        String sql = "insert into rentlist(rno,allmoney,uname) values(?,?,?)";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ps.setDouble(2,allmoney);
        ps.setString(3,suname);
        ps.executeUpdate();
        ps.close();
    }
    public int updateState(String rno) throws Exception{
        int iRet;
        this.openConnection();
        String sql = "update rentdetail set state=0 where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        iRet = ps.executeUpdate();
        return iRet;
    }

    public List<RentList> getRnoList() throws Exception{
        List<RentList> rlist;
        String sql = "select rno from rentlist";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rlist = new ArrayList<RentList>();
        while(rs.next()){
            RentList rent = new RentList();
            rent.setRno(rs.getString("rno"));
            rlist.add(rent);
        }
        rs.close();
        ps.close();
        return rlist;
    }

    public String getAutocard(String rno) throws Exception {
        String autocard = null;
        this.openConnection();
        String sql = "select autocard from rentdetail where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            autocard = rs.getString("autocard");
            break;
        }
        ps.close();
        return autocard;
    }

    public String getStaffName(String uname) throws Exception{
        String sname = null;
        this.openConnection();
        String sql = "select sname from staff where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sname = rs.getString("sname");
            break;
        }
        ps.close();
        return sname;
    }

    public void addChangeList(ChangeList changeList) throws Exception{
        String sql = "insert into changelist(rno,pautocard,nautocard,person,ctime) values(?,?,?,?,?) ";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,changeList.getRno());
        ps.setString(2,changeList.getPautocard());
        ps.setString(3,changeList.getNautocard());
        ps.setString(4,changeList.getPerson());
        if(changeList.getCdate()!=null){
            ps.setDate(5,new java.sql.Date(changeList.getCdate().getTime()));
        }else{
            ps.setDate(5,null);
        }
        ps.executeUpdate();
        ps.close();
    }

    public List<ChangeList> getChangeList(String rno,TurnPage tp) throws Exception{
        List<ChangeList> changeList;
        String sql = "select rno,pautocard,nautocard,person,ctime from changelist";
        if(rno!=null&&!rno.equals("")){
            sql = sql + " where rno="+rno;
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
        changeList = new ArrayList<ChangeList>();
        while(rs.next()){
            ChangeList cList = new ChangeList();
            cList.setRno(rs.getString("rno"));
            cList.setPautocard(rs.getString("pautocard"));
            cList.setNautocard(rs.getString("nautocard"));
            cList.setPerson(rs.getString("person"));
            cList.setCdate(rs.getTimestamp("ctime"));
            changeList.add(cList);
        }
        rs.close();
        ps.close();
        return changeList;
    }

    public int changeListUpdate(ChangeList changeList) throws Exception {
        int iRet;
        this.openConnection();
        String sql = "update changelist set nautocard=? where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,changeList.getNautocard());
        ps.setString(2,changeList.getRno());
        iRet = ps.executeUpdate();
        ps.close();
        return iRet;
    }

    public ChangeList getClist(String rno) throws Exception {
        ChangeList cList = null;
        this.openConnection();
        String sql = "select rno,pautocard,nautocard,person,cdate from changelist where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            cList = new ChangeList();
            cList.setRno(rs.getString("rno"));
            cList.setPautocard(rs.getString("pautocard"));
            cList.setNautocard(rs.getString("nautocard"));
            cList.setPerson(rs.getString("person"));
            cList.setCdate(rs.getTimestamp("cdate"));
            break;
        }
        rs.close();
        ps.close();
        return cList;
    }

    public int autocardUpdate(String autocard,String rno) throws Exception {
        int iRet;
        this.openConnection();
        String sql = "update rentdetail set autocard=? where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,autocard);
        ps.setString(2,rno);
        iRet = ps.executeUpdate();
        ps.close();
        return iRet;
    }

    public List<RentListInfo> getRentAllList(String rno,String suname,String cuname,String autocard,TurnPage tp) throws Exception {
        List<RentListInfo> listInfo;
        String sql = "select rl.rno,rd.uname,rd.autocard,rd.rdate,rd.rdays,rl.allmoney" +
                " from rentlist rl,rentdetail rd" +
                " where rl.rno = rd.rno and rl.uname = '"+ suname+"'";
        if(rno!=null&&!rno.equals("")){
            sql = sql + " and rl.rno like '%"+rno+"%'";
        }
        if(cuname!=null&&!cuname.equals("")){
            sql = sql + " and rd.uname like '%"+cuname+"%'";
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
            rentListInfo.setCuname(rs.getString("uname"));
            rentListInfo.setAutocard(rs.getString("autocard"));
            rentListInfo.setRdate(rs.getTimestamp("rdate"));
            rentListInfo.setRdays(rs.getInt("rdays"));
            rentListInfo.setAllmoney(rs.getDouble("allmoney"));
            listInfo.add(rentListInfo);
        }
        rs.close();
        ps.close();
        return listInfo;
    }

    public RentDetail getRentDetailDetail(String rno) throws Exception {
        RentDetail rentDetail = null;
        this.openConnection();
        String sql = "select rno,autocard,uname,rdate,rdays from rentdetail where rno=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            rentDetail = new RentDetail();
            rentDetail.setRno(rs.getString("rno"));
            rentDetail.setAutocard(rs.getString("autocard"));
            rentDetail.setUname(rs.getString("uname"));
            rentDetail.setRdate(rs.getTimestamp("rdate"));
            rentDetail.setRdays(rs.getInt("rdays"));
            break;
        }
        rs.close();
        ps.close();
        return rentDetail;
    }

    public String getRno(String rno) throws Exception{
        String newrno = null;
        this.openConnection();
        String sql = "select rno from rentlist where rno = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,rno);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            newrno = rs.getString("rno");
            break;
        }
        rs.close();
        ps.close();
        return newrno;
    }
}
