package jbs.frontaction;

import jbs.Entity.TurnPage;
import jbs.biz.CustomBiz;
import jbs.dto.AutoInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/CarAServlet")
public class CarAServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String type = request.getParameter("type");
        System.out.println(type);
        CustomBiz cb = new CustomBiz();
        try {
            TurnPage tp = new TurnPage();
            tp.rows = 6;
            if (page != null) {
                int iPage = Integer.parseInt(page);
                if (iPage < 1) {
                    iPage = 1;
                }
                tp.page = iPage;
            }

            List<AutoInfo> autos = cb.quaryCarsByType(tp,type);
            request.setAttribute("auto", autos);
            request.setAttribute("type",type);
            request.setAttribute("tp",tp);
            request.getRequestDispatcher("WEB-INF/CustomPages/autodetail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
