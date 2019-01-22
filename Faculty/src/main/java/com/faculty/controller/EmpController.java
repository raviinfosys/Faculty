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
public class EmpController {

	@Autowired 
	private EmpService empService;

	@GetMapping(path = "/emp")
	public @ResponseBody Iterable<Emp> getAllUsers() {
		// This returns a JSON or XML with the employees
		return empService.getEmployees();
	}

	@GetMapping(path = "/emp/{id}")
	public @ResponseBody ResponseEntity<Emp> getEmployeeById(@PathVariable("id") int empId) {
		Emp e = (Emp) empService.getEmp(empId);

		if (e == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Emp>(e, HttpStatus.OK);
	}

	@PostMapping(path = "/emp")
	public ResponseEntity<Object> createEmp(@RequestBody Emp e) {

		Emp currentEmp=empService.addEmp(e);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(currentEmp.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/emp/delete/{id}")
	public ResponseEntity<Emp> deleteEmp(@PathVariable int id) {
		Emp emp = empService.getEmp(id);
		if (emp == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		empService.removeEmp(id);
		return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path="/emp/update/{id}")
	public ResponseEntity<Emp> updateEmp(@RequestBody Emp currentEmp,@PathVariable int id)
	{
		Emp emp=empService.getEmp(id);
		if(emp==null){
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		
		currentEmp.setId(id);
		empService.addEmp(currentEmp);
		return new ResponseEntity<Emp>(HttpStatus.OK);
	}

}
