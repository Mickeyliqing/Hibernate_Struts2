package cn.itcast.shop.user.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.itcast.shop.user.service.UserService;
import cn.itcast.shop.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动需要的类
	private User user = new User();
	//注入UserService
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getModel() {
		return user;
	}

	public String registPage(){
		return "registPage";
	}
	
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String findByName() throws Exception{
		//调用Service进行查询
		User existUser = userService.findByUserName(user.getUsername());
		//获取response对象，页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//判断
		if(existUser != null){
			//查询到该用户：用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else{
			//没有查询到该用户：用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}

	public String regist(){
		//判断验证码
		//从Session中获取验证码
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码输入错误！");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("请去邮箱激活");
		return "msg";
	}
	
	public String active(){
		//根据激活码查询用户
		User existUser = userService.findByCode(user.getCode());
		if(existUser == null){
			this.addActionMessage("激活失败，激活错误！");
		}else{
			//激活成功
			//修改用户状态
			existUser.setState(1);
			existUser.setCode(null);
			userService.update(existUser);
		}
		return "msg";
	}
	
	public String loginPage(){
		return "loginPage";
	}
	
	public String login(){
		User existUser = userService.login(user);
		if(existUser == null){
			this.addActionMessage("登录失败！");
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginS";
		}
	}
	
	public String quit(){
		//销毁Session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
