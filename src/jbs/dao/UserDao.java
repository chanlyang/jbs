package jbs.dao;



import jbs.Entity.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao extends BaseDao{
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
}
