package jbs.staffaction;

import jbs.biz.RentListBiz;
import jbs.dao.RentListDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalServlet",urlPatterns = "/CalServlet")
public class CalServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        String day = req.getParameter("rdays");
        int rdays = Integer.parseInt(day);
        String rent = req.getParameter("dayrent");
        double dayrent = Double.parseDouble(rent);
        String ex = req.getParameter("extra");
        double extra = Double.parseDouble(ex);

        double allmoney = dayrent*rdays - extra;
        RentListBiz biz = new RentListBiz();
        try {
            int count =  biz.calAllmoney(rno,allmoney);
            if(count>0) resp.sendRedirect("/RentListServlet");
            else resp.sendRedirect("/RentListServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
