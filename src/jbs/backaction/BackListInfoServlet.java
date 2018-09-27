package jbs.backaction;

import jbs.Entity.TurnPage;
import jbs.biz.BackListBiz;
import jbs.dto.BackListInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BackListInfoServlet",urlPatterns = "/BackListInfoServlet")
public class BackListInfoServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BackListBiz biz = new BackListBiz();
        String sno = req.getParameter("sno");
        String rno = req.getParameter("rno");
        String cno = req.getParameter("cno");
        String autocard = req.getParameter("autocard");
        String page = req.getParameter("page");
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
            List<BackListInfo> backListInfoList = biz.getBackListInfo(rno,sno,cno,autocard,tp);
            req.setAttribute("backListInfoList",backListInfoList);
            req.setAttribute("sno",sno);
            req.setAttribute("rno",rno);
            req.setAttribute("cno",cno);
            req.setAttribute("autocard",autocard);
            req.setAttribute("tp",tp);
            req.getRequestDispatcher("/WEB-INF/AdminPages/BackList.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg", "网络异常，请和管理员联系");
            req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
