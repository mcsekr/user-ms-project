package in.co.practice.ms.read.single.record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.co.practice.ms.read.single.record.dto.EmployeeDto;
import in.co.practice.ms.read.single.record.exceptions.NoEmployeePresentException;
import in.co.practice.ms.read.single.record.service.EmployeeService;

@RestController
public class EmplController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees/{empId}")
	public ResponseEntity<Object> saveEmployee(@PathVariable Integer empId) throws NoEmployeePresentException {
		EmployeeDto result = service.getSingleEmployee(empId);
	
		return ResponseEntity.status(HttpStatus.OK).body(result);

	}

	

}
