package jbs.biz;

import jbs.Entity.TurnPage;
import jbs.dao.RentListDao;
import jbs.dto.RentListInfo;

import java.util.List;

public class RentListBiz {
    public List<RentListInfo> getRentListInfo(String rno,String sno,String cno,String autocard,TurnPage tp) throws Exception{
        List<RentListInfo> rentListInfoList;
        RentListDao dao = new RentListDao();
        try{
            rentListInfoList = dao.getRentListInfo(rno,sno,cno,autocard,tp);
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

    public String getSno(String uname) throws Exception {
        String sno;
        RentListDao dao = new RentListDao();
        try {
            sno = dao.getSno(uname);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return sno;
    }

    public List<RentListInfo> getRentList(String rno,String sno,String cno,String autocard,TurnPage tp) throws Exception{
        List<RentListInfo> rentListInfoList;
        RentListDao dao = new RentListDao();
        try{
            rentListInfoList = dao.getRentList(rno,sno,cno,autocard,tp);
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

    public int calAllmoney(String rno,double allmoney) throws Exception {
        int count;
        RentListDao dao = new RentListDao();
        try{
            count = dao.calAllmoney(rno,allmoney);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return count;
    }
}
