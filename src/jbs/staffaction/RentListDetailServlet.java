package jbs.staffaction;

import jbs.Entity.Auto;
import jbs.Entity.Custom;
import jbs.Entity.RentDetail;
import jbs.biz.AutoBiz;
import jbs.biz.RentListBiz;
import jbs.biz.UserBiz;
import jbs.dto.RentListInfo;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RentListDetailServlet",urlPatterns = "/RentListDetailServlet")
public class RentListDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        String uname = req.getParameter("uname");
        String autocard = req.getParameter("autocard");
        RentListBiz biz = new RentListBiz();
        AutoBiz biz2 = new AutoBiz();
        UserBiz biz3 = new UserBiz();
        HttpSession session = req.getSession();
        String name = (String)(session.getAttribute("uname"));
        try {
            RentDetail rentDetail = biz.getRentDetailDetail(rno);
            req.setAttribute("rentDetail",rentDetail);
            Auto auto = biz2.getAutoDetail(autocard);
            Custom custom = biz3.getCustomDetail(uname) ;
            req.setAttribute("auto",auto);
            req.setAttribute("custom",custom);
            req.setAttribute("name",name);
            req.getRequestDispatcher("/WEB-INF/StaffPages/RentListDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            Log.logger.error(e);
            req.getRequestDispatcher("/WEB-INF/StaffPages/RentList.jsp").forward(req, resp);
        }
    }
}
