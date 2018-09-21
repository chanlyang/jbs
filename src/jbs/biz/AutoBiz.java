package jbs.biz;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.Entity.TurnPage;
import jbs.dao.AutoDao;
import jbs.dto.AutoInfo;

import java.sql.SQLException;
import java.util.List;

public class AutoBiz {
    /**
     * 查看车辆信息
     * @param atype
     * @param bname
     * @param tname
     * @param tubo
     * @param tp
     * @return
     * @throws Exception
     */
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

    /**
     * 添加车辆
     * @param auto
     * @throws Exception
     */
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

    /**
     * 查看车辆类型
     * @return
     * @throws Exception
     */
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

    /**
     * 查看车辆品牌
     * @return
     * @throws Exception
     */
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

    /**
     * 查看某辆车辆细节
     * @param autocard
     * @return
     * @throws Exception
     */
    public Auto getAutoDetail(String autocard) throws Exception {
        Auto auto;
        AutoDao dao = new AutoDao();
        try{
            auto = dao.getAutoDetail(autocard);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return auto;
    }

    public int AutoUpdate(Auto auto) throws Exception {
        int iRet;
        AutoDao dao = new AutoDao();
        try{
            iRet = dao.AutoUpdate(auto);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return iRet;
    }
}
