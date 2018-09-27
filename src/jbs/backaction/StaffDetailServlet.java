package jbs.backaction;

import jbs.Entity.Staff;
import jbs.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StaffDetailServlet",urlPatterns = "/StaffDetailServlet")
public class StaffDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sno = req.getParameter("sno");
        UserBiz biz = new UserBiz();
        try {
            Staff staff = biz.getStaffDetail(sno);
            req.setAttribute("staff",staff);
            req.getRequestDispatcher("/WEB-INF/AdminPages/StaffDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/AdminPages/StaffQuery.jsp").forward(req, resp);
        }
    }
}
