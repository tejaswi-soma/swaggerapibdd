package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeStepDefination {

	RestTemplate restTemplate = new RestTemplate();
	
	
	ResponseEntity<Employee> response ;	
	@When("user sends POST HTTP request")
	public void user_sends_POST_HTTP_request() {
		
		String url =  "http://localhost" + ":" + 8083 + "/employees" + "/add";
		System.out.println(url);
		
	   	}

	@Then("user adds  emp_id {}, first_name {}, last_name {} and email {}")
	public void user_adds_1(Long id,String firstName,String lastName,String email) {
		 
		String url =  "http://localhost" + ":" + 8083 + "/employees" + "/add";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("content", "application/json");
		
		Employee emp = new Employee();
		emp.setId(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
        emp.setEmail(email);
        
        HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,headers);
        
        Employee result = restTemplate.postForObject(url, entity,Employee.class);
		assertNotNull(result);
	}
	
	
	@Given("user launches the application and sends a delete request")
	public void user_launches_the_application_and_sends_a_delete_request() throws Exception{
	    String url = "http://localhost" + ":" + 8083;
	}

	@When("user gives emp_id {} to delete a record")
	public void user_gives_emp_id_to_delete_a_record(Long id) {
		String url = "http://localhost" + ":" + 8083 + "/employees/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("content", "application/json");
		
		 HttpEntity<Long> entity = new HttpEntity<Long>(id,headers);
		 
		 restTemplate.delete(url, entity);	
		
	}

	@Then("recevies HttpStatus as OK")
	public void recevies_HttpStatus_as_OK() throws Exception{
		System.out.println("OK");
	}

	
	@Given("user launches the application and send getById request")
	public void user_launches_the_application_and_send_getById_request() throws Exception{
	    
		String url = "http://localhost" + ":" + 8083 + "/swagger-ui.html";
		System.out.println(url);
	}

	@When("user gives emp_id {} to see a particular record")
	public void user_gives_emp_id_to_see_a_particular_record(Long id) throws Exception{
	    
		String url = "http://localhost" + ":" + 8083 + "/employees/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("content", "application/json");
		
		HttpEntity<Long> entity = new HttpEntity<Long>(id,headers);
		
		Employee result = restTemplate.getForObject(url, Employee.class, entity);
		assertNotNull(result);
		
	}

	@Then("user recevies the empid {},firstName {},lastName {},email {}")
	public void user_recevies_the_empid_firstName_testUser_lastName_testLastName_email_abc_gmail_com
	(Long id,String firstName,String lastName,String email) throws Exception {
	   
		String url = "http://localhost" + ":" + 8083 + "/employees/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		headers.add("content", "application/json");
		
		HttpEntity<Long> entity = new HttpEntity<Long>(id,headers);
		
		Employee result = restTemplate.getForObject(url, Employee.class, entity);
		assertEquals(id, result.getId());
		assertEquals(firstName, result.getFirstName());
		assertEquals(lastName, result.getLastName());
		assertEquals(email, result.getEmail());
		
	}
	
}
