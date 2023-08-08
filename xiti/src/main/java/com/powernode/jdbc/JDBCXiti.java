package com.powernode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCXiti {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
            stmt = conn.createStatement();
            String sql = "SELECT " +
                            "e.ENAME ename1, d.DNAME,l.ENAME ename2,s.GRADE  " +
                        "FROM " +
                            "EMP e " +
                        "JOIN " +
                            "DEPT d ON e.DEPTNO = d.DEPTNO " +
                        "LEFT JOIN " +
                            "EMP l ON e.MGR = l.EMPNO " +
                        "JOIN " +
                            "SALGRADE s ON e.SAL BETWEEN s.LOSAL  AND s.HISAL WHERE e.SAL > ( SELECT avg( SAL ) FROM EMP )";

            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                String ename1 =  rs.getString(1);
                String DNAME =  rs.getString(2);
                String ename2 = rs.getString(3);
                String GRADE = rs.getString(4);
                System.out.println(ename1 + "," + DNAME + "," + ename2 + ',' + GRADE);
            }

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
    }
}
