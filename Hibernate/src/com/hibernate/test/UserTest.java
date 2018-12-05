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

import com.hibernate.user.User;
import com.hibernate.utils.HibernateUtils;

public class UserTest {

	@SuppressWarnings("unchecked")
	@Test
	public void Marth(){
		User user = new User();
		user.setName("莉莉");
		user.setSex("女");
		user.setAge(22);
		user.setDate(new Date());
		Session session = HibernateUtils.HibernateConfigSession();
//		Configuration config = new Configuration();
//		config.configure();
//		SessionFactory factory = config.buildSessionFactory();
//		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//保存方法
		session.save(user);
		//主键查询
//		User user1 = (User) session.get(User.class, 13);
		//HQL查询，查询全部
//		Query query = session.createQuery("from User");
//		List<User> list = query.list();
		//面向对象的查询
//		Criteria criteria = session.createCriteria(User.class);
//		List<User> list = criteria.list();
//		System.out.println(list);
		transaction.commit();
		session.close();
//		factory.close();
	}
}
