package jbs.backaction;

import jbs.Entity.Staff;
import jbs.biz.UserBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StaffDeleteServlet",urlPatterns = "/StaffDeleteServlet")
public class StaffDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        Staff staff = new Staff();
        staff.setUname(uname);
        UserBiz biz = new UserBiz();
        try {
            boolean b = biz.StaffDelete(staff);
            if(b==true){
                response.sendRedirect("/StaffServlet");
            }else{
                request.setAttribute("msg", "删除失败--");
            }
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
