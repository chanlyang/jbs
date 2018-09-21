package jbs.backaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.biz.AutoBiz;

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
        String tno = request.getParameter("tno");
        String tname = request.getParameter("tname");
        String color = request.getParameter("color");
        int seat = Integer.parseInt(request.getParameter("seat"));
        String gear = request.getParameter("gear");
        String tubo = request.getParameter("tubo");
        Double dayrent = Double.parseDouble(request.getParameter("dayrent"));
        String picurl = request.getParameter("pic");
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
        try {
            String pictureurl = "D:\\文档\\Java课程\\8-16\\jbs_1\\web\\picture"+picurl;
            auto.setPicurl(pictureurl);
            File newFile = new File(pictureurl);
            if(!newFile.exists())
                newFile.createNewFile();
            Part part = request.getPart("pic");
            InputStream in = part.getInputStream();
            //ByteArrayOutputStream out = new ByteArrayOutputStream();
            FileOutputStream out = new FileOutputStream(newFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len=in.read(buffer)) != -1){
                out.write(buffer, 0, len);
                out.flush();
            }
            out.flush();
            out.close();
            in.close();
            //byte[] pic = out.toByteArray();
            //auto.setPic(pic);

            AutoBiz biz = new AutoBiz();
            biz.addAuto(auto);
            List<AutoType> atlist = biz.getAutoType();
            List<Brand> blist = biz.getBrand();
            request.setAttribute("atlist",atlist);
            request.setAttribute("blist",blist);
            request.setAttribute("msg", "添加成功--" +auto.getAutocard());
            request.getRequestDispatcher("/WEB-INF/AdminPages/AutoQuery.jsp").forward(request, response);
        }catch (IllegalStateException e){
            AutoBiz biz = new AutoBiz();
            try {
                List<AutoType> atlist = biz.getAutoType();
                List<Brand> blist = biz.getBrand();
                request.setAttribute("atlist",atlist);
                request.setAttribute("blist",blist);
            } catch (Exception e2) {
            }
            request.setAttribute("msg", "添加失败，文件不能大于100K" );
            request.getRequestDispatcher("/WEB-INF/AdminPages/AutoAdd.jsp").forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
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
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
