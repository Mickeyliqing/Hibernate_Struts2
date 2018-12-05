package com.hibernate.student;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Department {
private Integer departmentId;
private String departmentName;
private String departmentDesc;
private Date date;
private Set<Enployee> enployees = new HashSet<Enployee>();
public Integer getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(Integer departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public String getDepartmentDesc() {
	return departmentDesc;
}
public void setDepartmentDesc(String departmentDesc) {
	this.departmentDesc = departmentDesc;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Set<Enployee> getEnployees() {
	return enployees;
}
public void setEnployees(Set<Enployee> enployees) {
	this.enployees = enployees;
}
public Department() {
	super();
}
public Department(Integer departmentId, String departmentName,
		String departmentDesc, Date date, Set<Enployee> enployees) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.departmentDesc = departmentDesc;
	this.date = date;
	this.enployees = enployees;
}
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName="
			+ departmentName + ", departmentDesc=" + departmentDesc + ", date="
			+ date + ", enployees=" + enployees + "]";
}

}
