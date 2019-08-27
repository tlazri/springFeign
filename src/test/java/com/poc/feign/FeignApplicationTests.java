package com.poc.feign;

import com.poc.feign.client.EmployeeClient;
import com.poc.feign.model.Employee;
import com.poc.feign.resource.EmployeeResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignApplicationTests {

	private EmployeeClient employeeClient;

	@Before
	public void setup() {

		// create the client builder
		EmployeeControllerClientBuilder feignClientBuilder = new EmployeeControllerClientBuilder();
		employeeClient = feignClientBuilder.getEmployeeClient();
	}

	@Test
	public void givenemployeeClient_shouldRunSuccessfully() throws Exception {
		List<Employee> employees = employeeClient.findAll().stream()
				.map(EmployeeResource::getEmployee)
				.collect(Collectors.toList());

		System.out.println(employees.toString());
		employees.forEach(employee -> System.out.println("xxx" + employee.toString()));

		assertTrue(employees.size() == 3);
	}

	@Test
	public void givenemployeeClient_shouldFindOneEmployee() throws Exception {
		Employee employee = employeeClient.findById(1L).getEmployee();
		System.out.println("DDDD:" + employee.toString());
		assertThat(employee.getName(), containsString("Name 1"));
	}



}
