package com.test;

import java.util.Date;

public class EmployeeAccountDetail {

	private String employeeId;
	private String employeeAccountNo;
	private Date employeeAccountExpiry;
	private Date employeeAccountCreatedDate;
	private String employeeAccountTitle;

	public EmployeeAccountDetail(String employeeId, String employeeAccountNo, Date employeeAccountExpiry,
			Date employeeAccountCreatedDate, String employeeAccountTitle) {
		super();
		this.employeeId = employeeId;
		this.employeeAccountNo = employeeAccountNo;
		this.employeeAccountExpiry = employeeAccountExpiry;
		this.employeeAccountCreatedDate = employeeAccountCreatedDate;
		this.employeeAccountTitle = employeeAccountTitle;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeAccountNo() {
		return employeeAccountNo;
	}

	public void setEmployeeAccountNo(String employeeAccountNo) {
		this.employeeAccountNo = employeeAccountNo;
	}

	public Date getEmployeeAccountExpiry() {
		return employeeAccountExpiry;
	}

	public void setEmployeeAccountExpiry(Date employeeAccountExpiry) {
		this.employeeAccountExpiry = employeeAccountExpiry;
	}

	public String getEmployeeAccountTitle() {
		return employeeAccountTitle;
	}

	public void setEmployeeAccountTitle(String employeeAccountTitle) {
		this.employeeAccountTitle = employeeAccountTitle;
	}

	public Date getEmployeeAccountCreatedDate() {
		return employeeAccountCreatedDate;
	}

	public void setEmployeeAccountCreatedDate(Date employeeAccountCreatedDate) {
		this.employeeAccountCreatedDate = employeeAccountCreatedDate;
	}

}
