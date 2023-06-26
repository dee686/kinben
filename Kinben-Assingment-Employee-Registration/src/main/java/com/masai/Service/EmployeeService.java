package com.masai.Service;

import java.util.List;

import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;

public interface EmployeeService {
	
	public String registerEmployee(Employee  employee);
	
	public String updateEmployee(Employee employee)throws EmployeeException;
	
	public String deleteEmployee(Integer employee_Id)throws EmployeeException;
	
	public List<Employee> viewEmployee()throws EmployeeException;

}
