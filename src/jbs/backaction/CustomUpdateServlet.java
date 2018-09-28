package jbs.backaction;

import jbs.Entity.Custom;
import jbs.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "CustomUpdateServlet",urlPatterns = "/CustomUpdateServlet")
public class CustomUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uname = request.getParameter("uname");
            String cname = request.getParameter("cname");
            String cidcard = request.getParameter("cidcard");
            String phonenum = request.getParameter("phonenum");
            String birthday = request.getParameter("birthday");
            Custom custom = new Custom();
            custom.setUname(uname);
            custom.setCname(cname);
            custom.setCidcard(cidcard);
            custom.setPhonenum(phonenum);
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            custom.setBirthday(sd.parse(birthday));

            UserBiz biz = new UserBiz();
            int i = biz.CustomUpdate(custom);
            if(i>0){
                response.sendRedirect("/CustomServlet");
            }else{
                request.setAttribute("msg", "修改失败--");
                request.getRequestDispatcher("/WEB-INF/AdminPages/AutoUpdate.jsp").forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        UserBiz biz = new UserBiz();
        try {
            Custom custom = biz.getCustomDetail(uname);
            request.setAttribute("custom",custom);
            request.getRequestDispatcher("/WEB-INF/AdminPages/CustomUpdate.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/AdminPages/CustomQuery.jsp").forward(request, response);
        }
    }
}
