package jbs.staffaction;

import jbs.Entity.ChangeList;
import jbs.Entity.RentList;
import jbs.biz.RentListBiz;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ChangeListUpdateServlet",urlPatterns = "/ChangeListUpdateServlet")
public class ChangeListUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        String pautocard = request.getParameter("pautocard");
        String nautocard = request.getParameter("nautocard");
        String person = request.getParameter("person");
        String cdate = request.getParameter("cdate");
        ChangeList changeList = new ChangeList();
        try {
            changeList.setRno(rno);
            changeList.setPautocard(pautocard);
            changeList.setNautocard(nautocard);
            changeList.setPerson(person);
            SimpleDateFormat sd = new SimpleDateFormat();
            changeList.setCdate(sd.parse(cdate));
            RentListBiz biz = new RentListBiz();
            int count = biz.changeListUpdate(changeList);
            if(count>0) response.sendRedirect("/ChangeListServlet");
            else response.sendRedirect("/ChangeListUpdateServlet");
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        RentListBiz biz = new RentListBiz();
        try{
            List<RentList> rlist = biz.getRnoList();
            request.setAttribute("rlist",rlist);
            ChangeList cList = biz.getClist(rno);
            request.setAttribute("cList",cList);
            request.getRequestDispatcher("/WEB-INF/StaffPages/ChangeListUpdate.jsp").forward(request,response);
        } catch (Exception e) {
            Log.logger.error(e);
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
