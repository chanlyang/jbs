package jbs.biz;

import jbs.Entity.BackList;
import jbs.Entity.TurnPage;
import jbs.dao.BackListDao;
import jbs.dto.BackListInfo;

import java.util.List;

public class BackListBiz {
    /**
     * 获取还车列表信息（包含员工信息）
     * @param rno
     * @param suname
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
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

    /**
     * 获取还车单条记录详细信息
     * @param rno
     * @return
     * @throws Exception
     */
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

    /**
     * 删除还车单条记录
     * @param backlist
     * @return
     * @throws Exception
     */
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

    /**
     * 获取还车列表信息
     * @param rno
     * @param suname
     * @param cuname
     * @param autocard
     * @param tp
     * @return
     * @throws Exception
     */
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

    /**
     * 获取还车单条详细信息
     * @param rno
     * @return
     * @throws Exception
     */
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

    /**
     * 添加还车单
     * @param backList
     * @throws Exception
     */
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
