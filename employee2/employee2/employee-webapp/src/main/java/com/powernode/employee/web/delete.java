package com.powernode.employee.web;

import com.powernode.employee.dao.AreaDao;
import com.powernode.employee.dao.impl.AreaDaoImpl;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class delete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ida = request.getParameter("id");
        SqlSession sqlSession = com.powernode.util.SqlSessionUtil.openSession();
        AreaDao areaDaoDao = com.powernode.util.SqlSessionUtil.openSession().getMapper(AreaDao.class);
        areaDaoDao.deleteByNum(ida);
        sqlSession.commit();
        com.powernode.util.SqlSessionUtil.close(sqlSession);

    }
}
