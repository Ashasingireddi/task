package com.example.practice1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class Practice1service {
@Autowired
JdbcTemplate jdbcTemplate;
	public Map<String, Object> insert(Practice1pojo practice1pojo) {
		int id=practice1pojo.getId();
        String name=practice1pojo.getName();
        Map<String,Object> object = new HashMap<>();
        try
        {
        	String query = "insert into ashadevi values(?,?)";
        	int res = jdbcTemplate.update(query,id,name);
        	if (res>0)
        	{
        	object.put("inserted", "succesfully");
        	}
        	else
        	{
        		object.put("not inserted", "succesfully");
        	}
        } catch (Exception e) {
			System.out.println(e);
		}
		return object;
	}
	public Map<String, Object> update(Practice1pojo practice1pojo) {
		int id = practice1pojo.getId();
		String name= practice1pojo.getName();
		Map <String, Object> obj= new HashMap<>();
		try
		{
			String query= "update ashadevi set name=?, where id=?";
					int res= jdbcTemplate.update(query,id,name);
			if(res>0)
			{
				obj.put("inserted", "succesfully");
			}
			else
			{
				obj.put("not inserted", "succesfully");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return obj;
	
	}
	public List getdata() {
		String getquery = "select* from ashadevi";
		return jdbcTemplate. queryForList(getquery);
		
	}}
			
	



