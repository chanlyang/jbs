package jbs.frontaction;

import jbs.Entity.Custom;
import jbs.biz.CustomBiz;
import jbs.dto.CustomAndAuto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/RentPageServlet")
public class RentPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("cno");
        String autocard = request.getParameter("autocard");
        String startdate = request.getParameter("begindate");
        //2018-09-28
        String enddate = request.getParameter("enddate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            Date begin = sdf.parse(startdate);
            Date end = sdf.parse(enddate);
            c1.setTime(sdf.parse(startdate));
            c2.setTime(sdf.parse(enddate));
            c1.set(Calendar.HOUR_OF_DAY, 12);
            c1.set(Calendar.MINUTE, 0);
            c1.set(Calendar.SECOND, 0);
            c2.set(Calendar.HOUR_OF_DAY, 12);
            c2.set(Calendar.MINUTE, 0);
            c2.set(Calendar.SECOND, 0);
            int result = ((int) (c2.getTime().getTime() / 1000) - (int) (c1.getTime().getTime() / 1000)) / 3600 / 24;
            if (result > 0) {
               /* List<Date> list = new ArrayList<Date>(); //第一种
                  while(begin.getTime()<=end.getTime()){
                    list.add(c1.getTime());
                    c1.add(Calendar.DAY_OF_YEAR, 1);
                    begin = c1.getTime();
                    //格式为：Tue Oct 02 12:00:00 CST 2018
                }*/
                CustomAndAuto ca = new CustomAndAuto();
                ca.setAutocard(autocard);
                ca.setBegindate(begin);
                ca.setCno(uname);
                ca.setDaynum(result+1);
                List<String> list = new ArrayList<String>();
                list.add(sdf.format(begin));
                while (end.after(c1.getTime())) {
                    c1.add(Calendar.DAY_OF_MONTH, 1);
                    list.add(sdf.format(c1.getTime()));
                }
                CustomBiz cb = new CustomBiz();
                cb.insertRentInfoAndAutoState(ca,list);
                response.sendRedirect("MainServlet");
            } else {
                request.getRequestDispatcher("tip.jsp").forward(request, response);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
