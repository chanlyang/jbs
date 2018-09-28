package jbs.dao;



import jbs.Entity.Custom;
import jbs.Entity.Staff;
import jbs.Entity.TurnPage;
import jbs.Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao extends BaseDao{
    /**
     * 登录
     * @param uname
     * @param pwd
     * @return
     * @throws Exception
     */
    public User login(String uname, String pwd) throws Exception {
        User user = null;
        String sql = "select * from ulogin where uname='" + uname + "' and pwd='" + pwd + "'";
        this.openConnection();
        Statement st = this.conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        user = new User();
        while(rs.next()) {
            //如果进入这个循环，说明已经登陆成功
            user.setUname(uname);
            user.setPassword(pwd);
            user.setUrole(rs.getInt("urole"));
        }
        rs.close();
        st.close();
        return user;
    }
    /**
     * 查看客户信息
     * @param uname
     * @param cname
     * @param birthday
     * @param tp
     * @return
     * @throws Exception
     */
    public List<Custom> getCustomInfo(String uname, String cname, Date birthday, TurnPage tp) throws Exception{
        List<Custom> clist;
        String sql = "select uname,cname,cidcard,phonenum,birthday from constom";
        if(uname != null && !uname.trim().equals("")){
            sql = sql + " where uname like '%" + uname + "%'";
        }
        if(cname!=null&&!cname.trim().equals("")){
            sql = sql + " where cname like '%" + cname +"%'";
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        if(birthday != null){
            sql = sql + " where birthday = to_date('" + sd.format(birthday)+ "','yyyymmdd')";
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
        clist = new ArrayList<Custom>();
        while(rs.next()){
            Custom custom = new Custom();
            custom.setUname(rs.getString("uname"));
            custom.setCname(rs.getString("cname"));
            custom.setCidcard(rs.getString("cidcard"));
            custom.setPhonenum(rs.getString("phonenum"));
            custom.setBirthday(rs.getTimestamp("birthday"));
            clist.add(custom);
        }
        rs.close();
        ps.close();
        return clist;
    }

    public List<Staff> getStaffInfo(String uname,String sname,String sex,TurnPage tp) throws Exception{
        List<Staff> slist;
        String sql = "select uname,sname,sex,phonenum,sidcard,birthday from staff";
        if(uname!=null&&!uname.equals("")){
            sql = sql+" where uname like '%"+uname+"%'";
        }
        if(sname!=null&&sname.equals("")){
            sql = sql + " where sname like '%"+sname+"%'";
        }
        if(sex!=null&&!sex.equals("")){
            sql = sql+" where sex="+sex;
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
        slist = new ArrayList<Staff>();
        while(rs.next()){
           Staff staff = new Staff();
           staff.setUname(rs.getString("uname"));
           staff.setSname(rs.getString("sname"));
           staff.setSex(rs.getString("sex"));
           staff.setPhonenum(rs.getString("phonenum"));
           staff.setSidcard(rs.getString("sidcard"));
           staff.setBirthday(rs.getTimestamp("birthday"));
           slist.add(staff);
        }
        ps.close();
        rs.close();
        return slist;
    }
    public Staff getStaffDetail(String uname) throws Exception {
        Staff staff = null;
        this.openConnection();
        String sql = "select uname,sname,sex,phonenum,sidcard,birthday from staff where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            staff = new Staff();
            staff.setUname(rs.getString("uname"));
            staff.setSname(rs.getString("sname"));
            staff.setSex(rs.getString("sex"));
            staff.setPhonenum(rs.getString("phonenum"));
            staff.setSidcard(rs.getString("sidcard"));
            staff.setBirthday(rs.getTimestamp("birthday"));
            break;
        }
        rs.close();
        ps.close();
        return staff;
    }

    public Custom getCustomDetail(String uname) throws Exception {
        Custom custom = null;
        this.openConnection();
        String sql = "select uname,cname,cidcard,phonenum,birthday from constom where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,uname);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            custom = new Custom();
            custom.setUname(rs.getString("uname"));
            custom.setCname(rs.getString("cname"));
            custom.setCidcard(rs.getString("cidcard"));
            custom.setPhonenum(rs.getString("phonenum"));
            custom.setBirthday(rs.getTimestamp("birthday"));
            break;
        }
        rs.close();
        ps.close();
        return custom;
    }

    public int CustomUpdate(Custom custom) throws Exception {
        int iRet;
        this.openConnection();
        String sql = "update constom set uname=?,cname=?,cidcard=?,phonenum=?,birthday=? where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,custom.getUname());
        ps.setString(2,custom.getCname());
        ps.setString(3,custom.getCidcard());
        ps.setString(4,custom.getPhonenum());
        if(custom.getBirthday()!=null) {
            ps.setDate(5, new java.sql.Date(custom.getBirthday().getTime()));
        }else{
            ps.setDate(5,null);
        }
        ps.setString(6,custom.getUname());
        iRet = ps.executeUpdate();
        ps.close();
        return iRet;
    }

    public boolean CustomDelete(Custom custom) throws Exception {
        boolean b;
        this.openConnection();
        String sql = "delete from constom where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,custom.getUname());
        int count = ps.executeUpdate();
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }

    public int StaffUpdate(Staff staff) throws Exception {
        int iRet;
        this.openConnection();
        String sql = "update staff set uname=?,sname=?,sex=?,phonenum=?,sidcard=?,birthday=? where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,staff.getUname());
        ps.setString(2,staff.getSname());
        ps.setString(3,staff.getSex());
        ps.setString(4,staff.getPhonenum());
        ps.setString(5,staff.getSidcard());
        if(staff.getBirthday()!=null) {
            ps.setDate(6, new java.sql.Date(staff.getBirthday().getTime()));
        }else{
            ps.setDate(6,null);
        }
        ps.setString(7,staff.getUname());
        iRet = ps.executeUpdate();
        ps.close();
        return iRet;
    }
    public boolean StaffDelete(Staff staff) throws Exception {
        boolean b;
        this.openConnection();
        String sql = "delete from staff where uname=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,staff.getUname());
        int count = ps.executeUpdate();
        if(count>0) b = true;
        else b = false;
        ps.close();
        return b;
    }
}
