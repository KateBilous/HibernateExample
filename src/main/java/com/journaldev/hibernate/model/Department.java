package com.journaldev.hibernate.model;


import com.journaldev.hibernate.model.Employee;

public class Department {


    private Integer id;
    private String name;
    private Employee employee;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee getEmployee() { return employee;}
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name;
    }

}
