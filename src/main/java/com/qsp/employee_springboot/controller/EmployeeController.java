package com.qsp.employee_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_springboot.dao.EmployeeDao;
import com.qsp.employee_springboot.dto.Employee;
import com.qsp.employee_springboot.repo.EmployeeRepo;
import com.qsp.employee_springboot.service.EployeeService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EployeeService service;

	// Save
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PostMapping("/saveAll")
	public List<Employee> saveEmployee(@RequestBody List<Employee> employee) {
		return service.saveEmployee(employee);
	}

	// Find
	@GetMapping("/all")
	public List<Employee> findAll() {
		return service.findAll();
	}

	@GetMapping("/findById")
	public Optional<Employee> findById(int id) {
		return service.findById(id);
	}

	@GetMapping("/findByEmail")
	public Employee findByEmail(String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/findByName")
	public List<Employee> findByName(String name) {
		return service.findByName(name);
	}

	@GetMapping("/findByPhone")
	public Employee findByPhone(long phone) {
		return service.findByPhone(phone);
	}

	@GetMapping("/findByAddress")
	public List<Employee> findByAddress(String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/findByDesignation")
	public List<Employee> findByDesignation(String designation) {
		return service.findByDesignation(designation);
	}

	@GetMapping("/login")
	public String login(@RequestParam String userName, @RequestParam String password) {

		return service.login(userName, password);
	}

	@GetMapping("/lessThan")
	public List<Employee> findBySalaryLessThan(double salary) {
		return service.findBySalaryLessThan(salary);
	}

	@GetMapping("/greaterThan")
	public List<Employee> findBySalaryGreaterThan(double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

	@GetMapping("/between")
	public List<Employee> findBySalaryBetween(double salary1, double salary2) {
		return service.findBySalaryBetween(salary1, salary2);
	}

	// update
	@PatchMapping("/update/email/{id}/{email}")
	public Employee updateEmployeeEmailById(@PathVariable int id, @PathVariable String email) {
		return service.updateEmployeeEmailById(id, email);
	}

	@PatchMapping("/update/phone/{id}/{phone}")
	public Employee updateEmployeePhoneById(@PathVariable int id, @PathVariable long phone) {
		return service.updateEmployeePhoneById(id, phone);
	}

	@PatchMapping("/update/password/{id}/{password}")
	public Employee updateEmployeePasswordById(@PathVariable int id, @PathVariable String password) {
		return service.updateEmployeePasswordById(id, password);
	}

	@PatchMapping("/update/salary/{id}/{salary}")
	public Employee updateEmployeeSalaryById(@PathVariable int id, @PathVariable double salary) {
		return service.updateEmployeeSalaryById(id, salary);
	}

	@PatchMapping("/update/designation/{id}/{designation}")
	public Employee updateEmployeeDesignationById(@PathVariable int id, @PathVariable String designation) {
		return service.updateEmployeeDesignationById(id, designation);
	}

	@PatchMapping("/update/name/{id}/{name}")
	public Employee updateEmployeeNameById(@PathVariable int id, @PathVariable String name) {
		return service.updateEmployeeNameById(id, name);
	}

	@PatchMapping("/update/password/{email}/{password}")
	public Employee updateEmployeePasswordByEmail(@PathVariable String email, @PathVariable String password) {
		return service.updateEmployeePasswordByEmail(email, password);
	}

	@PatchMapping("/update/password/{phone}/{password}")
	public Employee updateEmployeePasswordByPhone(@PathVariable long phone, @PathVariable String password) {
		return service.updateEmployeePasswordByPhone(phone, password);
	}

	@PatchMapping("/update/all")
	public Employee updateEmployee(@RequestBody Employee updatedEmployee) {
		return service.updateEmployee(updatedEmployee);
	}
	// delete

	@DeleteMapping("/delete/{id}")
	public void deleteEmployeeById(@PathVariable int id) {
		service.deleteEmployeeById(id);
	}

	@DeleteMapping("/delete/byEmail/{email}")
	public void deleteEmployeeByEmail(@PathVariable String email) {
		service.deleteEmployeeByEmail(email);
	}

	@DeleteMapping("/delete/byPhone/{phone}")
	public void deleteEmployeeByPhone(@PathVariable long phone) {
		service.deleteEmployeeByPhone(phone);
	}

	@DeleteMapping("/delete/byName/{name}")
	public void deleteEmployeeByName(@PathVariable String name) {
		service.deleteEmployeeByName(name);
	}

	@DeleteMapping("/delete/byAddress/{address}")
	public void deleteEmployeeByAddress(@PathVariable String address) {
		service.deleteEmployeeByAddress(address);
	}

	@DeleteMapping("/delete/all")
	public void deleteAllEmployees() {
		service.deleteAllEmployees();
	}

}
