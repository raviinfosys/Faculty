package com.faculty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faculty.entity.Emp;
import com.faculty.repository.EmpRepository;


@Service
public class EmpService {

	@Autowired 
	EmpRepository empRepository;
	
	public List<Emp> getEmployees()
	{
		List<Emp> employees=(List<Emp>)empRepository.findAll();
		return employees;
	}
	
	public Emp getEmp(int id)
	{
		Emp emp=empRepository.findOne(id);
		return emp;
	}
	
	public Emp addEmp(Emp emp)
	{
		Emp e=empRepository.save(emp);
		return e;
	}
	
	public void removeEmp(int id)
	{
		empRepository.delete(id);
	}
	
	public void updateEmp(Emp emp)
	{
		empRepository.save(emp);
	}
	
	}
