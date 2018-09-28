package jbs.frontaction;

import jbs.Entity.Auto;
import jbs.Entity.AutoType;
import jbs.Entity.TurnPage;
import jbs.biz.CustomBiz;
import jbs.dto.AutoInfo;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        CustomBiz cb = new CustomBiz();
        try {
            TurnPage tp = new TurnPage();
            tp.rows = 3;
            if (page != null) {
                int iPage = Integer.parseInt(page);
                if (iPage < 1) {
                    iPage = 1;
                }
                tp.page = iPage;
            }
            TurnPage tp2 = new TurnPage();
            tp2.rows = 3;
            if (page != null) {
                int iPage = Integer.parseInt(page);
                if (iPage < 1) {
                    iPage = 1;
                }
                tp2.page = iPage;
            }
            TurnPage tp3 = new TurnPage();
            tp3.rows = 3;
            if (page != null) {
                int iPage = Integer.parseInt(page);
                if (iPage < 1) {
                    iPage = 1;
                }
                tp3.page = iPage;
            }
            List<AutoInfo> autos1 = cb.quaryCarsByType(tp,"t002");
            List<AutoInfo> autos2 = cb.quaryCarsByType(tp2,"t001");
            List<AutoInfo> autos3 = cb.quaryCarsByType(tp3,"t004");
            List<AutoType> type = cb.queryAutoType();
            List<Auto> hot = cb.queryHotAuto();
            request.setAttribute("hot",hot);
            request.setAttribute("type",type);
            request.setAttribute("autos1", autos1);
            request.setAttribute("autos2", autos2);
            request.setAttribute("autos3", autos3);
            request.setAttribute("tp1",tp);
            request.setAttribute("tp2",tp2);
            request.setAttribute("tp3",tp3);
            request.getRequestDispatcher("WEB-INF/CustomPages/welcome.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }

    }
}
