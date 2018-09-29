package jbs.biz;

import jbs.Entity.ChangeList;
import jbs.Entity.RentDetail;
import jbs.Entity.RentList;
import jbs.Entity.TurnPage;
import jbs.dao.RentListDao;
import jbs.dto.RentListInfo;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RentListBiz {
    /**
     * 管理员租赁单查询
     * @param rno
     * @param suname
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentListInfo(String rno,String suname,String cuname,String autocard,TurnPage tp) throws Exception{
        List<RentListInfo> rentListInfoList;
        RentListDao dao = new RentListDao();
        try{
            rentListInfoList = dao.getRentListInfo(rno,suname,cuname,autocard,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rentListInfoList;
    }

    /**
     * 管理员租赁单详细查询
     * @param rno
     * @return
     * @throws Exception
     */
    public RentListInfo getRentDetail(String rno) throws Exception {
        RentListInfo rentListInfo;
        RentListDao dao = new RentListDao();
        try{
            rentListInfo = dao.getRentDetail(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rentListInfo;
    }

    /**
     * 管理员删除单条租赁单
     * @param rentlist
     * @return
     * @throws Exception
     */
    public boolean RentDelete(RentListInfo rentlist) throws Exception {
        boolean b;
        RentListDao dao = new RentListDao();
        try {
            b = dao.RentDelete(rentlist);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

    /**
     * 获取员工登录对应的员工号
     * @param uname
     * @return
     * @throws Exception
     */
    public String getUname(String uname) throws Exception {
        RentListDao dao = new RentListDao();
        try {
            uname = dao.getUname(uname);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return uname;
    }

    /**
     * 员工租赁单查询
     * @param rno
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentList(String rno,String cuname,String autocard,TurnPage tp) throws Exception{
        List<RentListInfo> rentListInfoList;
        RentListDao dao = new RentListDao();
        try{
            rentListInfoList = dao.getRentList(rno,cuname,autocard,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rentListInfoList;
    }

    /**
     * 员工租赁单详细查询
     * @param rno
     * @return
     * @throws Exception
     */
    public RentListInfo getRentListDetail(String rno) throws Exception {
        RentListInfo rentListInfo;
        RentListDao dao = new RentListDao();
        try{
            rentListInfo = dao.getRentListDetail(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rentListInfo;
    }

    /**
     * 员工生成租赁单（计算总金额）
     * @param suname
     * @param rno
     * @param allmoney
     * @throws Exception
     */
    public void makeRentList(String suname,String rno,double allmoney) throws Exception {
        RentListDao dao = new RentListDao();
        try{
            dao.makeRentList(suname,rno,allmoney);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
    }

    /**
     * 更改汽车状态（未出租状态为1，已出租状态为0）
     * @param rno
     * @return
     * @throws Exception
     */
    public int updateState(String rno) throws Exception{
        int iRet;
        RentListDao dao = new RentListDao();
        try{
            iRet = dao.updateState(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return iRet;
    }

    /**
     * 获得租赁单号（从租赁单中）
     * @return
     * @throws Exception
     */
    public List<RentList> getRnoList() throws Exception{
        List<RentList> rlist;
        RentListDao dao = new RentListDao();
        try{
            rlist = dao.getRnoList();
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rlist;
    }

    /**
     * 获得车牌号
     * @param rno
     * @return
     * @throws Exception
     */
    public String getAutocard(String rno) throws Exception {
        String autocard;
        RentListDao dao = new RentListDao();
        try{
            autocard = dao.getAutocard(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return autocard;
    }

    /**
     * 获得员工用户名
     * @param uname
     * @return
     * @throws Exception
     */
    public String getStaffName(String uname) throws Exception{
        String sname;
        RentListDao dao = new RentListDao();
        try{
            sname = dao.getStaffName(uname);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return sname;
    }

    /**
     * 添加汽车变更记录
     * @param changeList
     * @throws Exception
     */
    public void addChangeList(ChangeList changeList) throws Exception{
        RentListDao dao = new RentListDao();
        try{
            dao.addChangeList(changeList);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
    }

    /**
     * 获取汽车变更记录
     * @param rno
     * @param tp
     * @return
     * @throws Exception
     */
    public List<ChangeList> getChangeList(String rno,TurnPage tp) throws Exception{
        List<ChangeList> changeList;
        RentListDao dao = new RentListDao();
        try{
            changeList = dao.getChangeList(rno,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return changeList;
    }

    /**
     * 修改汽车变更记录
     * @param changeList
     * @return
     * @throws Exception
     */
    public int changeListUpdate(ChangeList changeList) throws Exception {
        int iRet;
        RentListDao dao = new RentListDao();
        try{
            iRet = dao.changeListUpdate(changeList);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return iRet;
    }

    /**
     * 获取单条汽车变更记录
     * @param rno
     * @return
     * @throws Exception
     */
    public ChangeList getClist(String rno) throws Exception {
        ChangeList cList;
        RentListDao dao = new RentListDao();
        try{
            cList = dao.getClist(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return cList;
    }

    /**
     * 修改车牌号汽车变更（）
     * @param autocard
     * @param rno
     * @return
     * @throws Exception
     */
    public int autocardUpdate(String autocard,String rno) throws Exception {
        int iRet;
        RentListDao dao = new RentListDao();
        try{
            iRet = dao.autocardUpdate(autocard,rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return iRet;
    }

    /**
     * 获取全部租赁单信息
     * @param rno
     * @param suname
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
    public List<RentListInfo> getRentAllList(String rno,String suname,String cuname,String autocard,TurnPage tp) throws Exception {
        List<RentListInfo> rentListInfos;
        RentListDao dao = new RentListDao();
        try{
            rentListInfos = dao.getRentAllList(rno,suname,cuname,autocard,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rentListInfos;
    }

    /**
     * 获取单条租赁单详细信息
     * @param rno
     * @return
     * @throws Exception
     */
    public RentDetail getRentDetailDetail(String rno) throws Exception {
        RentDetail rentDetail;
        RentListDao dao = new RentListDao();
        try{
            rentDetail = dao.getRentDetailDetail(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return rentDetail;
    }

    /**
     * 获取租赁单号（用于校验）
     * @param rno
     * @return
     * @throws Exception
     */
    public String getRno(String rno) throws Exception{
        String newrno;
        RentListDao dao = new RentListDao();
        try {
            newrno = dao.getRno(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return newrno;
    }
}
