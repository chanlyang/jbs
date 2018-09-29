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

@WebServlet(name = "AutoDeleteAllServlet",urlPatterns = "/AutoDeleteAllServlet")
public class AutoDeleteAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] autocards = request.getParameterValues("autocard");
        AutoBiz biz = new AutoBiz();
        try {
            boolean b = biz.AutoDeleteAll(autocards);
            if (b == true) {
                response.sendRedirect("/AutoServlet");
            } else {
                request.setAttribute("msg", "批量修改失败--");
            }
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
