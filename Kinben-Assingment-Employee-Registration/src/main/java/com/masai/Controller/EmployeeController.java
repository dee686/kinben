package com.masai.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;
import com.masai.Service.EmployeeService;
import com.masai.Service.EmployeeServiceImpl;


@RestController
@RequestMapping("/empController")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
		
		@PostMapping("/Employee")
		public ResponseEntity<String> createEmployee(@RequestBody Employee employee)  {

		   String result=employeeService.registerEmployee(employee);
		 
		return  new ResponseEntity<String>(result,HttpStatus.CREATED);
		
		}
	 
	 
		  @PutMapping("/Employee")
			public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) throws EmployeeException {
			   
			   
			    String result=employeeService.updateEmployee(employee);	 
					return  new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
			
		   }
		  
		  
		  	@GetMapping("/Employee")
			public ResponseEntity<List<Employee>> viewAllEmployee() throws EmployeeException {
				
			   
			   List<Employee> list=employeeService.viewEmployee();
		   
		     return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		   
		   }
	 
	 
		  	
		    @DeleteMapping("/Employee/{id}")
			public  ResponseEntity<String>  deleteEmployee(@PathVariable("id") Integer employeeId) throws EmployeeException {
			 
		    	 String  result=employeeService.deleteEmployee(employeeId);
		     	
		 		return new ResponseEntity<String>(result,HttpStatus.OK);
			}
		  	
	 
}
