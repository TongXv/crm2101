package com.powernode.employee.web;

import com.alibaba.fastjson.JSON;
import com.powernode.employee.dao.AreaDao;
import com.powernode.employee.dao.impl.AreaDaoImpl;
import com.powernode.employee.pojo.Area;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@WebServlet("/xiangqing")
public class detail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ids = request.getParameter("id");
        SqlSession sqlSession = com.powernode.util.SqlSessionUtil.openSession();
        AreaDao areaDao = com.powernode.util.SqlSessionUtil.openSession().getMapper(AreaDao.class);
        List<Area> areas = areaDao.selectByNum(ids);
        String json = JSON.toJSONString(areas);
        response.getWriter().print(json);
        sqlSession.commit();
        com.powernode.util.SqlSessionUtil.close(sqlSession);
    }
}
