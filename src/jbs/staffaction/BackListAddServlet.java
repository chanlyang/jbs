package jbs.staffaction;

import jbs.Entity.Auto;
import jbs.Entity.BackList;
import jbs.Entity.Custom;
import jbs.biz.AutoBiz;
import jbs.biz.BackListBiz;
import jbs.biz.RentListBiz;
import jbs.biz.UserBiz;
import jbs.dto.BackListInfo;
import jbs.dto.RentListInfo;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "BackListAddServlet",urlPatterns = "/BackListAddServlet")
public class BackListAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        String bdate = request.getParameter("bdate");
        Double realmoney = Double.parseDouble(request.getParameter("realmoney"));
        BackList backList = new BackList();
        backList.setRno(rno);
        backList.setRealmoney(realmoney);
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            backList.setbDate(sd.parse(bdate));
            BackListBiz biz = new BackListBiz();
            biz.addBacklist(backList);
            response.sendRedirect("/BackListServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/BackListAddServlet");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        String uname = request.getParameter("uname");
        String autocard = request.getParameter("autocard");
        AutoBiz biz2 = new AutoBiz();
        UserBiz biz3 = new UserBiz();
        RentListBiz biz4 = new RentListBiz();
        try {
            Auto auto = biz2.getAutoDetail(autocard);
            Custom custom = biz3.getCustomDetail(uname) ;
            RentListInfo rentListInfo = biz4.getRentListDetail(rno);
            request.setAttribute("auto",auto);
            request.setAttribute("custom",custom);
            request.setAttribute("rentListInfo",rentListInfo);
            request.getRequestDispatcher("/WEB-INF/StaffPages/BackListAdd.jsp").forward(request, response);
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/WEB-INF/StaffPages/RentList.jsp").forward(request, response);
        }
    }
}
