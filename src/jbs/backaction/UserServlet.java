package jbs.backaction;

import jbs.Entity.IRole;
import jbs.Entity.User;
import jbs.biz.UserBiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("uname");
        String pwd = request.getParameter("password");
        UserBiz biz = new UserBiz();
        try{
            User user = biz.login(name,pwd);
            int role = user.getUrole();
            if(role == IRole.CUSTOMER){
                session.setAttribute("uname", name);
                response.sendRedirect("MainServlet");
            }else if(role ==IRole.ADMIN){
                session.setAttribute("uname", name);
                request.getRequestDispatcher("/WEB-INF/StaffPages/StaffMain.jsp").forward(request,response);
            }else if(role == IRole.STAFF) {
                session.setAttribute("uname", name);
                request.getRequestDispatcher("/WEB-INF/AdminPages/AdminMain.jsp").forward(request,response);
            }
        }catch (Exception e){
            request.setAttribute("message", "您的账号或密码有误，请重新登录！");
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }
    }

}
