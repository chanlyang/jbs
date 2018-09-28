package jbs.frontaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.Custom;
import jbs.biz.CustomBiz;
import jbs.dto.AutoRentInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/CustomInfoServlet")
public class CustomInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomBiz cb = new CustomBiz();
        HttpSession session = request.getSession();
        String cno = (String) session.getAttribute("uname");
        try {
            Custom custom = cb.queryPersonInfo(cno);
            AutoRentInfo ai = cb.queryRentedAuto(cno);
            List<Auto> hot = cb.queryHotAuto();
            List<AutoType> ctype = cb.queryAutoType();
            request.setAttribute("ctype",ctype);
            request.setAttribute("hot",hot);
            request.setAttribute("custom",custom);
            request.setAttribute("ai",ai);
            System.out.println(ai.getBegindate());
            request.getRequestDispatcher("WEB-INF/CustomPages/person.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
