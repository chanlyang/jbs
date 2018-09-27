package jbs.backaction;

import jbs.biz.RentListBiz;
import jbs.dto.RentListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RentDetailServlet",urlPatterns = "/RentDetailServlet")
public class RentDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        RentListBiz biz = new RentListBiz();
        try {
            RentListInfo rentListInfo = biz.getRentDetail(rno);
            req.setAttribute("rentListInfo",rentListInfo);
            req.getRequestDispatcher("/WEB-INF/AdminPages/RentListDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/AdminPages/RentList.jsp").forward(req, resp);
        }
    }
}
