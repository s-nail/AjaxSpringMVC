package com.hengtiansoft.jia.controller;




import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtiansoft.jia.entity.Student;
import com.hengtiansoft.jia.service.StudentManager;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource(name="studentManager")
	private StudentManager studentManager;
	
	/**
	 * 获取所有学生信息，跳转到index页面上
	 */
	@RequestMapping("/getAllStudent")
	public String getAllStudent(HttpServletRequest request){
		request.setAttribute("studentList", studentManager.getAllStudent());
		return "/index";		
	}
	
	/**
	 * 根据学生id查询学生信息，跳转到修改的界面
	 */
	@RequestMapping("/getStudent")
	public String getStudent(String id,HttpServletRequest request){
		 request.setAttribute("student", studentManager.getStudent(id));  
		    return "/editStudent";  
			
	}
	
	@RequestMapping("/toAddStudent")
	public String toAddStudent(){
		return "/addStudent";
		
	}
	/**
	 * 添加学生
	 */
    @RequestMapping("/addStudent")
    public String addStudent(Student student,HttpServletRequest request) {    	
       //	json没成功的    	
    	/*String str=URLDecoder.decode(request.getParameter("studentJosn"), "UTF-8");
    	JSONObject jb=new JSONObject();
    	@SuppressWarnings("static-access")
		String name=(String) jb.fromObject(str).get("username");
    	student.setName(name);*/
    	
    	
    	//先判断注册的学号是否存在，若没有，则插入数据。插入数据成功后，跳转到首页    	
    	String num=student.getNum();
    	if(studentManager.getStudentByNum(num) != null)
    	{
    		//提示该学号已被注册
    		return "no";
    	}
    	else{
    		student.setCurtime(new Date());
    		 studentManager.addStudent(student);
    		 return "redirect:/student/getAllStudent";
    	}
    	
    }
    /**
	 * 根据学生id删除学生信息
	 */
    @RequestMapping("/delStudent")
    public String delStudent(String id,HttpServletResponse response){
    	if(studentManager.delStudent(id)){
   		 return "redirect:/student/getAllStudent";
   	}
   	 else
		  { return "no";}   	
    	
    }
    
    /**
	 * 根据学生id更新学生信息，跳转到修改的界面
	 */
    @RequestMapping("/updateStudent")  
    public String updateStudent(Student student,HttpServletRequest request){
    	if(studentManager.updateStudent(student)){
    		 return "redirect:/student/getAllStudent";
    	}
    	//更新是否。跳转到提示页面
    	 else
		  { return "no";}  
       
    }  
    @RequestMapping("/getScore")
    public String getScore(String num,HttpServletRequest request){
    	List<String> str=studentManager.getScore(num);
    	if(str!= null){
    	request.setAttribute("scoreList", studentManager.getScore(num));
		return "/studentScore";	
    	}else{
    		return "no";
    	}
	}
}
