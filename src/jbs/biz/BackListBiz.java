package jbs.biz;

import jbs.Entity.TurnPage;
import jbs.dao.BackListDao;
import jbs.dto.BackListInfo;

import java.util.List;

public class BackListBiz {
    public List<BackListInfo> getBackListInfo(String rno, String sno, String cno, String autocard, TurnPage tp) throws Exception{
        List<BackListInfo> backListInfoList;
        BackListDao dao = new BackListDao();
        try{
            backListInfoList = dao.getBackListInfo(rno,sno,cno,autocard,tp);
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
}
