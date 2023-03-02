package com.datashifting.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.datashifting.excel.ExcelData;
import com.datashifting.model.EmployeDetails;
import com.datashifting.service.EmployeDetailsService;

@RestController
@CrossOrigin("*")
public class EmployeDetailsController {
	@Autowired
	EmployeDetailsService employeDetailsService;
	@PostMapping("/employedetails")
	 public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {       
		
		if (ExcelData.checkExcelFormat(file)) {
           employeDetailsService.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
        }
		else
		{
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }
	}


    @GetMapping("/employedetails")
    public List<EmployeDetails> getAllProduct() {
        return employeDetailsService.getAllDetails();
    }

}

	


