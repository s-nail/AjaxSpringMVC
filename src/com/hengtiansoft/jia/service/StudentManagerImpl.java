package com.hengtiansoft.jia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hengtiansoft.jia.dao.StudentDao;
import com.hengtiansoft.jia.entity.Student;
@Service("studentManager")
public class StudentManagerImpl implements StudentManager{
	@Autowired
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao){
		this.studentDao = studentDao;
	}

	/*
	 * 根据学生id号查询学生信息
	 * */
	@Override
	public Student getStudent(String id) {
		return studentDao.getStudent(id);		
		
	}
	/*
	 * 查询所有学生信息
	 * */
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudent();
	}
	/*
	 * 添加学生
	 * */
	@Override
    public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
	}
	/*
	 * 根据学生id号删除学生信息
	 * */
	@Override
	public boolean delStudent(String id) {
		return studentDao.delStudent(id);		
	}
	/*
	 * 根据学生id号更新学生信息
	 * */
	@Override
	public boolean updateStudent(Student student) {
		return studentDao.updateStudent(student);	
		
	}
	/*
	 * 根据学生学号判断该账号的学生是否存在
	 * */
	@Override
	public Student getStudentByNum(String num) {
		// TODO Auto-generated method stub
		return studentDao.getStudentByNum(num);
	}

	@Override
	public List<String> getScore(String num) {
		// TODO Auto-generated method stub
		return studentDao.getScore(num);
	}

	

}
