package com.hibernate.student.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.hibernate.student.Students;

public class StudentTest {

	@Test
	public void TestStudent(){
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Set<String> set = new HashSet<String>();
		set.add("杭州市江干区");
		set.add("杭州市滨江区");

		Students students = new Students();
		students.setName("莉莉");
		students.setAge(22);
		students.setSex("女");
		students.setDate(new Date());
		students.setAddress(set);
		
//		Transaction transaction = session.beginTransaction();
//		session.save(students);
//		transaction.commit();
		
		Query query = session.createQuery("from Students");
		List<Students> list = query.list();
		System.out.println(list);
		session.close();
		
	}
}
