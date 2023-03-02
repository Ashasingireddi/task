package com.example.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service

public class employeService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int insert(EmployePojo employePojo)
	{
		int id=employePojo.getId();
		String name=employePojo.getName();
		int i=0;
		try
		{
			String s="insert into task values(?,?)";
			i=jdbcTemplate.update(s,id,name);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
	

}
