package com.mkr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkr.dto.RegistrationDTO;
import com.mkr.entity.Address;
import com.mkr.entity.Employee;
import com.mkr.repository.AddressRepository;
import com.mkr.repository.EmployeeRepository;

@Service
public class RegistrationService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	AddressRepository addressRepository;

	public RegistrationDTO saveRegistrationDetails(RegistrationDTO registrationDTO) {

		Employee employee = new Employee();
		BeanUtils.copyProperties(registrationDTO, employee);
		Employee emp = employeeRepository.save(employee);

		Address address = new Address();
		BeanUtils.copyProperties(registrationDTO, address);
		Address add = addressRepository.save(address);
		
		//RegistrationDTO dto = new RegistrationDTO();
		BeanUtils.copyProperties(emp, registrationDTO);
		BeanUtils.copyProperties(add,registrationDTO);
		return registrationDTO;

	}

	public void saveEmployeeDetailsUsingRequestParam(String firstName, String lastName, String email, String mobile) {

		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setMobile(mobile);
		employeeRepository.save(emp);
	}

	public List<Employee> getEmployeeDetails() {
		List<Employee> emp = employeeRepository.findAll();
		return emp;

	}

	public void deleteById(long id) {
		employeeRepository.deleteById(id);
	}

	public Employee getEmployeeDetailsById(Long id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();

	}

	public void updateEmployeeDetails(Long id, String firstName, String lastName, String email, String mobile) {
		Employee emp = getEmployeeDetailsById(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setMobile(mobile);
		employeeRepository.save(emp);

	}

	public void updateEmployeeDetails1(RegistrationDTO registrationDTO) {

		Employee emp = new Employee();
		BeanUtils.copyProperties(registrationDTO, emp);
		employeeRepository.save(emp);
	}

}
