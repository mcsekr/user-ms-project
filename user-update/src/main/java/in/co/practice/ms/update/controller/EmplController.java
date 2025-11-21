package in.co.practice.ms.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.co.practice.ms.update.dto.EmployeeDto;
import in.co.practice.ms.update.exceptions.DuplicateEmployeePresent;
import in.co.practice.ms.update.service.EmployeeService;

@RestController
public class EmplController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employees")
	public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto dto) throws DuplicateEmployeePresent {
		EmployeeDto result = service.saveEmployee(dto);
		System.out.println();
		
	
		return ResponseEntity.status(HttpStatus.CREATED).body(result);

	}

	

}
