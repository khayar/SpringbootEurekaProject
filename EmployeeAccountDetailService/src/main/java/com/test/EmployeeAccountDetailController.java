package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAccountDetailController {

	private static List<EmployeeAccountDetail> empAccountList = new ArrayList<EmployeeAccountDetail>();

	static {

		EmployeeAccountDetail emp1;
		try {
			emp1 = new EmployeeAccountDetail("1001", "12345678901234",
					new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2024"), new Date(), "Altynbaik");
			EmployeeAccountDetail emp2 = new EmployeeAccountDetail("1002", "12345678901234",
					new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2024"), new Date(), "Mengistu");
			EmployeeAccountDetail emp3 = new EmployeeAccountDetail("1003", "12345678901234",
					new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2024"), new Date(), "Salaman Ahmed");

			empAccountList.add(emp1);
			empAccountList.add(emp2);
			empAccountList.add(emp3);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/getEmployeeAccountById/{empId}", method = RequestMethod.GET)
	public EmployeeAccountDetail getEmployee(@PathVariable String empId) {
		System.out.println("Getting employee account for " + empId);

		for (EmployeeAccountDetail emp : empAccountList) {
			if (emp.getEmployeeId().equals(empId))
				return emp;
		}
		return null;
	}

	@RequestMapping(value = "/getAllEmployeeAccounts", method = RequestMethod.GET)
	public List<EmployeeAccountDetail> getAllEmployeeAccount() {
		System.out.println("Fetching all employee accounts");
		return empAccountList;
	}

}
