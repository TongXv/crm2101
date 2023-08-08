package com.powernode.employee.web;

import com.powernode.employee.dao.AreaDao;
import org.apache.ibatis.session.SqlSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class edit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ida = request.getParameter("id");
        String idb = request.getParameter("ids");
        String name = request.getParameter("name");
        String dname = request.getParameter("dname");
        String job = request.getParameter("job");
        String sal = request.getParameter("sal");
        SqlSession sqlSession = com.powernode.util.SqlSessionUtil.openSession();
        AreaDao areaDao = com.powernode.util.SqlSessionUtil.openSession().getMapper(AreaDao.class);
        if (idb == "") {
            areaDao.addByEmp(ida,name,job,sal);
            areaDao.addByDEPT(ida,dname);
        }else {
            areaDao.updateByALL(ida,name,dname,job,sal,idb);
        }
        sqlSession.commit();
        com.powernode.util.SqlSessionUtil.close(sqlSession);
    }
}
