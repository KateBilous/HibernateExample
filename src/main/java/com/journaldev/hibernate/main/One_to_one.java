package com.journaldev.hibernate.main;

import com.journaldev.hibernate.model.Department;
import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by Kate on 30.11.2016.
 */
public class One_to_one {

    public static void main(String[] args) {
        System.out.println("Hibernate one to one (XML mapping)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Department dep = new Department();

        dep.setName("IT");

        Employee emp = new Employee();
        emp.setName("Lisa");
        emp.setRole("Dev");
        emp.setInsertTime(new Date());

        dep.setEmployee(emp);
        emp.setDepartment(dep);

        session.save(dep);
        session.getTransaction().commit();

        System.out.println("Done");
    }
}
