package jbs.biz;

import jbs.Entity.*;
import jbs.dao.AutoDao;
import jbs.dto.AutoInfo;

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

    /**
     * 修改汽车信息
     * @param auto
     * @return
     * @throws Exception
     */
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

    /**
     * 删除汽车信息
     * @param auto
     * @return
     * @throws Exception
     */
    public boolean AutoDelete(Auto auto) throws Exception {
        boolean b;
        AutoDao dao = new AutoDao();
        try {
            b = dao.AutoDelete(auto);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

    /**
     * 批量删除汽车信息
     * @param autocards
     * @return
     * @throws Exception
     */
    public boolean AutoDeleteAll(String[] autocards) throws Exception {
        boolean b;
        AutoDao dao = new AutoDao();
        try {
            b = dao.AutoDeleteAll(autocards);
        } catch (Exception e) {
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

    /**
     * 添加租金变更记录
     * @param changeMoney
     * @throws Exception
     */
    public void addChangeMoney(ChangeMoney changeMoney) throws Exception {
        AutoDao dao = new AutoDao();
        try {
            dao.addChangeMoney(changeMoney);
        } catch (Exception e) {
            throw e;
        }finally{
            dao.closeConnection();
        }
    }

    /**
     * 租金变更记录列表查询
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<ChangeMoney> changeMoneyQuery(String autocard,TurnPage tp) throws Exception {
        List<ChangeMoney> changeMoneyList;
        AutoDao dao = new AutoDao();
        try{
            changeMoneyList = dao.ChangeMoneyQuery(autocard,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return changeMoneyList;
    }

    /**
     * 查看租金变更记录详细
     * @param cid
     * @return
     * @throws Exception
     */
    public ChangeMoney getChangeMoneyDetail(String cid) throws Exception {
        ChangeMoney changeMoney;
        AutoDao dao = new AutoDao();
        try{
            changeMoney = dao.getChangeMoneyDetail(cid);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return changeMoney;
    }

    /**
     * 删除单条租金变更记录
     * @param changeMoney
     * @return
     * @throws Exception
     */
    public boolean ChangeMoneyDelete(ChangeMoney changeMoney) throws Exception {
        boolean b;
        AutoDao dao = new AutoDao();
        try {
            b = dao.ChangeMoneyDelete(changeMoney);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

    /**
     * 员工查询汽车列表
     * @param atype
     * @param bname
     * @param tname
     * @param tubo
     * @param tp
     * @return
     * @throws Exception
     */
    public List<AutoInfo> getStaffAutoInfo(String atype, String bname, String tname, String tubo,TurnPage tp) throws Exception{
        List<AutoInfo> alist;
        AutoDao dao = new AutoDao();
        try{
            alist = dao.getStaffAutoInfo(atype,bname,tname,tubo,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return alist;
    }
}
