package com.strtus.demo;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SerAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("session", "session域");
		
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("application", "application域");
		
		ActionContext.getContext().put("request", "request域");
		return super.execute();
	}
}
