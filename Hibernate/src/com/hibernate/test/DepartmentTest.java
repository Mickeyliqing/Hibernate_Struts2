package com.hibernate.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.department.Department;
import com.hibernate.user.User;
import com.hibernate.utils.HibernateUtils;

public class DepartmentTest {

	@SuppressWarnings("unchecked")
	@Test
	public void Marth(){
		Department department = new Department();
//		department.setDepartName("人事部");
//		department.setDepartDesc("负责招人");
//		department.setDepartDate(new Date());
		
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();
//		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();
		//保存方法
//		session.save(department);
		//主键查询
//		User user1 = (User) session.get(User.class, 13);
		//HQL查询，查询全部
//		Query query = session.createQuery("select U, D from User U,Department D where U.id=D.id");
//		List<User> list = query.list();
		//面向对象的查询
//		Criteria criteria = session.createCriteria(User.class);
//		List<User> list = criteria.list();
		
		Session session1 = factory.openSession();
		Session session2 = factory.openSession();
		Transaction transaction1 = session1.beginTransaction();
		Transaction transaction2 = session2.beginTransaction();
		Department department1 = (Department) session1.get(Department.class, 1);
		Department department2 = (Department) session2.get(Department.class, 1);
		System.out.println(department1);
		System.out.println(department2);
//		transaction.commit();
//		session.close();
//		factory.close();
	}
}
