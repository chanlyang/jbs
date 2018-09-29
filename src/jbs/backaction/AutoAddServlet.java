package jbs.backaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.biz.AutoBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet(name = "AutoAddServlet",urlPatterns = "/AutoAddServlet")
@MultipartConfig(maxFileSize=100*1024)
public class AutoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String autocard = request.getParameter("autocard");
        String bno = request.getParameter("bno");
        String tno = request.getParameter("atype");
        String tname = request.getParameter("tname");
        String color = request.getParameter("color");
        int seat = Integer.parseInt(request.getParameter("seat"));
        String gear = request.getParameter("gear");
        String tubo = request.getParameter("tubo");
        Double dayrent = Double.parseDouble(request.getParameter("dayrent"));
      //String picurl = request.getParameter("pic");
        Double extra = Double.parseDouble(request.getParameter("extra"));
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
            Part part = request.getPart("pic");
            String name = part.getHeader("content-disposition");
            String filename = name.substring(name.indexOf("filename=\"")+10, name.lastIndexOf("\""));
            String root = "D:\\文档\\Java课程\\8-16\\jbs_1\\web\\images\\"+filename;
            String pictureurl = "http://localhost:8080/images/"+filename;
            auto.setPicurl(pictureurl);

            part.write(root);

            AutoBiz biz = new AutoBiz();
            biz.addAuto(auto);
            List<AutoType> atlist = biz.getAutoType();
            List<Brand> blist = biz.getBrand();
            request.setAttribute("atlist",atlist);
            request.setAttribute("blist",blist);
            //request.setAttribute("msg", "添加成功--" +auto.getAutocard());
            response.sendRedirect("/AutoServlet");
        }catch (IllegalStateException e){
            AutoBiz biz = new AutoBiz();
            try {
                List<AutoType> atlist = biz.getAutoType();
                List<Brand> blist = biz.getBrand();
                request.setAttribute("atlist",atlist);
                request.setAttribute("blist",blist);
            } catch (Exception e2) {
                Log.logger.info(e2);
            }
            request.setAttribute("msg", "添加失败，文件不能大于100K" );
            request.getRequestDispatcher("/AutoServlet").forward(request, response);
        } catch (Exception e){
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AutoBiz biz = new AutoBiz();
        try{
            List<AutoType> atlist = biz.getAutoType();
            request.setAttribute("atlist",atlist);
            List<Brand> blist = biz.getBrand();
            request.setAttribute("blist",blist);
            request.getRequestDispatcher("/WEB-INF/AdminPages/AutoAdd.jsp").forward(request,response);
        }catch (Exception e){
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
