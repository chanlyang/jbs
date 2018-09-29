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

@WebServlet(name = "AutoDeleteServlet",urlPatterns = "/AutoDeleteServlet")
public class AutoDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String autocard = request.getParameter("autocard");
        Auto auto = new Auto();
        auto.setAutocard(autocard);
        AutoBiz biz = new AutoBiz();
        try {
            boolean b = biz.AutoDelete(auto);
            if(b==true){
                response.sendRedirect("/AutoServlet");
            }else{
                request.setAttribute("msg", "删除失败--");
            }
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
