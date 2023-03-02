package com.example.practice2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Practice2controller {
@Autowired
Practice2service practice2service;
@PostMapping("/ins")
public String ins(@RequestBody Practice2pojo practice2pojo)
{
	int i= practice2service.ins(practice2pojo);
			if (i>0)
			{
				return "inserted";
			}
			else
				return "not inserted";
}
 @GetMapping("/getdata")
 public List getd()
 {
	 return practice2service.getdata();
 }
 
 @PutMapping("/update")
 public String update (@RequestBody Practice2pojo practice2pojo)
 {
 	int i =practice2service.update(practice2pojo);
 	if (i>0)
 		return "updated";
 	else
 		return "not updated";
 }
 @DeleteMapping ("/delete")
 public String delete (@RequestBody Practice2pojo demopojo )
 {
 	int i = practice2service.delete(demopojo);
 	if (i>0)
 		return "deleted";
 	else
 		return "not deleted";
}
}
