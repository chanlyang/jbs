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
     * @param cno
     * @param cname
     * @param birthday
     * @param tp
     * @return
     * @throws Exception
     */
    public List<Custom> getCustomInfo(String cno, String cname, Date birthday, TurnPage tp) throws Exception{
        List<Custom> clist;
        String sql = "select cno,cname,cidcard,phonenum,birthday from constom";
        if(cno != null && !cno.trim().equals("")){
            sql = sql + " where cno like '%" + cno + "%'";
        }
        if(cname!=null&&!cname.trim().equals("")){
            sql = sql + "where cname like '%" + cname +"%'";
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        if(birthday != null){
            sql = sql + "where birthday = to_date('" + sd.format(birthday)+ "','yyyymmdd')";
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
            custom.setCno(rs.getString("cno"));
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

    public List<Staff> getStaffInfo(String sno,String sname,String sex,TurnPage tp) throws Exception{
        List<Staff> slist;
        String sql = "select sno,sname,sex,phonenum,sidcard,birthday from staff";
        if(sno!=null&&!sno.equals("")){
            sql = sql+"where sno like '%"+sno+"%'";
        }
        if(sname!=null&&sname.equals("")){
            sql = sql + "where sname like '%"+sname+"%'";
        }
        if(sex!=null&&!sex.equals("")){
            sql = sql+"where sex = "+sex;
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
           staff.setSno(rs.getString("sno"));
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
}
