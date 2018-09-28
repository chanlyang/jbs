package jbs.staffaction;

import jbs.Entity.ChangeList;
import jbs.Entity.RentList;
import jbs.biz.RentListBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "CLAddServlet",urlPatterns = "/CLAddServlet")
public class CLAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        String bautocard = request.getParameter("bautocard");
        String nautocard = request.getParameter("autocard");
        String person = request.getParameter("person");
        String cdate = request.getParameter("cdate");
        ChangeList changeList = new ChangeList();
        changeList.setRno(rno);
        changeList.setPautocard(bautocard);
        changeList.setNautocard(nautocard);
        changeList.setPerson(person);
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            changeList.setCdate(sd.parse(cdate));
            RentListBiz biz = new RentListBiz();
            biz.addChangeList(changeList);
            int count = biz.autocardUpdate(nautocard,rno);
            if(count>0) response.sendRedirect("/ChangeListServlet");
            else response.sendRedirect("/ChangeListAddServlet");
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ChangeListAddServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        RentListBiz biz = new RentListBiz();
        HttpSession session = request.getSession();
        String uname = (String)session.getAttribute("uname");
        try {
            String autocard = biz.getAutocard(rno);
            String sname = biz.getStaffName(uname);
            request.setAttribute("sname",sname);
            request.setAttribute("autocard",autocard);
            request.setAttribute("rno",rno);
            List<RentList> rlist = biz.getRnoList();
            request.setAttribute("rlist",rlist);
            request.getRequestDispatcher("/WEB-INF/StaffPages/ChangeListAdd.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
