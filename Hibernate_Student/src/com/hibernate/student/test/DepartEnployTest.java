package com.hibernate.student.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.student.Department;
import com.hibernate.student.Enployee;

public class DepartEnployTest {

	@Test
	public void TestDepartEnploy(){
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
//		Department department = new Department();
//		Enployee enployee = new Enployee();
		
//		enployee.setEnployeeName("卡卡");
//		enployee.setEnployeeDesc("表现很好");
//		enployee.setDate(new Date());
//		
//		department.setDepartmentName("销售部");
//		department.setDepartmentDesc("销售产品");
//		department.setDate(new Date());
//		
//		department.getEnployees().add(enployee);
		
//		Transaction transaction = session.beginTransaction();
//		session.save(department);
//		session.save(enployee);
//		transaction.commit();
		
//		Query query = session.createQuery("from Department");
//		List<Department> Depart_list = query.list();
//		System.out.println(Depart_list.get(0).getDepartmentName());
		
//		Enployee enployee2 = (Enployee) session.get(Enployee.class, 1);
//		session.flush();
//		enployee2.setEnployeeName("莉莉");
//		System.out.println(enployee2.getEnployeeName());
		
		Query query = session.createQuery("from Enployee");
		
		ScrollableResults scroll = query.scroll();
		scroll.last();
		int rowNumber = scroll.getRowNumber();
		
		query.setFirstResult(0);
		query.setMaxResults(3);
		
		List<Enployee> list = query.list();
		String name = list.get(1).getEnployeeName();
		//System.out.println(list);
		System.out.println(name);
		System.out.println(rowNumber);
		//System.out.println(list);
		/**
		//会报内存溢出
		Department department2 = (Department) session.get(Department.class, 1);
		System.out.println(department2.getEnployees());
		 */
		session.close();
		
		
		
	}
}
