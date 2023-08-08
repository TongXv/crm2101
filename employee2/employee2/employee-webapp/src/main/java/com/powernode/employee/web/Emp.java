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
import java.util.List;

@WebServlet("/yuanGongXinXi")
public class Emp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SqlSession sqlSession = com.powernode.util.SqlSessionUtil.openSession();
        AreaDao areaDao = com.powernode.util.SqlSessionUtil.openSession().getMapper(AreaDao.class);
        List<Area> areas = areaDao.selectByAll();
        String json = JSON.toJSONString(areas);
        response.getWriter().print(json);
        sqlSession.commit();
        com.powernode.util.SqlSessionUtil.close(sqlSession);
    }
}
