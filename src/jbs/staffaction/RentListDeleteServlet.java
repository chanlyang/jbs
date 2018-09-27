package jbs.staffaction;

import jbs.biz.RentListBiz;
import jbs.dto.RentListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RentListDeleteServlet",urlPatterns = "/RentListDeleteServlet")
public class RentListDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        RentListInfo rentListInfo = new RentListInfo();
        rentListInfo.setRno(rno);
        RentListBiz biz = new RentListBiz();
        try {
            boolean b = biz.RentDelete(rentListInfo);
            if(b==true){
                response.sendRedirect("/RentListServlet");
            }else{
                request.setAttribute("msg", "删除失败--");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
