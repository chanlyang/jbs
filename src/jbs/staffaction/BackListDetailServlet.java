package jbs.staffaction;

import jbs.Entity.Auto;
import jbs.Entity.Custom;
import jbs.biz.AutoBiz;
import jbs.biz.BackListBiz;
import jbs.biz.RentListBiz;
import jbs.biz.UserBiz;
import jbs.dto.BackListInfo;
import jbs.dto.RentListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BackListDetailServlet",urlPatterns = "/BackListDetailServlet")
public class BackListDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        String uname = req.getParameter("uname");
        String autocard = req.getParameter("autocard");
        BackListBiz biz = new BackListBiz();
        AutoBiz biz2 = new AutoBiz();
        UserBiz biz3 = new UserBiz();
        RentListBiz biz4 = new RentListBiz();
        try {
            BackListInfo backListInfo = biz.getBackListDetail(rno);
            Auto auto = biz2.getAutoDetail(autocard);
            Custom custom = biz3.getCustomDetail(uname) ;
            RentListInfo rentListInfo = biz4.getRentListDetail(rno);
            req.setAttribute("backListInfo",backListInfo);
            req.setAttribute("auto",auto);
            req.setAttribute("custom",custom);
            req.setAttribute("rentListInfo",rentListInfo);
            req.getRequestDispatcher("/WEB-INF/StaffPages/BackListDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/StaffPages/BackList.jsp").forward(req, resp);
        }
    }
}
