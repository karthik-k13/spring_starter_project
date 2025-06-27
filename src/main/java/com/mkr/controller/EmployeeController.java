package com.mkr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@RequestMapping("/index")
	public String viewIndex() {
		return "index";
	}
}
