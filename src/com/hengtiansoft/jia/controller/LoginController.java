package com.hengtiansoft.jia.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtiansoft.jia.service.AdminManager;

/*先判断账号是否存在，把判断的结果用json的形式传给前端页面，在前端页面直接跳转*/
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdminManager adminManager;

	@RequestMapping(value = "/isExist")
	// , method = RequestMethod.POST
	public void login(Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		HttpSession session = request.getSession();
		session.setAttribute("username", username);

		StringBuilder flag = new StringBuilder();
		int result;
		if (adminManager.isExist(username, pwd) != null)// username.equals("tom")
		{
			model.addAttribute("username", username);
			// return "forward:/student/getAllStudent";
			//先判断账号是否存在，把判断的结果用json的形式传给前端页面，在前端页面直接跳转
			result = 1;

		} else {

			result = 0;

		}
		flag.append("{").append("\"result\":\"" + result + "\"").append("}");

		response.setContentType("text/javascript");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(flag.toString());

	}
	
}
