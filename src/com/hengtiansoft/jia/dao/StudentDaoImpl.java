package com.hengtiansoft.jia.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hengtiansoft.jia.entity.Student;
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	/**
	 * 根据学生id查询学生信息
	 */
	@Override
	public Student getStudent(String id) {
		String hql="from Student s where s.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id); 
		return (Student) query.uniqueResult();
	}
	/**
	 * 查询所有学生
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		String hql="from Student";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	/**
	 * 添加学生
	 */	
	@Override
	public void addStudent(Student student) {
		
		Session session=this.sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(student);
		ts.commit();		
	}
	/**
	 * 根据学生id删除学生
	 */
	@Override
	public boolean delStudent(String id) {
		
		String hql="delete Student s where s.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0,id);
		return (query.executeUpdate()>0);
	}
	/**
	 * 修改学生
	 */
	@Override
	public boolean updateStudent(Student student) {
		String hql="update Student s set s.name=?,s.num=?,s.classes=?,s.age=? where s.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, student.getName());
		query.setString(1, student.getNum());
		query.setString(2, student.getClasses());
		query.setString(3, student.getAge());
		query.setString(4, student.getId());	
		
		return (query.executeUpdate()>0);
		
		
	/*	if(query.executeUpdate()>0){
			return true;
		}else{return false;}*/
	}
	/*
	 * 根据学生学号判断该账号的学生是否存在，返回查询结果
	 * */
	@Override
	public Student getStudentByNum(String num) {
		// TODO Auto-generated method stub
		String hql="from Student s where s.num=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, num);
		return (Student) query.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getScore(String num) {
		// TODO Auto-generated method stub
	String hql="select s.name ,s.classes, sc.math,sc.english,sc.chinese from Student  s,Score  sc where s.num =? and sc.num=?";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	query.setString(0, num);
	query.setString(1, num);
	
	return query.list();
	}
	

}
