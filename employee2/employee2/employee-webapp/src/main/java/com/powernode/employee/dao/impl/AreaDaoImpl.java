package com.powernode.employee.dao.impl;

import com.powernode.employee.dao.AreaDao;
import com.powernode.employee.pojo.Area;
import com.powernode.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class AreaDaoImpl implements AreaDao {
    @Override
    public List<Area> selectByNum(String ids) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        AreaDao mapper = sqlSession.getMapper(AreaDao.class);
        List<Area> all = mapper.selectByNum(ids);
        sqlSession.close();
        return all;
    }

    @Override
    public List<Area> selectByAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        AreaDao mapper = sqlSession.getMapper(AreaDao.class);
        List<Area> all = mapper.selectByAll();
        sqlSession.close();
        return all;
    }

    @Override
    public int addByEmp(String ida, String name, String job, String sal) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        AreaDao mapper = sqlSession.getMapper(AreaDao.class);
        int i = mapper.addByEmp(ida,name,job,sal);
        return i;
    }
    @Override
    public int addByDEPT(String ida,String dname) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        AreaDao mapper = sqlSession.getMapper(AreaDao.class);
        int i = mapper.addByDEPT(ida,dname);
        return i;
    }

    @Override
    public int deleteByNum(String ida) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        AreaDao mapper = sqlSession.getMapper(AreaDao.class);
        int i = mapper.deleteByNum(ida);
        return i;
    }

    @Override
    public int updateByALL(String ida, String name, String dname, String job, String sal, String idb) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        AreaDao mapper = sqlSession.getMapper(AreaDao.class);
        int i = mapper.updateByALL(ida, name, dname, job, sal, idb);
        return i;
    }
}
