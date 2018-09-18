package jbs.biz;

import jbs.Entity.Auto;
import jbs.Entity.TurnPage;
import jbs.dao.AutoDao;

import java.util.List;

public class AutoBiz {
    public List<Auto> getAutoInfo(String atype, String bname, String tname, TurnPage tp) throws Exception{
        List<Auto> alist;
        AutoDao dao = new AutoDao();
        try{
            alist = dao.getAutoInfo(atype,bname,tname,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return alist;
    }
}
