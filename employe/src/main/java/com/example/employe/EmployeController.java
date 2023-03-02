package com.example.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeController {
	@Autowired
	employeService employeService;
	@PostMapping("/task")
	public String insert(@RequestBody EmployePojo employePojo)
	{
		int i=employeService.insert(employePojo);
		if(i>0)
			return "inserted";
		else
			return "not inserted";
	}

}
