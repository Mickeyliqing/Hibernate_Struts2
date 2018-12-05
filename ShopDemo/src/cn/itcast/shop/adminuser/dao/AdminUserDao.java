package cn.itcast.shop.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.adminuser.vo.AdminUser;

public class AdminUserDao extends HibernateDaoSupport{

	@SuppressWarnings("unchecked")
	public AdminUser login(AdminUser adminUser) {
		// TODO Auto-generated method stub
		String hql="from AdminUser where username = ? and password = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql, adminUser);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
