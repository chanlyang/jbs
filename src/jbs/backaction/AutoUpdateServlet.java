package jbs.backaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Brand;
import jbs.biz.AutoBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AutoUpdateServlet",urlPatterns = "/AutoUpdateServlet")
public class AutoUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String autocard = req.getParameter("autocard");
        AutoBiz biz = new AutoBiz();
        String bno = req.getParameter("bno");
        String tno = req.getParameter("tno");
        String tname = req.getParameter("tname");
        String color = req.getParameter("color");
        Integer seat = Integer.parseInt(req.getParameter("seat"));
        String gear = req.getParameter("gear");
        String tubo = req.getParameter("tubo");
        Double dayrent = Double.parseDouble(req.getParameter("dayrent"));
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
            int i = biz.AutoUpdate(auto);
            if(i>0){
                req.setAttribute("msg", auto.getAutocard()+"------修改成功" );
                req.getRequestDispatcher("/WEB-INF/AdminPages/AutoQuery.jsp").forward(req, resp);
            }else{
                req.setAttribute("msg", auto.getAutocard()+"------无项目被修改");
                req.getRequestDispatcher("/WEB-INF/AdminPages/AutoQuery.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/tip.jsp").forward(req,resp);
        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String autocard = req.getParameter("autocard");
        AutoBiz biz = new AutoBiz();
        try {
            List<AutoType> atlist = biz.getAutoType();
            List<Brand> blist = biz.getBrand();
            Auto auto = biz.getAutoDetail(autocard);
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
