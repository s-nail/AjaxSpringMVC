package com.hengtiansoft.jia.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.hengtiansoft.jia.entity.Admin;
import com.hengtiansoft.jia.entity.Score;
import com.hengtiansoft.jia.model.Head;
import com.hengtiansoft.jia.model.MessageReturn;
import com.hengtiansoft.jia.utils.GeneralResult;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping(value="json")
public class TestJsonController {
	Logger logger=Logger.getLogger(TestJsonController.class);

@ModelAttribute
public void populateModel(@RequestParam(required=false)String parm,Model model){
	logger.info("populateModel");
	model.addAttribute("parm",parm);
}
@ModelAttribute
public void populateModels(@RequestParam(required=false)String parms,Model model){
	logger.info("populateModels");
	model.addAttribute("parms",parms);
}
	
@ResponseBody
@RequestMapping(value="test",method=RequestMethod.POST)
public GeneralResult<String> testjson(Model model,Admin admin,Score score) throws IOException{
	GeneralResult<String> re= new GeneralResult<String>();
	logger.info("账号"+admin.getName());
	logger.info("密码"+admin.getPassword());
	logger.info("权限"+admin.getRights());
	logger.info("数学"+score.getMath());
	logger.info("英语"+score.getEnglish());
	logger.info("语文"+score.getChinese());
	
	String result="success";
	//addMessage(model,result);
	/*StringBuilder flag = new StringBuilder();
	flag.append("{").append("\"result\":\"" + result + "\"").append("}");

	response.setContentType("text/javascript");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().print(flag.toString());*/
	re.setData(result);
	re.setMsg("后台过来的！政府效率好低");
	System.out.println(re);
	return re;
}
@RequestMapping("/redirect")
public String testRedirect(RedirectAttributes redirectAttributes,ModelMap modelMap,RedirectAttributesModelMap modelmap){
	redirectAttributes.addFlashAttribute("test","HI,I'Mbile.com.cn!");
	modelMap.put("t", "hahahhahh");
	modelmap.addFlashAttribute("feng","YESS");
	return "redirect:/abc.jsp";//${pageContext.request.contextPath}/student/getAllStudent
	
}
@RequestMapping("/abc")
public String abc(HttpServletRequest hq){
	String testString=hq.getParameter("test");
	System.out.println(testString);
	logger.info("pass");
	 return "/abc";
	
}
@RequestMapping("/modelAttributeTest")
public String modelAttributeTest(){
	logger.info("Go=====modelAttributeTest");
	 return "/abc";
	
}
@ResponseBody
@RequestMapping(value="testHead",method=RequestMethod.POST)
public Object testHead(){
	String data="2015.7.14";
	logger.info("testHead()");
	Head head=new Head();
	head.setData(data);
	head.setMsg("testHead成功!");
	return new MessageReturn<>(head);	
}
}
