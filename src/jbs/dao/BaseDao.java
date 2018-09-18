package jbs.dao;


import jbs.util.DbInfo;

import java.sql.*;

public class BaseDao {
    protected Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void openConnection() throws ClassNotFoundException,SQLException,Exception {
        if(conn == null || conn.isClosed()) {
            DbInfo dbinfo = DbInfo.newInstance();
            Class.forName(dbinfo.getDbdriver());
            conn = DriverManager.getConnection(dbinfo.getDburl(),dbinfo.getUsername(),dbinfo.getPassword());
        }
    }
    public void commit() throws Exception {
        this.conn.commit();
    }
    public void rollback() throws Exception {
        this.conn.rollback();
    }
    public void beginTransaction() throws Exception {
        this.openConnection();
        this.conn.setAutoCommit(false);
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
    public String getOracleTurnPageSql(String sql ,int iStart,int iEnd){

        String newSql = "select * from ( select rownum rw ,tb.* from ("  +  sql
                + ")tb) where rw>=" + iStart + " and rw<" + iEnd;

        return newSql;
    }

    public int getSqlAllRows(String sql) throws Exception{
        int rows = 0;

        String newsql = "select count(*) from ( " + sql + ")";
        this.openConnection();
        PreparedStatement ps = this.conn.prepareStatement(newsql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            rows = rs.getInt(1);
        }
        rs.close();
        ps.close();

        return rows;
    }
}
