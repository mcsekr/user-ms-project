package in.co.practice.ms.read.all.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.practice.ms.read.all.dto.EmployeeDto;
import in.co.practice.ms.read.all.exceptions.DuplicateEmployeePresent;
import in.co.practice.ms.read.all.service.EmployeeService;

@RestController
public class ReadAllEmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public ResponseEntity<Object> getAllEmployees() throws DuplicateEmployeePresent {
		List<EmployeeDto> result = service.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	

}
