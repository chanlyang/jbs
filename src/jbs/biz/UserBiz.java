package jbs.biz;


import jbs.Entity.Custom;
import jbs.Entity.Staff;
import jbs.Entity.TurnPage;
import jbs.Entity.User;
import jbs.dao.UserDao;
import jbs.util.Log;

import java.util.Date;
import java.util.List;

public class UserBiz {
    public User login(String uname, String pwd) throws Exception {
        System.out.println(uname+" "+pwd);
        User user = null;
        if(uname != null && pwd!= null && !uname.equals("") && !pwd.equals("")) {
            UserDao dao = new UserDao();
            try {
                user = dao.login(uname, pwd);
            } catch (Exception e) {
                Log.logger.error(e.getMessage());
                throw e;
            }finally {
                //释放数据库的链接
                dao.closeConnection();
            }
        }
        return user;
    }
    public List<Custom> getCustomInfo(String cno, String cname, Date birthday, TurnPage tp) throws Exception {
        List<Custom> clist;
        UserDao dao = new UserDao();
        try {
            clist = dao.getCustomInfo(cno,cname,birthday,tp);
        } catch (Exception e) {
            throw e;
        }finally{
            dao.closeConnection();
        }
        return clist;
    }
    public List<Staff> getStaffInfo(String sno,String sname,String sex,TurnPage tp) throws Exception{
        List<Staff> sList;
        UserDao dao = new UserDao();
        try{
            sList = dao.getStaffInfo(sno,sname,sex,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return sList;
    }
}
