package com.mkr.controller;

import com.mkr.service.RegistrationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkr.controller.utils.EmailSender;
import com.mkr.dto.RegistrationDTO;
import com.mkr.entity.Employee;

@Controller
public class EmployeeController {

	@Autowired
	RegistrationService registrationService;
	
	@Autowired
	private EmailSender emailSender;

	@RequestMapping("/register")
	public String viewIndex() {
		return "registration";
	}

	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute RegistrationDTO registrationDTO, Model model) {

		registrationService.saveRegistrationDetails(registrationDTO);
		emailSender.sendEmail(registrationDTO.getEmail(),"requesting soft behavior", "Please dont bite -thanks and regards -ur chinnodu");
		model.addAttribute("msg", "Record saved successfully");
		return "registration";

	}

//	@RequestMapping("/demoReg")
//	public String viewDemo() {
//		return "demo";
//	}

	/*
	 * @RequestMapping("/saveDemoReg") public String saveDemoReg(
	 * 
	 * @RequestParam String firstName,
	 * 
	 * @RequestParam String lastName,
	 * 
	 * @RequestParam String email,
	 * 
	 * @RequestParam String mobile,ModelMap modelMap) {
	 * registrationService.saveEmployeeDetailsUsingRequestParam(firstName,lastName,
	 * email,mobile); modelMap.addAttribute("msg","Demo record saved"); return
	 * "demo"; }
	 */

	@RequestMapping("/list")
	public String listRegistration(Model model) {
		List<Employee> employeeDetails = registrationService.getEmployeeDetails();
		model.addAttribute("emp", employeeDetails);
		return "list_registration";

	}

	@RequestMapping("/deleteRegistration")
	public String deleteByid(@RequestParam long id, ModelMap model) {
		registrationService.deleteById(id);

		List<Employee> employeeDetails = registrationService.getEmployeeDetails();
		model.addAttribute("emp", employeeDetails);
		return "list_registration";
	}

	@RequestMapping("/getEmployeeDetailsById")
	public String getEmployeeDetails(@RequestParam Long id, Model model) {
		Employee employee = registrationService.getEmployeeDetailsById(id);
		model.addAttribute("emp", employee);

		return "update_registration";
	}

	@RequestMapping("/updateReg")
	public String updateRegistration(@RequestParam Long id, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String mobile, Model model) {
		registrationService.updateEmployeeDetails(id, firstName, lastName, email, mobile);
		List<Employee> employeeDetails = registrationService.getEmployeeDetails();
		model.addAttribute("emp", employeeDetails);
		return "list_registration";
	}

	@RequestMapping("/updateRegistration")
	public String updateEmp(@ModelAttribute RegistrationDTO registrationDTO, ModelMap model) {
		registrationService.updateEmployeeDetails1(registrationDTO);

		List<Employee> employeeDetails = registrationService.getEmployeeDetails();
		model.addAttribute("emp", employeeDetails);
		return "list_registration";

	}
}
