package jbs.biz;


import jbs.Entity.Custom;
import jbs.Entity.Staff;
import jbs.Entity.TurnPage;
import jbs.Entity.User;
import jbs.dao.AutoDao;
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
    public List<Custom> getCustomInfo(String uname, String cname, Date birthday, TurnPage tp) throws Exception {
        List<Custom> clist;
        UserDao dao = new UserDao();
        try {
            clist = dao.getCustomInfo(uname,cname,birthday,tp);
        } catch (Exception e) {
            throw e;
        }finally{
            dao.closeConnection();
        }
        return clist;
    }
    public List<Staff> getStaffInfo(String uname,String sname,String sex,TurnPage tp) throws Exception{
        List<Staff> sList;
        UserDao dao = new UserDao();
        try{
            sList = dao.getStaffInfo(uname,sname,sex,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return sList;
    }

    public Staff getStaffDetail(String uname) throws Exception {
        Staff staff ;
        UserDao dao = new UserDao();
        try{
            staff = dao.getStaffDetail(uname);
        } catch (Exception e) {
            throw e;
        }finally {
            dao.closeConnection();
        }
        return staff;
    }

    public Custom getCustomDetail(String uname) throws Exception {
        Custom custom;
        UserDao dao = new UserDao();
        try{
            custom = dao.getCustomDetail(uname);
        } catch (Exception e) {
            throw e;
        }finally {
            dao.closeConnection();
        }
        return custom;
    }

    public int CustomUpdate(Custom custom) throws Exception {
        int iRet;
        UserDao dao = new UserDao();
        try{
            iRet = dao.CustomUpdate(custom);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return iRet;
    }

    public boolean CustomDelete(Custom custom) throws Exception {
        boolean b;
        UserDao dao = new UserDao();
        try {
            b = dao.CustomDelete(custom);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

    public int StaffUpdate(Staff staff) throws Exception {
        int iRet;
        UserDao dao = new UserDao();
        try{
            iRet = dao.StaffUpdate(staff);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return iRet;
    }

    public boolean StaffDelete(Staff staff) throws Exception {
        boolean b;
        UserDao dao = new UserDao();
        try {
            b = dao.StaffDelete(staff);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

}
