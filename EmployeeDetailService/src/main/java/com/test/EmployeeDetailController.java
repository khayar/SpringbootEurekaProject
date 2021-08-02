package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@RestController
public class EmployeeDetailController {

	private static List<EmployeeDetail> empDetailList = new ArrayList<EmployeeDetail>();

	@Autowired
	private DiscoveryClient discoveryClient;

	static {

		EmployeeDetail emp1 = new EmployeeDetail("1001", "Alytanbaik", "Block 13A Gulshan e iqbal Karachi",
				"altynabaik@kicb.net");
		EmployeeDetail emp2 = new EmployeeDetail("1002", "Mengistu", "Gizri road block 2 Karachi", "mengistu@ube.net");
		EmployeeDetail emp3 = new EmployeeDetail("1003", "Salaman Ahmed", "Surjani towan sector 11-A",
				"altynabaik@gmail.com");

		empDetailList.add(emp1);
		empDetailList.add(emp2);
		empDetailList.add(emp3);

	}

	@RequestMapping(value = "/getEmployeeDetailById/{empId}", method = RequestMethod.GET)
	public EmployeeDetail getEmployee(@PathVariable String empId) {
		System.out.println("Getting employee details for " + empId);

		for (EmployeeDetail emp : empDetailList) {
			if (emp.getEmployeeId().equals(empId))
				return emp;
		}
		return null;
	}

	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public List<EmployeeDetail> getAllEmployees() {
		System.out.println("Fetching all employees");
		return empDetailList;
	}

	@RequestMapping(value = "/getAccountDetailFromEmployeeService/{empId}", method = RequestMethod.GET)
	public String getEmployeeAccountDetail(@PathVariable String empId) {
		System.out.println("Fetching employee datail from Employee Detail" + empId);

		List<ServiceInstance> instances = discoveryClient.getInstances("employee-account-service");
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();

		baseUrl = baseUrl + "/getEmployeeAccountById/"+empId;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println(response.getBody());

		return response.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
