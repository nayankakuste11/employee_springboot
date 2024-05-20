package com.qsp.employee_springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.employee_springboot.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByPhone(long phone);

	Employee findByEmail(String email);
	
	List<Employee> findByName(String name);
	
	List<Employee> findByAddress(String address);
//	Optional<Employee> findByE(String email);

	List<Employee> findBySalaryLessThan(double salary);

	List<Employee> findBySalaryGreaterThan(double salary);

	List<Employee> findBySalaryBetween(double salary1, double salary2);

	List<Employee> findByDesignation(String designation);

	



//	  Employee findByPhone(long phone);
//
//	    String deleteByPhone(long phone);
//
//	    String deleteByEmail(String email);

//	    List<Employee> getByEmail(String email);
//
//	    @Query("SELECT e FROM Employee e WHERE e.address = ?1")
//	    List<Employee> employeeByAddress(String address);
//
//	    @Query("SELECT e FROM Employee e WHERE e.name = ?1")
//	    List<Employee> employeeByName(String name);
}
