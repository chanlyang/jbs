package jbs.biz;

import jbs.Entity.BackList;
import jbs.Entity.TurnPage;
import jbs.dao.BackListDao;
import jbs.dto.BackListInfo;

import java.util.List;

public class BackListBiz {
    public List<BackListInfo> getBackListInfo(String rno, String suname, String cuname, String autocard, TurnPage tp) throws Exception{
        List<BackListInfo> backListInfoList;
        BackListDao dao = new BackListDao();
        try{
            backListInfoList = dao.getBackListInfo(rno,suname,cuname,autocard,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return backListInfoList;
    }

    public BackListInfo getBackDetail(String rno) throws Exception {
        BackListInfo backListInfo;
        BackListDao dao = new BackListDao();
        try{
            backListInfo = dao.getBackDetail(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return backListInfo;
    }

    public boolean BackDelete(BackListInfo backlist) throws Exception {
        boolean b;
        BackListDao dao = new BackListDao();
        try {
            b = dao.BackDelete(backlist);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return b;
    }

    public List<BackListInfo> getBackList(String rno, String suname, String cuname, String autocard, TurnPage tp) throws Exception{
        List<BackListInfo> backListInfoList;
        BackListDao dao = new BackListDao();
        try{
            backListInfoList = dao.getBackList(rno,suname,cuname,autocard,tp);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return backListInfoList;
    }

    public BackListInfo getBackListDetail(String rno) throws Exception {
        BackListInfo backListInfo;
        BackListDao dao = new BackListDao();
        try{
            backListInfo = dao.getBackListDetail(rno);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }
        return backListInfo;
    }

    public void addBacklist(BackList backList) throws Exception{
        BackListDao dao = new BackListDao();
        try{
            dao.addBacklist(backList);
        }catch (Exception e){
            throw e;
        }finally {
            dao.closeConnection();
        }

    }
}
