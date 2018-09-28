package jbs.staffaction;

import jbs.Entity.TurnPage;
import jbs.biz.BackListBiz;
import jbs.dto.BackListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BackListServlet",urlPatterns = "/BackListServlet")
public class BackListServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BackListBiz biz = new BackListBiz();
        String rno = req.getParameter("rno");
        String cuname = req.getParameter("cuname");
        String autocard = req.getParameter("autocard");
        String page = req.getParameter("page");
        HttpSession session = req.getSession();
        String uname = (String)(session.getAttribute("uname"));
        try{
            TurnPage tp = new TurnPage();
            tp.rows = 6;
            if(page != null) {
                int iPage = Integer.parseInt(page);
                if (iPage < 1) {
                    iPage = 1;
                }
                tp.page = iPage;         //当前页号，永远不能<1
            }
            List<BackListInfo> backListInfoList = biz.getBackListInfo(rno,uname,cuname,autocard,tp);
            req.setAttribute("backListInfoList",backListInfoList);
            req.setAttribute("rno",rno);
            req.setAttribute("cuname",cuname);
            req.setAttribute("autocard",autocard);
            req.setAttribute("tp",tp);
            req.getRequestDispatcher("/WEB-INF/StaffPages/BackList.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg", "网络异常，请和管理员联系");
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
