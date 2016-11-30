package com.journaldev.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.journaldev.hibernate.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.journaldev.hibernate.model.Employee1;
import com.journaldev.hibernate.util.HibernateUtil;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.testng.annotations.Test;

public class HibernateAnnotationMain {


	public static void main(String[] args) {
		HibernateAnnotationMain hibernateAnnotationMain = new HibernateAnnotationMain();
		hibernateAnnotationMain.HQLQwerySelectCortageByName("alex");
		hibernateAnnotationMain.HQLQuerySelectCortageByDate("2016-11-27");
		hibernateAnnotationMain.HQLQuerySelectByID(4);
		hibernateAnnotationMain.HQLQueryEmployee();
		hibernateAnnotationMain.HQLQueryEmployeeEddedAfterDueDate("2016-11-25");
		hibernateAnnotationMain.HQLQueryBetweenDates("2014-11-26", "2016-11-27");
		hibernateAnnotationMain.criteriaEmployee();


	}

@Test
	public void HQLQwerySelectCortageByName(String nameOFemployee) {

		String myHQL = "FROM Employee1 WHERE name = '" + nameOFemployee + "'";

		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(myHQL);
		ArrayList<Employee1> result_list = new ArrayList<Employee1>(query.list());

		if (result_list.size() == 0) {
			System.out.println("Sorry, but no cartage with name = " + nameOFemployee + " in this DataBase");
		} else {
			for (Employee1 employee1 : result_list) {
				System.out.println(employee1);
			}
		}

		sessionFactory.close();
	}

@Test
	public void HQLQuerySelectCortageByDate (String Date){
		String dateMyHQL = " FROM Employee1 WHERE insert_time = '" + Date+"'";

		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(dateMyHQL);
		ArrayList<Employee1> result_list = new ArrayList<Employee1>(query.list());
		if (result_list.size() == 0) {
			System.out.println("Sorry, but no cartage with name = " + Date + " in this DataBase");
		} else {
			for (Employee1 employee1 : result_list) {
				System.out.println(employee1);
			}
		}
		sessionFactory.close();


	}
	@Test
	public void HQLQuerySelectByID(Integer ID) {
		String id = "FROM Employee1 WHERE id ="+ID;

		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Query query = session.createQuery(id);

		ArrayList<Employee1> result_list = new ArrayList<Employee1>(query.list());
		if (result_list.size() == 0) {
			System.out.println("Sorry, but no cartage with id ="+ID+"  in this DataBase");
		} else {
			for (Employee1 employee1 : result_list) {
				System.out.println(employee1);
			}
		}


		sessionFactory.close();

	}
	@Test
	public void HQLQueryEmployee(){

		String allEmployee = "FROM Employee1";
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(allEmployee);
		ArrayList<Employee1> result_list = new ArrayList<Employee1>(query.list());


		if (result_list.size() == 0) {
			System.out.println("Sorry, but no cartage with Employee in this DataBase");
		} else {
			for (Employee1 employee1 : result_list) {
				System.out.println(employee1);
			}
		}
		sessionFactory.close();



	}
@Test
	public void HQLQueryEmployeeEddedAfterDueDate( String DueDate){
		String dueDate = " FROM Employee1  WHERE insert_time >= '" +DueDate+ "'";
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(dueDate);
		ArrayList<Employee1> result_list = new ArrayList<Employee1>(query.list());
		if (result_list.size() == 0) {
			System.out.println("Sorry, but no cartage with date = " + DueDate + " in this DataBase");
		} else {
			for (Employee1 employee1 : result_list) {
				System.out.println(employee1);
			}
		}

		sessionFactory.close();

	}
	@Test
	public  void HQLQueryBetweenDates (String datebetween1 , String datebetween2){
		String datebetween = "FROM Employee1 WHERE insert_time >= '" + datebetween1 + "' AND insert_time <= '" + datebetween2 + "'";
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(datebetween);
		ArrayList<Employee1> result_list = new ArrayList<Employee1>(query.list());
		if (result_list.size() == 0) {
			System.out.println("Sorry, but no cartage with date  " +datebetween1  + " and date" +datebetween2+" in this DataBase");
		} else {
			for (Employee1 employee1 : result_list) {
				System.out.println(employee1);
			}
		}
		session.getTransaction().commit();
		sessionFactory.close();

	}
	@Test

	public void criteriaEmployee(){
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Employee1.class);
		List results = cr.list();
		for (Iterator iterator =
			 results.iterator(); iterator.hasNext();){
			Employee1 employee1 = (Employee1) iterator.next();
			System.out.print("First Name: " + employee1.getName());
			System.out.print("  Last Role: " + employee1.getRole());
			System.out.println("  ID: " + employee1.getId());
			System.out.println("Date: "+ employee1.getInsertTime());
		}
		session.getTransaction().commit();
		sessionFactory.close();

	}
	@Test
	public void criteriaId (){
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Employee1.class);
		List results = cr.list();
		for (Iterator iterator =
			 results.iterator(); iterator.hasNext();){
			Employee1 employee1 = (Employee1) iterator.next();
			System.out.println("  ID: " + employee1.getId());}

		session.getTransaction().commit();
		sessionFactory.close();

	}
	@Test
	public void criteriaName (){
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Employee1.class);
		cr.add(Restrictions.eq("name", "olof"));

		List results = cr.list();

		for(int i = 0; i<results.size(); i++){
			Employee1 emp = (Employee1) results.get(i);
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getRole()+" "+emp.getInsertTime());

		}
		session.getTransaction().commit();
		sessionFactory.close();

	}
	@Test
	public void criteriaID(){
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Employee1.class);
		cr.add((Restrictions.le("id", 1)));
		List results = cr.list();

		for(int i = 0; i<results.size(); i++){
			Employee1 emp = (Employee1) results.get(i);
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getRole()+" "+emp.getInsertTime());

		}
		HibernateUtil.getSessionFactory().getCurrentSession().close();
	}
	@Test
	public void criteriaDate(){
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Employee1.class);

		cr.add(Restrictions.eq("interest_time", ("2016-11-25")));
		List results = cr.list();

		for(int i = 0; i<results.size(); i++){
			Employee1 emp = (Employee1) results.get(i);
			System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getRole()+" "+emp.getInsertTime());

		}
		HibernateUtil.getSessionFactory().getCurrentSession().close();


	}



}
