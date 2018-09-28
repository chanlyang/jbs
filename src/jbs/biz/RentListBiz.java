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
