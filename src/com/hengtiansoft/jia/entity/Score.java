package com.hengtiansoft.jia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	private String id;
	private String num;
	private String math;
	private String english;
	private String chinese;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "num")
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Column(name = "math")
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	@Column(name = "english")
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	@Column(name = "chinese")
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
}
