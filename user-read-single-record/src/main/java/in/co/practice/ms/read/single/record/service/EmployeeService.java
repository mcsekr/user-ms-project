package in.co.practice.ms.read.single.record.service;

import in.co.practice.ms.read.single.record.dto.EmployeeDto;
import in.co.practice.ms.read.single.record.exceptions.NoEmployeePresentException;

public interface EmployeeService {

	public EmployeeDto getSingleEmployee(int empId) throws NoEmployeePresentException;

}
