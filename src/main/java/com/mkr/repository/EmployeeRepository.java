	package com.mkr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mkr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
