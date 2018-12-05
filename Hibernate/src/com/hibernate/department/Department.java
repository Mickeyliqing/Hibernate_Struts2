package com.hibernate.department;

import java.util.Date;

public class Department {

	private Integer id;
	private String departName;
	private String departDesc;
	private Date departDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getDepartDesc() {
		return departDesc;
	}
	public void setDepartDesc(String departDesc) {
		this.departDesc = departDesc;
	}
	public Date getDepartDate() {
		return departDate;
	}
	public void setDepartDate(Date departDate) {
		this.departDate = departDate;
	}
	public Department() {
		super();
	}
	public Department(Integer id, String departName, String departDesc,
			Date departDate) {
		super();
		this.id = id;
		this.departName = departName;
		this.departDesc = departDesc;
		this.departDate = departDate;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departName=" + departName
				+ ", departDesc=" + departDesc + ", departDate=" + departDate
				+ "]";
	}
	
}
