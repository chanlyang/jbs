package jbs.backaction;

import jbs.Entity.Custom;
import jbs.Entity.TurnPage;
import jbs.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomServlet",urlPatterns ="/CustomServlet" )
public class CustomServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBiz biz = new UserBiz();
        String cno = req.getParameter("cno");
        String cname = req.getParameter("cname");
        String page = req.getParameter("page");
        String birthday = req.getParameter("birthday");
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        Date bday = null;
        try {
            if(birthday != null && !birthday.equals("")){
                bday = sd.parse(birthday);
            }
            TurnPage tp = new TurnPage();
            tp.rows = 8;
            if(page != null){
                int iPage = Integer.parseInt(page);
                if(iPage<1){
                    iPage = 1;
                }
                tp.page = iPage;         //当前页号，永远不能<1
            }
            List<Custom> clist = biz.getCustomInfo(cno,cname,bday,tp);
            System.out.println(cno+" "+cname+" "+bday+" "+tp);
            req.setAttribute("clist", clist);
            req.setAttribute("cno", cno);
            req.setAttribute("cname", cname);
            req.setAttribute("birthday", birthday);
            req.setAttribute("tp", tp);
            req.getRequestDispatcher("/WEB-INF/AdminPages/CustomQuery.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "网络异常，请和管理员联系");
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
