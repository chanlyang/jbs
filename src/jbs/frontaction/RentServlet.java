package jbs.frontaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.biz.CustomBiz;
import jbs.dto.CustomRentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@WebServlet(urlPatterns = "/RentServlet")
public class RentServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String autocard=URLDecoder.decode(request.getParameter("car"),"UTF-8");
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("uname");
        if(uname==null){
            response.sendRedirect("Login.jsp");
        }else{
            CustomBiz cb = new CustomBiz();
            try {
                CustomRentInfo cri = cb.queryAutoAndCustom(autocard,uname);
                List<AutoType> ctype = cb.queryAutoType();
                List<Auto> hot = cb.queryHotAuto();
                request.setAttribute("cri",cri);
                request.setAttribute("hot",hot);
                request.setAttribute("ctype",ctype);
                request.getRequestDispatcher("WEB-INF/CustomPages/rentauto.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
