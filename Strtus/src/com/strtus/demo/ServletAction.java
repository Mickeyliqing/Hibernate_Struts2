package com.strtus.demo;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Application;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ServletAction extends ActionSupport {

	public String get(){
		
//		HttpServletRequest request = ServletActionContext.getRequest();
//		request.setAttribute("request", "request数据");
//
//		HttpSession session = request.getSession();
//		session.setAttribute("session", "session数据");
//		
//		ServletContext application = ServletActionContext.getServletContext();
//		application.setAttribute("application", "application数据");
		
		ActionContext context = ServletActionContext.getContext();
		
		Map<String,Object> request = context.getContextMap();

		Map<String,Object> session = context.getSession();
		
		Map<String,Object> application = context.getApplication();
		
        request.put("request", "REA");
		
		session.put("session", "SEA");
		
		application.put("application", "APA");
		
		System.out.println("REA"+"SEA"+"APA");
		
		return "success";
	}
	
	/**
	 
	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		
		ServletContext application = ServletActionContext.getServletContext();
		
		request.setAttribute("request", "RE");
		
		session.setAttribute("session", "SE");
		
		application.setAttribute("application", "AP");
		
		return SUCCESS;
	}
*/
}
