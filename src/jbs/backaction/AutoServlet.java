package jbs.backaction;

import jbs.Entity.TurnPage;
import jbs.biz.AutoBiz;
import jbs.dto.AutoInfo;
import jbs.util.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AutoServlet",urlPatterns ="/AutoServlet" )
public class AutoServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AutoBiz biz = new AutoBiz();
        String atype = req.getParameter("atype");
        String bname = req.getParameter("bname");
        String tname = req.getParameter("tname");
        String tubo = req.getParameter("tubo");
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
            List<AutoInfo> alist = biz.getAutoInfo(atype,bname,tname,tubo,tp);
            req.setAttribute("alist",alist);
            req.setAttribute("atype",atype);
            req.setAttribute("bname",bname);
            req.setAttribute("tname",tname);
            req.setAttribute("tubo",tubo);
            req.setAttribute("tp",tp);
            req.getRequestDispatcher("/WEB-INF/AdminPages/AutoQuery.jsp").forward(req, resp);
        }catch (Exception e){
            Log.logger.error(e);
                req.setAttribute("msg", "网络异常，请和管理员联系");
                req.getRequestDispatcher("/tip.jsp").forward(req, resp);
        }
    }
}
