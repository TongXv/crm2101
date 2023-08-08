package com.powernode.employee.pojo;

public class Area {

    private String id;
    private String name;
    private String dname;
    private String job;
    private String sal;

    public Area() {
    }

    public Area(String id, String name, String dname, String job, String sal) {
        this.id = id;
        this.name = name;
        this.dname = dname;
        this.job = job;
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dname='" + dname + '\'' +
                ", job='" + job + '\'' +
                ", sal='" + sal + '\'' +
                '}';
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
