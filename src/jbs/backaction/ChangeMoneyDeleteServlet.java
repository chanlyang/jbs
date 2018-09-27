package jbs.backaction;

import jbs.Entity.ChangeMoney;
import jbs.biz.AutoBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeMoneyDeleteServlet",urlPatterns = "/ChangeMoneyDeleteServlet")
public class ChangeMoneyDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        ChangeMoney changeMoney = new ChangeMoney();
        changeMoney.setCid(cid);
        AutoBiz biz = new AutoBiz();
        try {
            boolean b = biz.ChangeMoneyDelete(changeMoney);
            if(b==true){
                response.sendRedirect("/ChangeMoneyServlet");
            }else{
                request.setAttribute("msg", "删除失败--");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/tip.jsp").forward(request, response);
        }
    }
}
