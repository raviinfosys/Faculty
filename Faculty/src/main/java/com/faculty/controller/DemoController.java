package com.faculty.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faculty.entity.Emp;
import com.faculty.repository.EmpRepository;
import com.faculty.service.EmpService;
import com.faculty.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService s;

	@GetMapping(path = "/")
	public String welcomeMessage() {
		return "Hi Welcome All";
	}

	@GetMapping(path = "/ravi")
	public String getString() {
		return s.getString();
	}

	@GetMapping(path = "/list")
	public List<String> getList() {
		return s.getList();
	}

}
