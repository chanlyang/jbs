package jbs.biz;

import jbs.Entity.Auto;
import jbs.dao.BaseDao;
import jbs.dao.CustomDAO;

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

    public List<Auto> quaryCarsByType1() throws Exception{
        BaseDao dao = new CustomDAO();
        List<Auto> autos;
        try{
            autos = ((CustomDAO) dao).quaryCarsByType1();
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }

    public List<Auto> quaryCarsByType2() throws Exception{
        BaseDao dao = new CustomDAO();
        List<Auto> autos;
        try{
            autos = ((CustomDAO) dao).quaryCarsByType2();
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }

    public List<Auto> quaryCarsByType3() throws Exception{
        BaseDao dao = new CustomDAO();
        List<Auto> autos;
        try{
            autos = ((CustomDAO) dao).quaryCarsByType3();
        }finally {
            dao.closeConnection();
        }

        return  autos;
    }
}
