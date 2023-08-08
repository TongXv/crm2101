package com.powerndoe.javaweb.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;

@WebServlet("/edit")
public class ajaxedit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ida = request.getParameter("id");
        String idb = request.getParameter("ids");
        String name = request.getParameter("name");
        String dname = request.getParameter("dname");
        String job = request.getParameter("job");
        String sal = request.getParameter("sal");

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement sta = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (idb == "") {
                sta = conn.createStatement();
                String sql1 = "insert into EMP(EMPNO,ENAME,JOB,SAL,DEPTNO)values("+ida+",'"+name+"','"+job+"',"+sal+","+ida+");";
                String sql2 = "insert into DEPT(DEPTNO,DNAME)values("+ida+",'"+dname+"')";
                sta.executeUpdate(sql1);
                sta.executeUpdate(sql2);
            }else {
                sta = conn.createStatement();
                String sql = "update DEPT d,EMP e set EMPNO=" + ida + " ,ENAME='" + name + "',DNAME='" + dname + "',JOB='" + job + "',SAL=" + sal + " where d.DEPTNO= e.DEPTNO and e.EMPNO = '" + idb + "'";
                sta.executeUpdate(sql);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (sta != null) {
                try {
                    sta.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
