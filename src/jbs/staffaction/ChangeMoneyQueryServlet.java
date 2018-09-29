package jbs.staffaction;

import jbs.Entity.ChangeMoney;
import jbs.Entity.TurnPage;
import jbs.biz.AutoBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChangeMoneyQueryServlet",urlPatterns = "/ChangeMoneyQueryServlet")
public class ChangeMoneyQueryServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AutoBiz biz = new AutoBiz();
        String autocard = req.getParameter("autocard");
        String page = req.getParameter("page");
        try{
            TurnPage tp = new TurnPage();
            tp.rows = 6;
            if(page != null) {
                int iPage = Integer.parseInt(page);
                if (iPage < 1) {
                    iPage = 1;
                }
                tp.page = iPage;         //当前页号，永远不能<1
            }
            List<ChangeMoney> changeMoneyList = biz.changeMoneyQuery(autocard,tp);
            req.setAttribute("changeMoneyList",changeMoneyList);
            req.setAttribute("autocard",autocard);
            req.setAttribute("tp",tp);
            req.getRequestDispatcher("/WEB-INF/StaffPages/ChangeMoneyQuery.jsp").forward(req, resp);
        } catch (Exception e) {
            Log.logger.error(e);
            req.setAttribute("msg", "网络异常，请和管理员联系");
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
