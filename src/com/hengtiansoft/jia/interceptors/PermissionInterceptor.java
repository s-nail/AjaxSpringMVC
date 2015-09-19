package com.hengtiansoft.jia.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class PermissionInterceptor implements HandlerInterceptor {
	private static final Logger log = Logger
			.getLogger(PermissionInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {
		// TODO Auto-generated method stub
		String requestPath = req.getRequestURI();
		System.out.println(requestPath);
		requestPath = requestPath.substring(req.getContextPath().length() + 1);// 去掉项目路径
		System.out.println(requestPath);
		String lastPath = requestPath.substring(requestPath.lastIndexOf("/") + 1);
		System.out.println(lastPath);

		if ("".equals(lastPath)) {
			System.out.println("链接为空");
			return true;
		}

		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("username");
		System.out.println(name);
		if(name==null){
//			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
//		    dispatcher .forward(req, res); 
			res.sendRedirect(req.getContextPath() +"/login.jsp");
		    return false;
		}
		return true;
	}

}// http://localhost:8080/SpringMVC/student/toAddStudent
