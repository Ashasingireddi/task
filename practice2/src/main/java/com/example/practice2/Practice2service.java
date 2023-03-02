package com.example.practice2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Practice2service {
@Autowired
JdbcTemplate jdbcTemplate;
	public int ins(Practice2pojo practice2pojo) {
		  int id = practice2pojo.getId();
		 String name=practice2pojo.getName();
		int i= 0;
				try
				{
		String s = "insert into ashadevi  values(?,?)";
				i= jdbcTemplate.update(s,id,name);
				} catch (Exception e)
				{
					System.out.println(e);
				}
				return i;
	}
	public List getdata() {
		String getquery = "select* from ashadevi";
		return jdbcTemplate. queryForList(getquery);
		
	}
	public int update(Practice2pojo practice2pojo) {
		int id = practice2pojo.getId();
		 String name=practice2pojo.getName();
		int i =0;
		try{
			String str="update ashadevi set name=? where id=?";
			i=jdbcTemplate.update(str,name,id);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return i;
	}
	public int delete(Practice2pojo practice2pojo) {
		int id = practice2pojo.getId();
		 int i =0;
		try {
			String st ="delete  from ashadevi where id=? ";
			i=jdbcTemplate.update(st,id);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return i;
	}
}
