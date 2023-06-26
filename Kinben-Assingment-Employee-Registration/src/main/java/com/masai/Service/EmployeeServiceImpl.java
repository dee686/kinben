package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Employee;
import com.masai.Exception.EmployeeException;
import com.masai.Repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeDao;

	@Override
	public String registerEmployee(Employee employee) {
	
		Employee emp=employeeDao.save(employee);
		
		
		return "Employee Registerd Suceessfully";
	}

	@Override
	public String updateEmployee(Employee employee)throws EmployeeException {
		
		Optional<Employee> opt =employeeDao.findById(employee.getEmployee_ID());
		if(opt.isPresent()) {
			Employee emp=opt.get();
			emp.setEmployee_Name(employee.getEmployee_Name());
			emp.setAddress(employee.getAddress());
			emp.setEmail_id(employee.getEmail_id());
			emp.setContact_Number(employee.getContact_Number());
			emp.setEducation(employee.getEducation());
			emp.setYear_of_Experience(employee.getYear_of_Experience());
			employeeDao.save(emp);
			return "Employee Updated SucessFully";
		}
		
		else throw new EmployeeException("Employee Not registerd in datatbase");
	}

	@Override
	public String deleteEmployee(Integer employee_Id) throws EmployeeException{
		
		Optional<Employee> opt=employeeDao.findById(employee_Id);
		if(opt.isPresent()) {
			employeeDao.delete(opt.get());
			return "Employee Deleted Successfully";
		}
		
		else throw new EmployeeException("Employee Not registerd in datatbase");
	}

	@Override
	public List<Employee> viewEmployee() throws EmployeeException {
		List<Employee> list=employeeDao.findAll();
		if(list.size()!=0)
		return list;
		
		else throw new EmployeeException("Employee Not registerd in datatbase");
	}

}
