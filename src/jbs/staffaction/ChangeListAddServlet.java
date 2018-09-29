package jbs.staffaction;

import jbs.Entity.ChangeList;
import jbs.Entity.RentList;
import jbs.biz.RentListBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ChangeListAddServlet",urlPatterns = "/ChangeListAddServlet")
public class ChangeListAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RentListBiz biz = new RentListBiz();
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("uname");
        try {
            String sname = biz.getStaffName(uname);
            request.setAttribute("sname",sname);
            List<RentList> rlist = biz.getRnoList();
            request.setAttribute("rlist",rlist);
            request.getRequestDispatcher("/WEB-INF/StaffPages/ChangeListAdd.jsp").forward(request, response);
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
