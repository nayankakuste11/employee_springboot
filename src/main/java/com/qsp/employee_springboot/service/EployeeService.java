package com.qsp.employee_springboot.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_springboot.dao.EmployeeDao;
import com.qsp.employee_springboot.dto.Employee;

@Service
public class EployeeService {

	@Autowired
	private EmployeeDao dao;

	// save
	public Employee saveEmployee(Employee employee) {

		double salary = employee.getSalary();

		if (salary < 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('C');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}

		return dao.saveEmployee(employee);
	}

	public List<Employee> saveEmployee(List<Employee> employee) {

		for (Employee employee2 : employee) {
			double salary = employee2.getSalary();

			if (salary < 10000) {
				employee2.setGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee2.setGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee2.setGrade('B');
			} else {
				employee2.setGrade('A');
			}
		}
		return dao.saveAllEmployee(employee);

	}

	// find
	public List<Employee> findAll() {
		return dao.findAll();
	}

	public Optional<Employee> findById(int id) {
		return dao.findById(id);
	}

	public Employee findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public List<Employee> findByName(String name) {
		return dao.findByName(name);
	}

	public Employee findByPhone(long phone) {
		return dao.findByPhone(phone);
	}

	public List<Employee> findByAddress(String address) {
		return dao.findByAddress(address);
	}

	public List<Employee> findByDesignation(String designation) {
		return dao.findByDesignation(designation);
	}

	public String login(String userName, String password) {

		Employee employee = dao.logEmployee(userName);

		if (employee != null) {

			if (employee.getPassword().equals(password)) {
				return "Login Success";
			} else {
				return "Invalid password";
			}

		} else {
			return "user not present with userName" + userName;
		}
	}

	public List<Employee> findBySalaryLessThan(double salary) {
		return dao.findBySalaryLessThan(salary);
	}

	public List<Employee> findBySalaryGreaterThan(double salary) {
		return dao.findBySalaryGreaterThan(salary);
	}

	public List<Employee> findBySalaryBetween(double salary1, double salary2) {
		return dao.findBySalaryBetween(salary1, salary2);
	}

	// update

	public Employee updateEmployeeEmailById(int id, String email) {
		return dao.updateEmployeeEmailById(id, email);
	}

	public Employee updateEmployeePhoneById(int id, long phone) {
		return dao.updateEmployeePhoneById(id, phone);
	}

	public Employee updateEmployeePasswordById(int id, String password) {
		return dao.updateEmployeePasswordById(id, password);
	}

	public Employee updateEmployeeSalaryById(int id, double salary) {
		Optional<Employee> optional = dao.findById(id);
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setSalary(salary);

			if (salary < 10000) {
				employee.setGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee.setGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}

			return dao.updateEmployeeSalaryById(id, salary);
		} else {
			return null;
		}
	}

	public Employee updateEmployeeDesignationById(int id, String designation) {
		return dao.updateEmployeeDesignationById(id, designation);
	}

	public Employee updateEmployeeNameById(int id, String name) {
		return dao.updateEmployeeNameById(id, name);
	}

	public Employee updateEmployeePasswordByEmail(String email, String password) {
		return dao.updateEmployeePasswordByEmail(email, password);
	}

	public Employee updateEmployeePasswordByPhone(long phone, String password) {
		return dao.updateEmployeePasswordByPhone(phone, password);
	}

	public Employee updateEmployee(Employee updatedEmployee) {
		Optional<Employee> optional = dao.findById(updatedEmployee.getId());
		if (optional.isPresent()) {
			Employee employee = optional.get();
			employee.setName(updatedEmployee.getName());
			employee.setPhone(updatedEmployee.getPhone());
			employee.setEmail(updatedEmployee.getEmail());
			employee.setAddress(updatedEmployee.getAddress());
			employee.setPassword(updatedEmployee.getPassword());
			employee.setSalary(updatedEmployee.getSalary());
			employee.setDesignation(updatedEmployee.getDesignation());

			double salary = updatedEmployee.getSalary();
			if (salary < 10000) {
				employee.setGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee.setGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}

			return dao.updateEmployee(employee);
		} else {
			return null;
		}
	}
	// delete

	public void deleteEmployeeById(int id) {
		dao.deleteEmployeeById(id);
	}

	public void deleteEmployeeByEmail(String email) {
		dao.deleteEmployeeByEmail(email);
	}

	public void deleteEmployeeByPhone(long phone) {
		dao.deleteEmployeeByPhone(phone);
	}

	public void deleteAllEmployees() {
		dao.deleteAllEmployees();
	}

	public void deleteEmployeeByName(String name) {
		dao.deleteEmployeeByName(name);
	}

	public void deleteEmployeeByAddress(String address) {
		dao.deleteEmployeeByAddress(address);
	}

}
