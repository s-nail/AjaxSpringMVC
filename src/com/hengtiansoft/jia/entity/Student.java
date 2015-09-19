package com.hengtiansoft.jia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student_info")
public class Student {
	
	private String id;
	private String name;
	private String num;
	private String classes;
	private String age;
	private Date curtime;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="num")
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Column(name="class")
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes== null ? null : classes.trim();
	}
	
	@Column(name="age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Column(name="curtime")
	public Date getCurtime() {
		return curtime;
	}
	public void setCurtime(Date curtime) {
		this.curtime = curtime;
	}
	

	
	//this.age = age== null ? null : age.trim();
}
