package jbs.backaction;

import jbs.Entity.Custom;
import jbs.biz.UserBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomDetailServlet",urlPatterns = "/CustomDetailServlet")
public class CustomDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        UserBiz biz = new UserBiz();
        try {
            Custom custom = biz.getCustomDetail(uname);
            req.setAttribute("custom",custom);
            req.getRequestDispatcher("/WEB-INF/AdminPages/CustomDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            Log.logger.error(e);
            req.getRequestDispatcher("/WEB-INF/AdminPages/CustomQuery.jsp").forward(req, resp);
        }
    }
}
