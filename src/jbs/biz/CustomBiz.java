package jbs.biz;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Custom;
import jbs.Entity.TurnPage;
import jbs.dao.AutoDao;
import jbs.dao.BaseDao;
import jbs.dao.CustomDAO;
import jbs.dao.LoginDao;
import jbs.dto.AutoInfo;
import jbs.dto.AutoRentInfo;
import jbs.dto.CustomAndAuto;
import jbs.dto.CustomRentInfo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */
public class CustomBiz {
    /**
     * 显示车辆
     *
     * @param tp
     * @param type
     * @return
     * @throws Exception
     */
    public List<AutoInfo> quaryCarsByType(TurnPage tp, String type) throws Exception {
        BaseDao dao = new CustomDAO();
        List<AutoInfo> autos;
        try {
            autos = ((CustomDAO) dao).quaryCarsByType(tp, type);
        } finally {
            dao.closeConnection();
        }

        return autos;
    }

    /**
     * 查所有车的类型
     * @return
     * @throws Exception
     */
    public List<AutoType> queryAutoType() throws Exception {
        CustomDAO cd = new CustomDAO();
        List<AutoType> list;
        try{
            list = cd.queryAutoType();
        }catch (Exception e){
            throw e;
        }finally {
            cd.closeConnection();
        }
        return list;
    }

    /**
     * 取热门车辆
     * @return
     * @throws Exception
     */
    public List<Auto> queryHotAuto() throws Exception{
        CustomDAO cd = new CustomDAO();
        List<Auto> list;
        try {
            list = cd.queryHotAuto();
        }catch (Exception e){
            throw e;
        }finally {
            cd.closeConnection();
        }
        return list;
    }

    /**
     * 客户注册
     *
     * @param custom
     * @throws Exception
     */
    public void insertCustomInfo(Custom custom) throws Exception {
        LoginDao ld = new LoginDao();
        try {
            ld.beginTransaction();
            ld.insertLoginInfo(custom.getCno(), custom.getPassword(), custom.getRole());
            CustomDAO cd = new CustomDAO();
            cd.setConn(ld.getConn());
            cd.insertCustomInfo(custom);
            ld.commit();
        } catch (Exception e) {
            ld.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            ld.closeConnection();
        }
    }

    /**
     * 获取客户和所选车辆的信息
     *
     * @param autocard
     * @param cno
     * @return
     * @throws Exception
     */
    public CustomRentInfo queryAutoAndCustom(String autocard, String cno) throws Exception {
        CustomDAO cd = new CustomDAO();
        CustomRentInfo cri = null;
        try {
            cri = cd.queryAutoAndCustom(autocard, cno);
        } catch (Exception e) {
            throw e;
        } finally {
            cd.closeConnection();
        }
        return cri;
    }

    /**
     * 添加预约
     *
     * @param ca
     * @param ldate
     * @throws Exception
     */
    public void insertRentInfoAndAutoState(CustomAndAuto ca, List<String> ldate) throws Exception {
        CustomDAO cd = new CustomDAO();
        try {
            cd.beginTransaction();
            String rno = "r" + getRandom();
            ca.setRno(rno);
            cd.insertRentInfo(ca);
            AutoDao ad = new AutoDao();
            ad.setConn(cd.getConn());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < ldate.size(); i++) {
                ad.insertAutoState(ca.getAutocard(), sdf.parse(ldate.get(i)));
            }
            cd.commit();
        } catch (Exception e) {
            cd.rollback();
            throw e;
        } finally {
            cd.closeConnection();
        }
    }

    /**
     * 用户自己查自己的信息
     *
     * @param cno
     * @return
     * @throws Exception
     */
    public Custom queryPersonInfo(String cno) throws Exception {
        CustomDAO ca = new CustomDAO();
        Custom custom = null;
        try {
            custom = ca.queryCustom(cno);
        } catch (Exception e) {
            throw e;
        } finally {
            ca.closeConnection();
        }
        return custom;
    }

    /**
     * 客户查自己的预约
     *
     * @param cno
     * @return
     * @throws Exception
     */
    public AutoRentInfo queryRentedAuto(String cno) throws Exception {
        CustomDAO cd = new CustomDAO();
        AutoRentInfo ai = null;
        try {
            ai = cd.queryRentedAuto(cno);
        } catch (Exception e) {
            throw e;
        } finally {
            cd.closeConnection();
        }
        return ai;
    }

    /**
     * 生成5位随机数
     *
     * @return
     */
    private String getRandom() {
        Random random = new Random();
        String fourRandom = random.nextInt(100000) + "";
        int randLength = fourRandom.length();
        if (randLength < 5) {
            for (int i = 1; i <= 5 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }

}
