package jbs.backaction;

import jbs.Entity.Staff;
import jbs.Entity.TurnPage;
import jbs.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffServlet",urlPatterns = "/StaffServlet")
public class StaffServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBiz biz = new UserBiz();
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        String sex = req.getParameter("sex");
        String page = req.getParameter("page");
        try{
            TurnPage tp = new TurnPage();
            tp.rows = 8;
            if(page != null){
                int iPage = Integer.parseInt(page);
                if(iPage<1){
                    iPage = 1;
                }
                tp.page = iPage;         //当前页号，永远不能<1
            }
            List<Staff> slist = biz.getStaffInfo(sno,sname,sex,tp);
            System.out.println(sno+" "+sname+" "+sex+" "+tp);
            req.setAttribute("slist", slist);
            req.setAttribute("sno", sno);
            req.setAttribute("sname", sname);
            req.setAttribute("sex", sex);
            req.setAttribute("tp", tp);
            req.getRequestDispatcher("/WEB-INF/AdminPages/StaffQuery.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "网络异常，请和管理员联系");
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
