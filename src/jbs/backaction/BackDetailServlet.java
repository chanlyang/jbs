package jbs.backaction;

import jbs.biz.BackListBiz;
import jbs.dto.BackListInfo;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BackDetailServlet",urlPatterns = "/BackDetailServlet")
public class BackDetailServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rno = req.getParameter("rno");
        BackListBiz biz = new BackListBiz();
        try {
            BackListInfo backListInfo = biz.getBackDetail(rno);
            req.setAttribute("backListInfo",backListInfo);
            req.getRequestDispatcher("/WEB-INF/AdminPages/BackDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            Log.logger.error(e);
            req.getRequestDispatcher("/WEB-INF/AdminPages/BackList.jsp").forward(req, resp);
        }
    }
}
