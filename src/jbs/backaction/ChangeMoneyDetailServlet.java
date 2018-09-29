package jbs.backaction;

import jbs.Entity.ChangeMoney;
import jbs.biz.AutoBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeMoneyDetailServlet",urlPatterns = "/ChangeMoneyDetailServlet")
public class ChangeMoneyDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        AutoBiz biz = new AutoBiz();
        try {
            ChangeMoney changeMoney = biz.getChangeMoneyDetail(cid);
            req.setAttribute("changeMoney",changeMoney);
            req.getRequestDispatcher("/WEB-INF/AdminPages/ChangeMoneyDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            Log.logger.error(e);
            req.getRequestDispatcher("/WEB-INF/AdminPages/ChangeMoneyQuery.jsp").forward(req, resp);
        }
    }
}
