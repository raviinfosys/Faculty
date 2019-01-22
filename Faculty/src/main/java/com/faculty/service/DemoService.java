package com.faculty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

	public String getString()
	{
		return "ravi";
	}
	
	public List<String> getList()
	{
		ArrayList<String> a=new ArrayList<String>();
		a.add("ravi");
		a.add("kishan");
		
		return a;
	}
}
