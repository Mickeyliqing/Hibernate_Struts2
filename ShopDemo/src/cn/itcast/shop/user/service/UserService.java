package cn.itcast.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.untils.MaiIUitls;
import cn.itcast.shop.untils.UUIDUtils;
import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.vo.User;
@Transactional
public class UserService {
//注入User的引用
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findByUserName(String username){
		return userDao.findByUserName(username);
	}
	
	//业务层用户信息注册
	public void save(User user) {
		user.setState(0);// 0:代表用户未激活.  1:代表用户已经激活.
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MaiIUitls.sendMail(user.getEmail(), code);
	}

	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	public void update(User existUser) {
		userDao.update(existUser);
	}

	public User login(User user) {
		return userDao.login(user);
	}
}

