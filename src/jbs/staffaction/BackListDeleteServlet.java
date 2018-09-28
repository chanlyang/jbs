package jbs.staffaction;

import jbs.biz.BackListBiz;
import jbs.dto.BackListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BackListDeleteServlet",urlPatterns = "/BackListDeleteServlet")
public class BackListDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rno = request.getParameter("rno");
        BackListInfo backListInfo = new BackListInfo();
        backListInfo.setRno(rno);
        BackListBiz biz = new BackListBiz();
        try {
            boolean b = biz.BackDelete(backListInfo);
            if(b==true){
                response.sendRedirect("/BackListServlet");
            }else{
                request.setAttribute("msg", "删除失败--");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
