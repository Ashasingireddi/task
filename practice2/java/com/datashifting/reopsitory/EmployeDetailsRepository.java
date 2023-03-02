package com.datashifting.reopsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datashifting.model.EmployeDetails;

public interface EmployeDetailsRepository extends JpaRepository<EmployeDetails, Integer>{


	

	void save(List<EmployeDetails> list1);

}
