package jbs.dao;

import java.sql.PreparedStatement;

public class LoginDao extends BaseDao {

    public void insertLoginInfo(String cno,String password,int role) throws Exception {
        String sql = "insert into ulogin values(?,?,?)";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,cno);
        ps.setString(2,password);
        ps.setInt(3,role);
        ps.executeUpdate();
        ps.close();
    }
}
