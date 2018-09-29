package jbs.backaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.Entity.ChangeMoney;
import jbs.biz.AutoBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "AutoUpdateServlet",urlPatterns = "/AutoUpdateServlet")
@MultipartConfig(maxFileSize=100*1024)
public class AutoUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String autocard = req.getParameter("autocard");
        String bno = req.getParameter("bno");
        String tno = req.getParameter("tno");
        String tname = req.getParameter("tname");
        String color = req.getParameter("color");
        int seat = Integer.parseInt(req.getParameter("seat"));
        String gear = req.getParameter("gear");
        String tubo = req.getParameter("tubo");
        Double dayrent = Double.parseDouble(req.getParameter("dayrent"));
       // String picurl = req.getParameter("pic");
        Double extra = Double.parseDouble(req.getParameter("extra"));
        String cdate = req.getParameter("cdate");
        Auto auto = new Auto();
        auto.setAutocard(autocard);
        auto.setBno(bno);
        auto.setTno(tno);
        auto.setTname(tname);
        auto.setColor(color);
        auto.setSeat(seat);
        auto.setGear(gear);
        auto.setTubo(tubo);
        auto.setDayrent(dayrent);
        auto.setExtra(extra);
        try {
            //String pictureurl = "D:\\文档\\Java课程\\8-16\\jbs_1\\web\\picture"+picurl;
/*            String pictureurl = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/images/"+picurl;
            auto.setPicurl(pictureurl);
            File newFile = new File(pictureurl);
            if(!newFile.exists())
                newFile.createNewFile();
            Part part = req.getPart("pic");
            InputStream in = part.getInputStream();
            FileOutputStream out = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len=in.read(buffer)) != -1){
                out.write(buffer, 0, len);
                out.flush();
            }
            out.flush();
            out.close();
            in.close();*/

            AutoBiz biz = new AutoBiz();
            int i = biz.AutoUpdate(auto);
            List<AutoType> atlist = biz.getAutoType();
            List<Brand> blist = biz.getBrand();
            auto = biz.getAutoDetail(autocard);
            req.setAttribute("atlist",atlist);
            req.setAttribute("blist",blist);
            req.setAttribute("auto",auto);
            if(i>0){
                ChangeMoney changeMoney = new ChangeMoney();
                changeMoney.setAutocard(autocard);
                changeMoney.setCdate(cdate);
                HttpSession session = req.getSession();
                double rent1 = (double)(session.getAttribute("brent"));
                double rent2 = dayrent;
                changeMoney.setBrent(rent1);
                changeMoney.setArent(rent2);
                if(rent1!=rent2) {
                    biz.addChangeMoney(changeMoney);
                    req.setAttribute("changemoney", changeMoney);
                    resp.sendRedirect("/AutoServlet");
                }else {
                    req.setAttribute("msg", "修改成功--");
                    resp.sendRedirect("/AutoServlet");
                }
            }else{
                req.setAttribute("msg", "修改失败--");
                req.getRequestDispatcher("/WEB-INF/AdminPages/AutoUpdate.jsp").forward(req, resp);
            }

        }catch (IllegalStateException e){
            AutoBiz biz = new AutoBiz();
            try {
                List<AutoType> atlist = biz.getAutoType();
                List<Brand> blist = biz.getBrand();
                auto = biz.getAutoDetail(autocard);
                req.setAttribute("atlist",atlist);
                req.setAttribute("blist",blist);
                req.setAttribute("auto",auto);
            } catch (Exception e2) {
                Log.logger.info(e2);
            }
            req.setAttribute("msg", "修改失败，文件不能大于100K" );
            req.getRequestDispatcher("/WEB-INF/AdminPages/AutoUpdate.jsp").forward(req, resp);
        } catch (Exception e){
            Log.logger.error(e);
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String autocard = req.getParameter("autocard");
        AutoBiz biz = new AutoBiz();
        try {
            List<AutoType> atlist = biz.getAutoType();
            List<Brand> blist = biz.getBrand();
            Auto auto = biz.getAutoDetail(autocard);
            Double brent = auto.getDayrent();
            HttpSession session = req.getSession();
            session.setAttribute("brent",brent);
            req.setAttribute("atlist",atlist);
            req.setAttribute("blist",blist);
            req.setAttribute("auto",auto);
            req.getRequestDispatcher("/WEB-INF/AdminPages/AutoUpdate.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/AdminPages/AutoQuery.jsp").forward(req, resp);
        }
    }
}
