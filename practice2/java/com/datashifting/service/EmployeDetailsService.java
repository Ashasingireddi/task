package com.datashifting.service;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.datashifting.excel.ExcelData;
import com.datashifting.model.EmployeDetails;
import com.datashifting.reopsitory.EmployeDetailsRepository;
@Service
public class EmployeDetailsService {
	@Autowired
	EmployeDetailsRepository employeDetailsRepository;
	
	public void save(MultipartFile file)
	{
		   try {
			   System.out.println("file.getInputStream())==>"+file.getOriginalFilename());
			   System.out.println("file.getInputStream())==>"+file.getContentType());
	            List<EmployeDetails> list1 =ExcelData.convertExcelToListOfEmployeDetails(file.getInputStream());
	            System.out.println("list1==>"+list1);
	            employeDetailsRepository.saveAll(list1);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	    public List<EmployeDetails> getAllDetails() {
	        return employeDetailsRepository.findAll();
	    }
		
	}
	


