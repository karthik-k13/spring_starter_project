package com.mkr.api;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mkr.controller.utils.EmailSender;
import com.mkr.dto.APIResponse;
import com.mkr.dto.RegistrationDTO;
import com.mkr.entity.Employee;
import com.mkr.service.RegistrationService;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationControllerAPI {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private EmailSender emailSender;

	// http://localhost:8080/api/v1/registration/save
	@PostMapping("/save")
	public ResponseEntity<APIResponse<RegistrationDTO>> saveRegistrationDetails(@RequestBody RegistrationDTO dto) {
		RegistrationDTO registrationDTO = registrationService.saveRegistrationDetails(dto);
		emailSender.sendEmail(registrationDTO.getEmail(), "test subject", " test content ");
		APIResponse<RegistrationDTO> apiResponse = new APIResponse<>();
		apiResponse.setMessage("registration details saved");
		apiResponse.setStatus(201);
		apiResponse.setData(registrationDTO);
		return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<APIResponse<Employee>> getEmployeeDetailsByID(@RequestBody RegistrationDTO dto) {
		APIResponse<Employee> apiResponse = new APIResponse<>();
		try {
			Employee emp = registrationService.getEmployeeDetailsById(dto.getId());

			apiResponse.setMessage("Employee Details");
			apiResponse.setStatus(200);
			apiResponse.setData(emp);
			return new ResponseEntity<>(apiResponse, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<APIResponse<String>> deleteEmployeeByID(@RequestBody RegistrationDTO dto) {
		registrationService.deleteById(dto.getId());
		APIResponse<String> apiResponse = new APIResponse<>();
		apiResponse.setMessage("deletion successful");
		apiResponse.setStatus(200);
		String data = "employee was deleted successfuly from all records";
		apiResponse.setData(data);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);

	}

}
