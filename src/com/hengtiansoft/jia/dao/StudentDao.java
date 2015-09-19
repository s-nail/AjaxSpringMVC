package com.hengtiansoft.jia.dao;

import java.util.List;

import com.hengtiansoft.jia.entity.Student;

public interface StudentDao {
	
	public Student getStudent(String id);
	public List<Student> getAllStudent();
	public void addStudent(Student student);
	public boolean delStudent(String id);
	public boolean updateStudent(Student student);
	public Student getStudentByNum(String num);
	 public List<String> getScore(String num);
}
