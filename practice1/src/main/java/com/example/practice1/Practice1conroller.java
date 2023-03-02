package com.example.practice1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Practice1conroller {
@Autowired
Practice1service practice1service;
@PostMapping("/ins")
public Map<String, Object> insert (@RequestBody Practice1pojo practice1pojo)
{
	return practice1service.insert(practice1pojo);
}
@PutMapping("/update")
public Map<String, Object> update (@RequestBody Practice1pojo practice1pojo)
{
	return practice1service.update(practice1pojo);
}
@GetMapping("/getdata")
public List getd()
{
	 return practice1service.getdata();
}

}
