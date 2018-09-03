package jbs.dao;


import jbs.util.DbInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    protected Connection conn;

    public void openConnection() throws ClassNotFoundException,SQLException,Exception {
        if(conn == null || conn.isClosed()) {
            DbInfo dbinfo = DbInfo.newInstance();
            Class.forName(dbinfo.getDbdriver());
            conn = DriverManager.getConnection(dbinfo.getDburl(),dbinfo.getUsername(),dbinfo.getPassword());
        }
    }

    public void closeConnection() {
        if(this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
