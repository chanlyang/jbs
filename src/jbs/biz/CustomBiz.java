package jbs.biz;

import jbs.Entity.Auto;
import jbs.Entity.TurnPage;
import jbs.dao.BaseDao;
import jbs.dao.CustomDAO;
import jbs.dto.AutoInfo;

import java.util.List;

public class CustomBiz {

    public List<Auto> quaryAllCars() throws Exception{
        BaseDao dao = new CustomDAO();
        List<Auto> autos;
        try{
             autos = ((CustomDAO) dao).queryAllCars();
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }

    public List<AutoInfo> quaryCarsByType(TurnPage tp,String type) throws Exception{
        BaseDao dao = new CustomDAO();
        List<AutoInfo> autos;
        try{
            autos = ((CustomDAO) dao).quaryCarsByType(tp,type);
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }

   /* public List<Auto> quaryCarsByType2(TurnPage tp) throws Exception{
        BaseDao dao = new CustomDAO();
        List<Auto> autos;
        try{
            autos = ((CustomDAO) dao).quaryCarsByType2(tp);
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }

    public List<Auto> quaryCarsByType3(TurnPage tp) throws Exception{
        BaseDao dao = new CustomDAO();
        List<Auto> autos;
        try{
            autos = ((CustomDAO) dao).quaryCarsByType3(tp);
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }*/
}
