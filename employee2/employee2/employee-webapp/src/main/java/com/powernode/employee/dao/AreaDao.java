package com.powernode.employee.dao;

import com.powernode.employee.pojo.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaDao {
    //查
    List<Area> selectByNum(String ids);
    List<Area> selectByAll();
    //删
    int deleteByNum(String ida);
    //改
    int updateByALL(@Param("ida")String ida, @Param("name")String name, @Param("dname")String dname, @Param("job")String job, @Param("sal")String sal, @Param("idb")String idb);
    //增


    int addByDEPT(@Param("ida")String ida, @Param("dname")String dname);

    int addByEmp(@Param("ida")String ida, @Param("name")String name, @Param("job")String job, @Param("sal")String sal);
}
