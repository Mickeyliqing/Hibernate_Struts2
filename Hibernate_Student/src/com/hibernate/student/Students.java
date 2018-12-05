package com.hibernate.student;

import java.util.Date;
import java.util.Set;

public class Students {

	private Integer id;
	private String name;
	private Integer age;
	private String sex;
	private Date date;
	private Set<String> address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	public Students() {
		super();
	}
	public Students(Integer id, String name, Integer age, String sex,
			Date date, Set<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.date = date;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", age=" + age
				+ ", sex=" + sex + ", date=" + date + ", address=" + address
				+ "]";
	}
	
}
