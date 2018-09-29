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
import java.text.SimpleDateFormat;

@WebServlet(name = "StaffUpdateServlet",urlPatterns = "/StaffUpdateServlet")
public class StaffUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uname = request.getParameter("uname");
            String sname = request.getParameter("sname");
            String sex = request.getParameter("sex");
            String sidcard = request.getParameter("sidcard");
            String phonenum = request.getParameter("phonenum");
            String birthday = request.getParameter("birthday");
            Staff staff = new Staff();
            staff.setUname(uname);
            staff.setSname(sname);
            staff.setSex(sex);
            staff.setSidcard(sidcard);
            staff.setPhonenum(phonenum);
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            staff.setBirthday(sd.parse(birthday));

            UserBiz biz = new UserBiz();
            int i = biz.StaffUpdate(staff);
            if(i>0){
                response.sendRedirect("/StaffServlet");
            }else{
                request.setAttribute("msg", "修改失败--");
                request.getRequestDispatcher("/WEB-INF/AdminPages/StaffUpdate.jsp").forward(request, response);
            }
        }catch (Exception e) {
            Log.logger.error(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        UserBiz biz = new UserBiz();
        try {
            Staff staff = biz.getStaffDetail(uname);
            request.setAttribute("staff",staff);
            request.getRequestDispatcher("/WEB-INF/AdminPages/StaffUpdate.jsp").forward(request, response);
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/WEB-INF/AdminPages/StaffQuery.jsp").forward(request, response);
        }
    }
}
