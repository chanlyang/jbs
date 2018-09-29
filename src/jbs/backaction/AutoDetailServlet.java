package jbs.backaction;

import jbs.Entity.Auto;
import jbs.biz.AutoBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AutoDetailServlet",urlPatterns = "/AutoDetailServlet")
public class AutoDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String autocard = req.getParameter("autocard");
//        if(autocard!=null){
            AutoBiz biz = new AutoBiz();
            try {
                Auto auto = biz.getAutoDetail(autocard);
                req.setAttribute("auto",auto);
                req.getRequestDispatcher("/WEB-INF/AdminPages/AutoDetail.jsp").forward(req, resp);
            } catch (Exception e) {
                Log.logger.error(e);
                req.getRequestDispatcher("/WEB-INF/AdminPages/AutoQuery.jsp").forward(req, resp);
            }
        /*}else{
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }*/
    }
}
