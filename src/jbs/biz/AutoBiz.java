package jbs.biz;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.Entity.TurnPage;
import jbs.dao.AutoDao;
import jbs.dto.AutoInfo;

import java.util.List;

public class AutoBiz {
    public List<AutoInfo> getAutoInfo(String atype, String bname, String tname, String tubo,TurnPage tp) throws Exception{
        List<AutoInfo> alist;
        AutoDao dao = new AutoDao();
        try{
            alist = dao.getAutoInfo(atype,bname,tname,tubo,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return alist;
    }
    public void addAuto(Auto auto) throws Exception{
        AutoDao dao = new AutoDao();
        try {
            dao.addAuto(auto);
        } catch (Exception e) {
            throw e;
        }finally{
            dao.closeConnection();
        }
    }

    public List<AutoType> getAutoType() throws Exception {
        List<AutoType> atlist;
        AutoDao dao = new AutoDao();
        try{
            atlist = dao.getAutoType();
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return atlist;
    }

    public List<Brand> getBrand() throws Exception{
        List<Brand> blist;
        AutoDao dao = new AutoDao();
        try{
            blist = dao.getBrand();
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return blist;
    }
}
