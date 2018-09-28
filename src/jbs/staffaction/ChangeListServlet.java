package jbs.staffaction;

import jbs.Entity.ChangeList;
import jbs.Entity.TurnPage;
import jbs.biz.RentListBiz;
import jbs.dao.RentListDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChangeListServlet",urlPatterns = "/ChangeListServlet")
public class ChangeListServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RentListBiz biz = new RentListBiz();
        String rno = req.getParameter("rno");
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
            List<ChangeList> changeList = biz.getChangeList(rno,tp);
            req.setAttribute("changeList",changeList);
            req.setAttribute("tp",tp);
            req.getRequestDispatcher("/WEB-INF/StaffPages/ChangeList.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
