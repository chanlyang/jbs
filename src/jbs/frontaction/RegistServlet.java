package jbs.frontaction;

import jbs.Entity.Custom;
import jbs.Entity.IRole;
import jbs.biz.CustomBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String name = request.getParameter("name");
        String cid = request.getParameter("cid");
        String phone = request.getParameter("phone");
        String year = cid.substring(6,10);
        String month = cid.substring(10,12);
        String day = cid.substring(12,14);
        StringBuilder sb = new StringBuilder(" ");
        sb.append(year);
        sb.append("-");
        sb.append(month);
        sb.append("-");
        sb.append(day);
        System.out.println(sb.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
           birthday = sdf.parse(sb.toString());
        } catch (ParseException e) {
            request.setAttribute("meg","身份证号有误");
            request.getRequestDispatcher("regist.jsp").forward(request,response);
        }
        Custom custom = new Custom();
        custom.setUname(uname);
        custom.setBirthday(birthday);
        custom.setCidcard(cid);
        custom.setCname(name);
        custom.setPhonenum(phone);
        custom.setPassword(password);
        custom.setRole(IRole.CUSTOMER);
        CustomBiz cb = new CustomBiz();
        try {
            cb.insertCustomInfo(custom);
            response.sendRedirect("MainServlet");
        } catch (Exception e) {
            request.setAttribute("meg","用户名以存在");
            request.getRequestDispatcher("regist.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
}
