package jbs.frontaction;

import jbs.Entity.Auto;
import jbs.biz.CustomBiz;
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
        CustomBiz cb = new CustomBiz();
        try {
            List<Auto> autos1 = cb.quaryCarsByType1();
            List<Auto> autos2 = cb.quaryCarsByType2();
            List<Auto> autos3 = cb.quaryCarsByType3();
            request.setAttribute("autos1",autos1);
            request.setAttribute("autos2",autos2);
            request.setAttribute("autos3",autos3);
            request.getRequestDispatcher("WEB-INF/CustomPages/welcome.jsp").forward(request,response);
        } catch (Exception e) {
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }

    }
}
