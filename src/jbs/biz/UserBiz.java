package jbs.biz;


import jbs.Entity.User;
import jbs.dao.UserDao;
import jbs.util.Log;

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
}
