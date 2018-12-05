package com.hibernate.student;

import java.util.Date;

public class Enployee {
private Integer enployeeId;
private String enployeeName;
private String enployeeDesc;
private Date date;
private Department department;
public Integer getEnployeeId() {
	return enployeeId;
}
public void setEnployeeId(Integer enployeeId) {
	this.enployeeId = enployeeId;
}
public String getEnployeeName() {
	return enployeeName;
}
public void setEnployeeName(String enployeeName) {
	this.enployeeName = enployeeName;
}
public String getEnployeeDesc() {
	return enployeeDesc;
}
public void setEnployeeDesc(String enployeeDesc) {
	this.enployeeDesc = enployeeDesc;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Department getDepartment() {
	return department;
}
public void setDepartment(Department department) {
	this.department = department;
}
public Enployee() {
	super();
}
public Enployee(Integer enployeeId, String enployeeName, String enployeeDesc,
		Date date, Department department) {
	super();
	this.enployeeId = enployeeId;
	this.enployeeName = enployeeName;
	this.enployeeDesc = enployeeDesc;
	this.date = date;
	this.department = department;
}
@Override
public String toString() {
	return "Enployee [enployeeId=" + enployeeId + ", enployeeName="
			+ enployeeName + ", enployeeDesc=" + enployeeDesc + ", date="
			+ date + ", department=" + department + "]";
}

}
